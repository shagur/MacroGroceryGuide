package edu.metrostate.ics.macrogroceryguide.model;

/**
 * Takes TDEE (total daily energy expenditure) and diet goals to calculate and store the macro
 * nutrient totals for the user.
 * Macro Percentages:
 * Protein 30%
 * Carbs 50%
 * Fats 20%
 * @author Macro Grocery Guide Group 4
 */
public class MacroTotals {
    //variables
    private double totalFatGrams;
    private double totalProteinGrams;
    private double totalCarbGrams;
    private double totalCals;
    //final variables
    private final double FAT_PERCENT = 0.20;
    private final double PROTEIN_PERCENT = 0.30;
    private final double CARB_PERCENT = 0.50;
    private final int FOUR_CAL_PER_GRAM = 4; 
    private final int NINE_CAL_PER_GRAM = 9;
    private final int WEEKLY_MULTIPLIER = 7;
    private final int CAL_VARIANCE = 500;

    /**
     * Constructor.
     * @param tdee total daily energy expenditure calculated from assessment
     * @param goal input by user
     */
    public MacroTotals(double tdee, int goal){

        if(goal == 0){
            this.totalCals = (tdee - CAL_VARIANCE);
        }else if(goal == 1){
            this.totalCals = tdee;
        }else{
            this.totalCals = (tdee + CAL_VARIANCE);
        }
        this.totalFatGrams = (calcFatGrams());
        this.totalProteinGrams = (calcProteinGrams());
        this.totalCarbGrams = (calcCarbGrams());

    }

    /**
     * Calculates the amount in grams of fat the user should have daily based on their TDEE
     * (total daily energy expenditure)
     * @precondition TDEE has been calculated
     * @return fatGrams
     */
    private double calcFatGrams() {
        return ((totalCals * FAT_PERCENT) / NINE_CAL_PER_GRAM);
    }
    /**
     * Calculates the amount in grams of protein the user should have daily based on their TDEE
     * @return proteinGrams
     */
    private double calcProteinGrams() {
        return ((totalCals * PROTEIN_PERCENT) / FOUR_CAL_PER_GRAM);
    }
    /**
     * Calculated the amount in grams of carbs the user should have daily based on their TDEE
     * @return carbGrams
     */
    private double calcCarbGrams() {
        return ((totalCals * CARB_PERCENT) / FOUR_CAL_PER_GRAM);
    }

    //getters
    /**
     * Get total fat grams user should have daily rounded to 2 decimal places.
     * @return fat in grams
     */
    public double getTotalFatGrams() {
        return Math.round(totalFatGrams * 100.00) / 100.00;
    }

    /**
     * Get total protein grams user should have daily rounded to 2 decimal places.
     * @return protein in grams
     */
    public double getTotalProteinGrams() {
        return Math.round(totalProteinGrams * 100.00) / 100.00;
    }

    /**
     * Get total carbohydrate grams user should have daily rounded to 2 decimal places.
     * @return carbs in grams
     */
    public double getTotalCarbGrams() {
        return Math.round(totalCarbGrams * 100.00) / 100.00;
    }

    /**
     * Get total calories user should have daily rounded to 2 decimal places.
     * @return calories
     */
    public double getTotalCals() {
        return Math.round(totalCals * 100.00) / 100.0;
    }

    /**
     * Get total fat grams user should have per week rounded to 2 decimal places.
     * @return fat in grams
     */
    public double getWeeklyTotalFatGrams() {
        return Math.round((totalFatGrams * WEEKLY_MULTIPLIER) * 100.00) / 100.00;
    }

    /**
     * Get total protein grams user should have per week rounded to 2 decimal places.
     * @return protein in grams
     */
    public double getWeeklyTotalProteinGrams() {
        return Math.round((totalProteinGrams * WEEKLY_MULTIPLIER) * 100.00) / 100.00;
    }

    /**
     * Get total carbohydrate grams user should have per week rounded to 2 decimal places.
     * @return carbs in grams
     */
    public double getWeeklyTotalCarbGrams() {
        return Math.round((totalCarbGrams * WEEKLY_MULTIPLIER) * 100.00) / 100.00;
    }

    /**
     * Get total calories user should have per week rounded to 2 decimal places.
     * @return
     */
    public double getWeeklyTotalCals() {
        return Math.round((totalCals * WEEKLY_MULTIPLIER) * 100.00) / 100.00;
    }

    /**
     * Custom toString method. Used for debug / testing only.
     * @return string representation of macro nutrient totals.
     */
    @Override
    public String toString() {
        return "MacroTotals{" +
                "fatGrams=" + totalFatGrams +
                ", proteinGrams=" + totalProteinGrams +
                ", carbGrams=" + totalCarbGrams +
                ", totalCals=" + totalCals +
                ", FAT_PERCENT=" + FAT_PERCENT +
                ", PROTEIN_PERCENT=" + PROTEIN_PERCENT +
                ", CARB_PERCENT=" + CARB_PERCENT +
                '}';
    }
}

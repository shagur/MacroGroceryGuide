package edu.metrostate.ics.macrogroceryguide.model;

/**
 * Class to store user assessment.
 * Sedentary = BMR x 1.2 (little or no exercise, desk job)
 * Lightly active = BMR x 1.375 (light exercise/ sports 1-3 days/week)
 * Moderately active = BMR x 1.55 (moderate exercise/ sports 6-7 days/week)
 * Very active = BMR x 1.725 (hard exercise every day, or exercising 2 xs/day)
 * @author Macro Grocery Guide Group 4
 */

public class Assessment {
    //variables
    private double pal; //physical activity level
    private User.Gender gen;
    private int age; //in years
    private double height; //in cm
    private double weight; //in kg
    private double rmrResult;
    private double tdeeResult;

    /**
     * Constructor to create an Assessment object.
     * @param gen gender enum
     * @param age age of user in years
     * @param height height in cm of the user
     * @param weight weight in kg of the user
     * @param pal  daily physical activity level indicated by the user
     */
    public Assessment(User.Gender gen, int age, double height, double weight, double pal){

        this.gen = gen;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.pal = pal;
        calculateRMR();
        calcTDEE();
    }

    /**
     * Get the physical activity level set when user completed the assessment in view
     * @return physical activity level of user on the assessment
     */
    public double getPal() {
        return pal;
    }

    /**
     * Get the age of the user in years - set when the user completed the assessment in view
     * @return age of user
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the height of the user in cm - set when the user completed the assessment in view
     * @return height of the user
     */
    public double getHeight() {
        return height;
    }

    /**
     * Get the weight of the user in kilograms - set when the user completed the assessment in view
     * @return weight of the user
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Get gender set during assessment.
     * @return gender
     */

    public User.Gender getGen() {
        return gen;
    }

    /**
     * Get the Resting Metabolic Rate of the user calculated using calculateRMR() method
     * @return resting metabolic rate of the user
     */
    public double getRmrResult() {
        return rmrResult;
    }

    /**
     * Get the total daily energy expenditure of the user. This returns the value calculated
     * by calcTDEE() method.
     * @return total daily energy expenditure of the user
     */
    public double getTdeeResult() {
        return tdeeResult;
    }

    /**
     * Calculates RMR (Resting metabolic rate) using Mifflin-St.Jeor equation
     *
     * @precondition weight in kg, height in cm and age in years
     */
    public void calculateRMR() {
        if (this.gen == User.Gender.F) {
            //Mifflin-St.Jeor equation for female
            this.rmrResult = ((((10 * weight) + (6.25 * height)) - (5 * age)) - 161);

        } else {
            //Mifflin-St.Jeor equation for male
            this.rmrResult = ((((10 * weight) + (6.25 * height)) - (5 * age)) + 5);

        }
    }
    /**
     * Calculate TDEE(Total Daily Energy Expenditure) using RMR X PAL (Physical Activity Level).
     * The TDEE will be the calories needed to maintain weight.
     * @precondition rmr has to be already calculated
     */
    public void calcTDEE(){
        this.tdeeResult = rmrResult * pal;
    }


}

package edu.metrostate.ics.macrogroceryguide.model;

/**
 * Represents one food object. Equivalent to one row from json object retrieved in ViewProtein,
 * ViewCarbs and ViewFats classes.
 * The default serving size for each food is 100 grams.
 * There are 28.4g in an ounce (oz). So to convert to ounces, multiply each value by 0.284.
 * @author Macro Grocery Guide Group 4
 */
public class Food {
    //attributes
    private String id;
    private String name;
    private String foodgroup;
    private double calories;
    //in grams
    private double fat;
    private double protein;
    private double carb;

    /**
     * Constructor
     * @param id id of Food
     * @param name name of Food
     * @param foodgroup foodgroup of Food
     * @param calories calories in Food
     * @param fat fat in grams of 100g of Food
     * @param protein protein in grams of 100g of Food
     * @param carb carb in grams of 100g of Food
     */
    public Food(String id, String name, String foodgroup, double calories, double fat,
                double protein, double carb ){
        this.id = id;
        this.name = name;
        this.foodgroup = foodgroup;
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.carb = carb;

    }

    /**
     * Get id of the food.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Get the name of the food.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get foodgroup of the food.
     * @return foodgroup
     */
    public String getFoodgroup() {
        return foodgroup;
    }

    /**
     * Get the calories in 100g of the food.
     * @return calories
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Get the grams of fat in 100g of the food.
     * @return fats
     */
    public double getFat() {
        return fat;
    }

    /**
     * Get the grams of protein in 100g of the food.
     * @return protein
     */
    public double getProtein() {
        return protein;
    }

    /**
     * Get the grams of carbohydrates in 100g of the food.
     * @return carbs
     */
    public double getCarb() {
        return carb;
    }

    /**
     * Custom implementation of toString method for food item.
     * Only used for testing / debug purposes.
     * @return string representation of food item
     */
    @Override
    public String toString() {
        return "Food{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", foodgroup='" + foodgroup + '\'' +
                ", calories=" + calories +
                ", fat=" + fat +
                ", protein=" + protein +
                ", carb=" + carb +
                '}';
    }
}

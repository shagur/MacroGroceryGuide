package edu.metrostate.ics.macrogroceryguide.model;

/**
 *
 */

public class Food {

    private String id;
    private String name;
    private String foodgroup;
    private double calories;
    //in grams
    private double fat;
    private double protein;
    private double carb;

    /**
     * The default serving size for each food is 100 grams.
     * There are 28.4g in an ounce (oz). So to convert to ounces,
     * multiply each value by 0.284.
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFoodgroup() {
        return foodgroup;
    }

    public double getCalories() {
        return calories;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarb() {
        return carb;
    }

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

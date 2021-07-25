package edu.metrostate.ics.macrogroceryguide.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement as a singleton class so we only have one instance ever of the master grocery list
 * built by the user.
 * @author Macro Grocery Guide Group 4
 */

public class GroceryGuide {

    //variables
    private List<Food> cart = new ArrayList<>();
    private double calories;
    private double proteinGrams;
    private double fatsGrams;
    private double carbsGrams;
    private static GroceryGuide singleton;

    /**
     * private no argument constructor
     */
    private GroceryGuide(){

    }

    /**
     * Get an instance of the master grocery list. Will create a new instance if it has not
     * already been created.
     * @return GroceryGuide class instance
     */
    public static GroceryGuide getInstance(){
        if(singleton == null){
            singleton = new GroceryGuide();
        }
        return singleton;
    }

    /**
     * Get instance of grocery list
     * @return list of food items
     */
    public List<Food> getGroceryList(){
        return cart;
    }

    /**
     * Add an item to the master grocery list and update the macro nutrient totals for all items
     * in the list.
     * @param foodItem
     */
    public void addItem(Food foodItem){
        cart.add(foodItem);
        //update macro nutrient totals to equal all items in cart
        calories = calories + foodItem.getCalories();
        proteinGrams = proteinGrams + foodItem.getProtein();
        fatsGrams = fatsGrams + foodItem.getFat();
        carbsGrams = carbsGrams + foodItem.getCarb();

    }

    /**
     * Remove a food item from the master grocery list. Not currently used in this program. Possibly
     * needed for future implementation.
     * @param foodItem
     */
    public void removeItem(Food foodItem){
            this.cart.remove(foodItem);
            //update macro nutrient totals to equal all items in the cart
            calories = calories - foodItem.getCalories();
            proteinGrams = proteinGrams - foodItem.getProtein();
            fatsGrams = fatsGrams - foodItem.getFat();
            carbsGrams = carbsGrams - foodItem.getCarb();
    }

    /**
     *Remove a food item from the master grocery list given the position of the item in the list.
     * Update the macro nutrient totals to equal all items in the cart.
     * @param foodItemPos
     */
    public void removeItemAtPos(int foodItemPos){
        Food foodItem = this.cart.remove(foodItemPos);
        //update macro nutrient totals to equal all items in the cart
        calories = calories - foodItem.getCalories();
        proteinGrams = proteinGrams - foodItem.getProtein();
        fatsGrams = fatsGrams - foodItem.getFat();
        carbsGrams = carbsGrams - foodItem.getCarb();

    }

    /**
     * Calories of 100g of food item.
     * @return calories rounded to 2 decimal places
     */
    public double getCalories() {
        return Math.round(calories * 100.00) / 100.00;
    }

    /**
     * Protein in grams of 100g of food item.
     * @return protein in grams rounded to 2 decimal places
     */
    public double getProteinGrams() {
        return Math.round(proteinGrams * 100.00) / 100.00;
    }

    /**
     * Fats in grams of 100g of food item.
     * @return fats in grams rounded to 2 decimal places
     */
    public double getFatsGrams() {
        return Math.round(fatsGrams * 100.00) / 100.00;
    }

    /**
     * Carbs in grams of 100g of food item.
     * @return carbs in grams rounded to 2 decimal places
     */
    public double getCarbsGrams() {
        return Math.round(carbsGrams * 100.00) / 100.00;
    }


}

package com.example.fit_in_application.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Meal  implements Serializable {

    // Indigents
    private List<String> ingredients ; /// trial
    private List<Food> foodIngredients; // patch;
    private String mealName;
    private double calories;


    public Meal()
    {
        ingredients = new ArrayList<>();
        foodIngredients = new ArrayList<>();
        mealName = "No Meal Chosen";
        calories = 0;
    }
    public Meal(String mealName, List<String> ingredients, double calories){
        this.ingredients = ingredients;
        this.mealName = mealName;
        this.calories = calories;
        this.foodIngredients = new ArrayList<>();
    }

    public Meal(String mealName, double calories, List<Food> foodIngredients){
        this.foodIngredients = foodIngredients;
        this.mealName = mealName;
        this.calories = calories;
    }

    public String getMealName() {
        return mealName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public double getCalories() {
        int cal = 0;
        if(foodIngredients.size() > 0){
            for (int i = 0; i < foodIngredients.size() ; i++) {
                cal += foodIngredients.get(i).getCalories();
            }
            return cal;
        }
        return calories;
    }

    public List<Food> getFoodIngredients() {
        return foodIngredients;
    }

    public void setFoodIngredients(List<Food> foodIngredients) {
        this.foodIngredients = foodIngredients;
    }

    @Override
    public String toString() {
        return "Meal:  Ingredients=" + ingredients +
                ", mealIngredients=" + foodIngredients +
                ", mealName:'" + mealName +", " + calories  + ": Calories";
    }
}

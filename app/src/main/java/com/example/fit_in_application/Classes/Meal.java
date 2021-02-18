package com.example.fit_in_application.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Meal  implements Serializable {

    // Indigents
    private List<String> ingredients ;
    private String mealName;
    private double calories;

    public Meal()
    {
        ingredients = new ArrayList<>();
        mealName = "No Meal Chosen";
        calories = 0;
    }
    public Meal(String mealName, List<String> ingredients, double calories){
        this.ingredients = ingredients;
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
        return calories;
    }
}

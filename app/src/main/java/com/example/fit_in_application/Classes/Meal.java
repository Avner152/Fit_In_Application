package com.example.fit_in_application.Classes;

import java.util.ArrayList;
import java.util.List;

public class Meal extends Food{

    // Indigents
    private List<String> ingredients;
    private String mealName;
    private double calories;

    private Meal()
    {
        ingredients = new ArrayList<>();
        mealName = "Untitled";

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

    public double getCalories() {
        return calories;
    }
}

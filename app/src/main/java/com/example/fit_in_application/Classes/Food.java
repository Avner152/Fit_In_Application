package com.example.fit_in_application.Classes;

import java.io.Serializable;

public class Food implements Serializable {

    private double calories;
    private String name;
    private String category;

    public Food()
    {
        name = "Null Name";
        category = "Untitled";
        calories = 0;
    }
    public Food(String category, String name, double calories){
        this.name = name;
        this.calories = calories;
        this.category = category;
    }

    public double getCalories(){
        return this.calories;
    }

    public String getName(){
        return this.name;
    }

    public String getCategorye(){
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
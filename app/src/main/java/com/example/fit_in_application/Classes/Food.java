package com.example.fit_in_application.Classes;

public class Food {
    private double calories;
    private String name;
    private String category;

    public Food(String name, double calories,String category){
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
}
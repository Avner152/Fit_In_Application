package com.example.fit_in_application.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MealEntity implements Serializable {
    private String key;
    private List<Meal> mealList;

    public MealEntity(){
        key = "meals";
        mealList = new ArrayList<>();
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public String getKey() {
        return key;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

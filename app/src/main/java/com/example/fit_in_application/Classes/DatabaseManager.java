package com.example.fit_in_application.Classes;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    List<String> foodCategoryList = new ArrayList<>();
    List<Food> foodDatabase = new ArrayList<>();

    public void addFood(){
        // diary //
        foodDatabase.add(new Food("Dairy", "Boiled Egg (1 piece)", 5.51f));
        foodDatabase.add(new Food("Dairy", "Curd (1 mk)", 7.88f));
        foodDatabase.add(new Food("Dairy", "Egg Cutlets (1 piece)", 4.6f));
        foodDatabase.add(new Food("Dairy", "Egg and Potato Curry (1 mk)", 7f));
        foodDatabase.add(new Food("Dairy", "Egg Burji (1 mk)", 9f));
        foodDatabase.add(new Food("Dairy", "Egg Cheese Toast (1 Slice)", 12f));
        foodDatabase.add(new Food("Dairy", "Egg Flip (1 glass)", 9.5f));
        foodDatabase.add(new Food("Dairy", "Egg Fried Rice (1 plate)", 4f));
        foodDatabase.add(new Food("Dairy", "Egg Masala (1 mk)", 13.4f));
        foodDatabase.add(new Food("Dairy", "Egg Omlette Sandwich (1 plate)", 27f));
        foodDatabase.add(new Food("Dairy", "Fried Egg (1 piece)", 14f));
        foodDatabase.add(new Food("Dairy", "Sweet Omlette (1 piece)", 17.79f));
        foodDatabase.add(new Food("Dairy", "Scrambled Egg (1 piece)", 6.5f));


    }

    private void createFoodList(){
        foodCategoryList.add("Dairy");   //done//
        foodCategoryList.add("Vegetables");//done//
        foodCategoryList.add("Meats");
        foodCategoryList.add("Baked Products");
        foodCategoryList.add("Cereals ,Grains and Pasta");
    }

    public List<Food> getFoodDatabase() {
        return foodDatabase;
    }
}

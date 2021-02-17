package com.example.fit_in_application.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseManager {

    private List<String> foodCategoryList = new ArrayList<>();
    private List<Food> foodDatabase = new ArrayList<>();
    private List <Meal> mealDatabase = new ArrayList<>();
    private int recommendedCalBySelectedMeal;



    public void addMeal(){

        mealDatabase.add(new Meal("Hamburger", Arrays.asList("Regular Bun", "Beef Patty", "Pickles", "Onions"), 721.9));
        mealDatabase.add(new Meal("Pizza", Arrays.asList("Tomato sauce", "Mozzarella Cheese", "Mushrooms", "black olives"), 561.4));
        mealDatabase.add(new Meal("Caesar salad", Arrays.asList("Cucumber", "Parmesan Cheese", "Eggs", "Croutons"), 481));
        mealDatabase.add(new Meal("Beef Shawarma", Arrays.asList("Beef", "Pita Bread", "Tahini", "Sliced Salad"), 1078.24));
        mealDatabase.add(new Meal("Eggnog Pancakes", Arrays.asList("Eggnog", "Butter", "Cinnamon", "Syrup"), 357.72));
        mealDatabase.add(new Meal("Baked Ravioli", Arrays.asList("Ricotta Cheese", "Ravioli", "Parmesan Cheese", "Mozzarella Cheese"), 412.24));
        mealDatabase.add(new Meal("KFC", Arrays.asList("Chicken", "Ketchup"), 867.92));

    }

    public void addFood(){
        // Diary
        foodDatabase.add(new Food("Dairy", "", 0));
        foodDatabase.add(new Food("Dairy", "Curd", 7.88f));
        foodDatabase.add(new Food("Dairy", "Fried Egg ", 14f));
        foodDatabase.add(new Food("Dairy", "Sweet Omlette ", 17.79f));
        foodDatabase.add(new Food("Dairy", "Scrambled Egg", 6.5f));
        foodDatabase.add(new Food("Dairy", "Egg", 78f));

        // Vegetables
        foodDatabase.add(new Food("Vegetables"," ",0));
        foodDatabase.add(new Food("Vegetables","Lime Split ",86f));
        foodDatabase.add(new Food("Vegetables","Sweet Potato ",86f));
        foodDatabase.add(new Food("Vegetables","Mix Vegetables",49f));
        foodDatabase.add(new Food("Vegetables","Artichoke",47f));
        foodDatabase.add(new Food("Vegetables","Green Beans",347f));
        foodDatabase.add(new Food("Vegetables","Beetroot",43f));
        foodDatabase.add(new Food("Vegetables","Corn / Maize",365f));
        foodDatabase.add(new Food("Vegetables","Peppers",40f));
        foodDatabase.add(new Food("Vegetables","Pumpkin",26f));
        foodDatabase.add(new Food("Vegetables","Asparagus",20f));
        foodDatabase.add(new Food("Vegetables","Bell Pepper",40f));
        foodDatabase.add(new Food("Vegetables","Broccoli",34f));
        foodDatabase.add(new Food("Vegetables","Carrot",41f));
        foodDatabase.add(new Food("Vegetables","Celery",16f));
        foodDatabase.add(new Food("Vegetables","Cucumber",16f));
        foodDatabase.add(new Food("Vegetables","Green Onion",32f));
        foodDatabase.add(new Food("Vegetables","Iceberg Lattice",14f));
        foodDatabase.add(new Food("Vegetables","Mushrooms",22f));
        foodDatabase.add(new Food("Vegetables","Onion",40f));
        foodDatabase.add(new Food("Vegetables","Potato",77f));
        foodDatabase.add(new Food("Vegetables","Sweet Corn",86f));
        foodDatabase.add(new Food("Vegetables","Sweet Potato",86f));
        foodDatabase.add(new Food("Vegetables","Tomato",18f));
        foodDatabase.add(new Food("Vegetables","Peas",81f));
        foodDatabase.add(new Food("Vegetables","Lemon",29f));

        // Bread
        foodDatabase.add(new Food("Bread"," ",0));
        foodDatabase.add(new Food("Bread","Baked Potato ",93f));
        foodDatabase.add(new Food("Bread","Baked Corn",108f));
        foodDatabase.add(new Food("Bread","Big White Bread",80f));
        foodDatabase.add(new Food("Bread","Big Brown Bread",69f));
        foodDatabase.add(new Food("Bread","Cream Cracker" ,35f));
        foodDatabase.add(new Food("Bread","Small White Bread ",66f));
        foodDatabase.add(new Food("Bread","Bread, toasted",270f));

        // Cereals
        foodDatabase.add(new Food("Cereals","",0));
        foodDatabase.add(new Food("Cereals","Bulgur, cooked",83f));
        foodDatabase.add(new Food("Cereals","Corn flour",363f));
        foodDatabase.add(new Food("Cereals","Macaroni",128f));
        foodDatabase.add(new Food("Cereals","Pasta",126f));
        foodDatabase.add(new Food("Cereals","Rice",130f));
        foodDatabase.add(new Food("Cereals","Wild rice",101f));
    }

    private void createFoodList(){
        foodCategoryList.add("Dairy");   //done//
        foodCategoryList.add("Vegetables");//done//
        foodCategoryList.add("Meats");
        foodCategoryList.add("Baked Products");
        foodCategoryList.add("Cereals");
    }

    public int getRecommendedCalBySelectedMeal() {
        return recommendedCalBySelectedMeal;
    }

    public void setRecommendedCalBySelectedMeal(int recommendedCalBySelectedMeal) {
        this.recommendedCalBySelectedMeal = recommendedCalBySelectedMeal;
    }

    public List<Food> getFoodDatabase() {
        return foodDatabase;
    }

    public List<Meal> getMealDatabase() {
        return mealDatabase;
    }
}

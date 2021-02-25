package com.example.fit_in_application.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseManager implements Serializable {

    private List<String> foodCategoryList = new ArrayList<>();
    private List<Food> foodDatabase = new ArrayList<>();
    private List <Meal> mealDatabase = new ArrayList<>();
    private int recommendedCalBySelectedMeal;



    public void addMeal(){

        mealDatabase.add(new Meal("Hamburger", Arrays.asList("Regular Bun Medium", "Beef Patty Ex.", "Pickles", "Onion"), 755.4));
        mealDatabase.add(new Meal("Pizza", Arrays.asList("Dough XL", "Tomato sauce", "Mozzarella Cheese", "Mushrooms", "black olives"), 561.4));
        mealDatabase.add(new Meal("Caesar salad", Arrays.asList("Cucumber","Tomato","Peppers","Carrot","Bulgur", "Parmesan Cheese Ex.", "Egg", "Croutons"), 427));
        mealDatabase.add(new Meal("Beef Shawarma", Arrays.asList("Indian shawarma","Veal shawarma","French Fries", "Pita Bread", "Tahini", "Tomato", "Cucumber", "Onion","Ketchup"), 899));
        mealDatabase.add(new Meal("Eggnog Pancakes", Arrays.asList("Eggnog","Milk","Mix Vegetables", "Butter", "Cinnamon", "Syrup"), 337f));
        mealDatabase.add(new Meal("Baked Ravioli", Arrays.asList("Ricotta Cheese", "Ravioli", "Parmesan Cheese Ex.", "Mozzarella Cheese","Mix Vegetables","Sweet Potato","Butter"), 467.61));
        mealDatabase.add(new Meal("KFC", Arrays.asList("Chicken Wings","Chicken Leg","Rice","Ketchup","French Fries","Baked Potato"), 850f));

    }

    public void addFood(){
        // Diary


        foodDatabase.add(new Food("Dairy", "", 0));
        foodDatabase.add(new Food("Dairy", "Curd", 7f));
        foodDatabase.add(new Food("Dairy", "Fried Egg ", 14f));
        foodDatabase.add(new Food("Dairy", "Sweet Omelet ", 17f));
        foodDatabase.add(new Food("Dairy", "Scrambled Egg", 6f));
        foodDatabase.add(new Food("Dairy", "Egg", 78f));
        foodDatabase.add(new Food("Dairy", "Mozzarella Cheese", 28f));
        foodDatabase.add(new Food("Dairy", "Parmesan Cheese Ex.", 129f));
        foodDatabase.add(new Food("Dairy", "Ricotta Cheese", 17f));
        foodDatabase.add(new Food("Dairy","Tahini",44f));
        foodDatabase.add(new Food("Dairy","Cinnamon",11f));
        foodDatabase.add(new Food("Dairy","Syrup",43f));
        foodDatabase.add(new Food("Dairy","Ketchup",32f));
        foodDatabase.add(new Food("Dairy","Tomato sauce",31f));
        foodDatabase.add(new Food("Dairy","Eggnog",68f));
        foodDatabase.add(new Food("Dairy","Butter",81f));
        foodDatabase.add(new Food("Dairy","Milk",80f));

        // Vegetables
        foodDatabase.add(new Food("Vegetables"," ",0));
        foodDatabase.add(new Food("Vegetables","Black olives",29f));
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
        foodDatabase.add(new Food("Vegetables","Pickles",12f));
        foodDatabase.add(new Food("Vegetables","Potato",77f));
        foodDatabase.add(new Food("Vegetables","Sweet Corn",86f));
        foodDatabase.add(new Food("Vegetables","Sweet Potato",86f));
        foodDatabase.add(new Food("Vegetables","Tomato",18f));
        foodDatabase.add(new Food("Vegetables","Peas",81f));
        foodDatabase.add(new Food("Vegetables","Lemon",29f));

        // Bread
        foodDatabase.add(new Food("Bread"," ",0));
        foodDatabase.add(new Food("Bread","Big White Bread",80f));
        foodDatabase.add(new Food("Bread","Big Brown Bread",69f));
        foodDatabase.add(new Food("Bread","Cream Cracker" ,35f));
        foodDatabase.add(new Food("Bread","Small White Bread ",66f));
        foodDatabase.add(new Food("Bread","Bread, toasted",55f));
        foodDatabase.add(new Food("Bread","Regular Bun Small",73f));
        foodDatabase.add(new Food("Bread","Regular Bun Medium",92f));
        foodDatabase.add(new Food("Bread","Regular Bun Large",168f));
        foodDatabase.add(new Food("Bread","Whole Bun Large",151f));
        foodDatabase.add(new Food("Bread","Pita Bread",155f));
        foodDatabase.add(new Food("Bread","Pita whole wheat",144f));
        foodDatabase.add(new Food("Bread","Dough XL",451f));

        // Cereals
        foodDatabase.add(new Food("Cereals","",0));
        foodDatabase.add(new Food("Cereals","Bulgur",83f));
        foodDatabase.add(new Food("Cereals","Corn flour",363f));
        foodDatabase.add(new Food("Cereals","Macaroni",128f));
        foodDatabase.add(new Food("Cereals","Pasta",126f));
        foodDatabase.add(new Food("Cereals","Rice",130f));
        foodDatabase.add(new Food("Cereals","Wild rice",101f));
        foodDatabase.add(new Food("Cereals","Baked Potato ",93f));
        foodDatabase.add(new Food("Cereals","Baked Corn",108f));
        foodDatabase.add(new Food("Cereals","Ravioli",77f));
        foodDatabase.add(new Food("Cereals","Croutons",22f));
        foodDatabase.add(new Food("Cereals","French Fries",220f));

        //Meat
        foodDatabase.add(new Food("Meat","",0));
        foodDatabase.add(new Food("Meat","Stake Entrecote",291f));
        foodDatabase.add(new Food("Meat","Stake Sinta",243f));
        foodDatabase.add(new Food("Meat","Chicken Leg",171f));
        foodDatabase.add(new Food("Meat","Indian shawarma",173f));
        foodDatabase.add(new Food("Meat","Veal shawarma",201f));
        foodDatabase.add(new Food("Meat","Chicken Breast",165f));
        foodDatabase.add(new Food("Meat","Chicken Wings",202f));
        foodDatabase.add(new Food("Meat","Beef Patty",395f));
        foodDatabase.add(new Food("Meat","Beef Patty Ex.",611f));

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

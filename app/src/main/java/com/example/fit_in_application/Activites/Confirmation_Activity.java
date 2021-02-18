package com.example.fit_in_application.Activites;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.Classes.DatabaseManager;
import com.example.fit_in_application.Classes.Food;
import com.example.fit_in_application.Classes.FoodAdapter;
import com.example.fit_in_application.Classes.Meal;
import com.example.fit_in_application.R;

import java.util.ArrayList;
import java.util.List;

public class Confirmation_Activity extends AppCompatActivity {

    private int threshold;
    private Meal chosenMeal;
    private DatabaseManager databaseManager;
    private List<String> recommendedFoodNames;
    private List<Food> recommendedFood, chosenFoodList;
    private RecyclerView choice_confirmation_RCV;
    private String WantedCategory;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_);

        chosenMeal = (Meal)getIntent().getSerializableExtra("meal"); // Meal With array list of Strings for Ingredients (food)
        databaseManager = (DatabaseManager) getIntent().getSerializableExtra("dbm"); // our Database manager
        threshold = (int) getIntent().getIntExtra("thresh", 300);

        chosenFoodList = getFoodFromString(chosenMeal.getIngredients()); // List of Food

        if(recommendedFood == null)
            recommendedFood = new ArrayList<>();

        double chosenCalorieValue = chosenMeal.getCalories();
        offerChangeIngredients(chosenMeal, databaseManager.getFoodDatabase());

        setUpRecycler();
    }


    public List<Food> getFoodFromString (List<String> ingredientNames){
        List<Food> foodList = new ArrayList<>();

        for (int i = 0; i < ingredientNames.size(); i++) {
            for (int j = 0; j < databaseManager.getFoodDatabase().size() ; j++) {
                if(databaseManager.getFoodDatabase().get(j).getName().equalsIgnoreCase(ingredientNames.get(i))) {
                    foodList.add(databaseManager.getFoodDatabase().get(j));
                    break;
                }
            }
        }
        return foodList;
    }

    private void setUpRecycler() {

        choice_confirmation_RCV = findViewById(R.id.choice_confirmation_RCV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        foodAdapter = new FoodAdapter(recommendedFood);
        foodAdapter.setTypeOfInflate(0);

        choice_confirmation_RCV.setLayoutManager(linearLayoutManager);
        choice_confirmation_RCV.setHasFixedSize(true);
        choice_confirmation_RCV.setAdapter(foodAdapter);
    }

    public int findHighestCalorie(List<Food> chosenMeal){
        Log.d("TAG", "findHighestCalorie: " + chosenMeal.toString());
        double temp = 0;
        int highFood = -1;
        for(int i = 0; i < chosenMeal.size(); i++){
            if(temp < chosenMeal.get(i).getCalories()){
                temp = chosenMeal.get(i).getCalories();
                highFood = i;
            }
        }
        return highFood;
    }

    private void offerChangeIngredients(Meal chosenMeal, List<Food> foodList) {
    // find the highest Calorie valued ingredient (of the Meal) - and hold his index:

        int highestCalorieIndex = findHighestCalorie(recommendedFood);
        if(highestCalorieIndex == -1){
            Toast.makeText(this, "No Ingredient found in your meal", Toast.LENGTH_SHORT).show();
            // not found ..
        }
        else
        {
            WantedCategory = recommendedFood.get(highestCalorieIndex).getCategorye();
            int found = 0;
            for (Food food : databaseManager.getFoodDatabase()) {
                if(food.getCategorye().equalsIgnoreCase(WantedCategory) && food.getCalories() > 0){
                    recommendedFood.add(food);
                    found = 1;
                }
                else if(found == 1 && !food.getCategorye().equalsIgnoreCase(WantedCategory)){
                 break;
                }
            }
        }


        // now we need to ask for the least valued ingredient if the user accepts the change

        // threshold = 500
        // calories of the chosen meal - chosenCalorieValue

        // for each food in Recommended food:
        // if - > chosenCalorieValue - food.getCalorie() < threshold

        // VV //

        // XX //

        // if yes - we need to:
        // 1) change the change the ingredient name
        // 2) Substract its calorie from the total calorie amount
        // 3) Add to the total calorie amount the new item calorie Value

        // if not - nothing
    }


}
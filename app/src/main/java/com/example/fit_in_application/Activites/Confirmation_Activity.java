package com.example.fit_in_application.Activites;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fit_in_application.Classes.DatabaseManager;
import com.example.fit_in_application.Classes.Food;
import com.example.fit_in_application.Classes.Meal;
import com.example.fit_in_application.R;

import java.util.List;

public class Confirmation_Activity extends AppCompatActivity {

    private int threshold;
    private double mealCalorie;
    private Meal chosenMeal;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_);

        chosenMeal = (Meal)getIntent().getSerializableExtra("meal");
        databaseManager = (DatabaseManager) getIntent().getSerializableExtra("dbm");

        Log.d("TAG>>>>>", chosenMeal.getMealName());
       // offerChangeIngredients(chosenMeal, databaseManager.getFoodDatabase());
    }

    private void offerChangeIngredients(Meal chosenMeal, List<Food> foodList) {
    // find the highest Calorie valued ingredient (of the Meal) - and hold his index:
        //       int findHighestCalorie();

        // for this we will sort the ingredients

        // now we need to find the type of this ingredient by simple check.

        // Now we need to sort the array by Category and Calorie

        // now we need to check ask for the least valued ingredient if the user accepts the change

        // if yes - we need to:
        // 1) change the change the ingredient name
        // 2) Substract its calorie from the total calorie amount
        // 3) Add to the total calorie amount the new item calorie Value

        // if not - nothing
    }


}
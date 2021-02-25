package com.example.fit_in_application.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.Classes.DatabaseManager;
import com.example.fit_in_application.Classes.Food;
import com.example.fit_in_application.Classes.FoodAdapter;
import com.example.fit_in_application.Classes.Meal;
import com.example.fit_in_application.Classes.MealEntity;
import com.example.fit_in_application.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import static com.example.fit_in_application.Activites.Selection_Activity.BREAKFAST_THRESHOLD;
import static com.example.fit_in_application.Activites.Selection_Activity.LUNCH_THRESHOLD;

public class Confirmation_Activity extends AppCompatActivity {

    public static final String MAP_KEY = "meals";

    // Preemptive variables:
    private int threshold, highestCalorieIndex = -1;
    private double totalCalorieValue;

    // Objects:
    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseManager databaseManager;
    private FoodAdapter foodAdapter, foodAdapter2;
    private Meal chosenMeal;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String WantedCategory;
    private MealEntity mealEntity;

    // Lists:
    private List<Food> recommendedFood;

    // UI Attributes:
    private Button  confirm_BTN_next;
    private ImageView confirm_meal_image;
    private RecyclerView choice_confirmation_RCV, change_confirmation_RCV;
    private TextView confirm_txtMeal, confirm_txtIngredient, confirm_txtCalories, mealTypeTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_);

        findViews();
        initFunction();
        setCardView();

        if(highestCalorieIndex > -1) {
            setUpRecyclerForFoodList();
            setUpRecyclerForMealList();
            offerChangeIngredients(chosenMeal, databaseManager.getFoodDatabase());

            foodAdapter.setOnItemClick(new FoodAdapter.OnItemClick() {
                @Override
                public void onItemClick(Food food) {
                    double cur = chosenMeal.getCalories()
                            - chosenMeal.getFoodIngredients().get(highestCalorieIndex).getCalories()
                            + food.getCalories();
                            chosenMeal.setCalories(cur);
                    confirm_txtCalories.setText("Calories: " + cur);
                    foodAdapter2.getFoodList().set(highestCalorieIndex, food);
                    foodAdapter2.notifyDataSetChanged();
                }
            });
        }
    }

    private void setUpRecyclerForMealList() {
        // Meal to Change Recycler View:
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        foodAdapter2 = new FoodAdapter(chosenMeal.getFoodIngredients());

        foodAdapter2.setTypeOfInflate(2);
        foodAdapter2.setHighestIngredientCalorie(chosenMeal.getFoodIngredients().get(highestCalorieIndex).getCalories());

        change_confirmation_RCV.setLayoutManager(linearLayoutManager2);
        change_confirmation_RCV.setHasFixedSize(true);
        change_confirmation_RCV.setAdapter(foodAdapter2);
    }

    private void findViews() {
        // init ImageView
        mealTypeTxt = findViewById(R.id.confirm_type_txt);
        confirm_txtMeal = findViewById(R.id.confirm_txtMeal);
        confirm_txtCalories = findViewById(R.id.confirm_txtCalories);
        confirm_txtIngredient = findViewById(R.id.confirm_txtIngredients);
        confirm_meal_image = findViewById(R.id.confirm_meal_image);
        confirm_BTN_next = findViewById(R.id.confirm_BTN_next);

        choice_confirmation_RCV = findViewById(R.id.choice_confirmation_RCV);
        change_confirmation_RCV = findViewById(R.id.change_confirmation_RCV);
    }


    private void initFunction() {
        // Get Extra:
        chosenMeal = (Meal)getIntent().getSerializableExtra("meal"); // Meal With array list of Strings for Ingredients (food)
        Log.d("TAG", "initFunction: " + chosenMeal.getCalories());
        databaseManager = (DatabaseManager) getIntent().getSerializableExtra("dbm"); // our Database manager
        threshold = (int) getIntent().getIntExtra("thresh", 200);


        // init Arrays:

        if(recommendedFood == null)
            recommendedFood = new ArrayList<>();

        if(chosenMeal.getFoodIngredients().size() == 0 ) {
            chosenMeal.setFoodIngredients(getFoodFromString(chosenMeal.getIngredients()));
            ; // List of Food
        }

        if(mealEntity == null)
            mealEntity = new MealEntity();

        // INIT VARIABLES:
        totalCalorieValue = chosenMeal.getCalories();
        highestCalorieIndex = findHighestCalorie(chosenMeal.getFoodIngredients());
        // Init Docs:
        DocumentReference docRef = db.collection("meals").document(firebaseUser.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    if(task.getResult() != null) {
                        mealEntity = task.getResult().toObject(MealEntity.class);
                    }
                    else
                        Log.d("TAG", "No such document");
                } else
                    Log.d("TAG", "get failed with ", task.getException());
            }
        });

        // Listeners
        confirm_BTN_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMealToFirebase();
            }
        });
    }

    private void addMealToFirebase() {
        mealEntity.setKey(MAP_KEY);
        mealEntity.getMealList().add(chosenMeal);
        db.collection(mealEntity.getKey()).document(firebaseUser.getUid()).set(mealEntity)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(Confirmation_Activity.this, HistoryTableActivity.class);
                        intent.putExtra("entity", mealEntity);
                        startActivity(intent);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Confirmation_Activity.this, "User not found", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setCardView() {
        // Set Card view:
        if(threshold == BREAKFAST_THRESHOLD) {
            confirm_meal_image.setImageResource(R.drawable.breakfast);
            mealTypeTxt.setText("-Breakfast Time!-");
        }
            else if(threshold == LUNCH_THRESHOLD) {
            confirm_meal_image.setImageResource(R.drawable.lunch);
            mealTypeTxt.setText("-Lunch Break!-");
        }

        else {
            confirm_meal_image.setImageResource(R.drawable.dinner);
            mealTypeTxt.setText("-Dinner Special!-");
        }
        confirm_txtMeal.setText(chosenMeal.getMealName());
        for (int i = 0; i < chosenMeal.getIngredients().size() ; i++) {
            confirm_txtIngredient.setText(confirm_txtIngredient.getText() + chosenMeal.getIngredients().get(i) + " | ");
        }
        confirm_txtCalories.setText(confirm_txtCalories.getText() + "" + totalCalorieValue);
    }

    private void setUpRecyclerForFoodList() {
        // Decision Recycler View:
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        foodAdapter = new FoodAdapter(recommendedFood, threshold);
        double calorieAfterSubstract = totalCalorieValue - chosenMeal.getFoodIngredients().get(highestCalorieIndex).getCalories();
        foodAdapter.setChosenMealCal(calorieAfterSubstract);

        foodAdapter.setTypeOfInflate(1);

        choice_confirmation_RCV.setLayoutManager(linearLayoutManager);
        choice_confirmation_RCV.setHasFixedSize(true);
        choice_confirmation_RCV.setAdapter(foodAdapter);
    }

    private void offerChangeIngredients(Meal chosenMeal, List<Food> foodList) {
    // find the highest Calorie valued ingredient (of the Meal) - and hold his index:

        if(highestCalorieIndex == -1){
            Toast.makeText(this, "No Ingredient found in your meal", Toast.LENGTH_SHORT).show();
        }
        else
        {
            WantedCategory = chosenMeal.getFoodIngredients().get(highestCalorieIndex).getCategory();

            // create recommended ingredient list:
            int found = 0;
            // get the array
            for (Food food : databaseManager.getFoodDatabase()) {
                if(food.getCategory().equalsIgnoreCase(WantedCategory) && food.getCalories() > 0){
                    recommendedFood.add(food);
                    found = 1;
                }
                else if(found == 1 && !food.getCategory().equalsIgnoreCase(WantedCategory))
                 break;
            }
        }
    }
    public List<Food> getFoodFromString (List<String> ingredientNames){
        List<Food> foodList = new ArrayList<>();

        for (int i = 0; i < ingredientNames.size(); i++) {
            for (int j = 0; j < databaseManager.getFoodDatabase().size() ; j++) {
                if(ingredientNames.get(i).equalsIgnoreCase(databaseManager.getFoodDatabase().get(j).getName())) {
                    foodList.add(databaseManager.getFoodDatabase().get(j));
                    j = databaseManager.getFoodDatabase().size();
                }
            }
        }
        return foodList;
    }

    public int findHighestCalorie(List<Food> chosenMeal){
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


    public interface Markable{
        boolean markItems(Food food, double totalCalorie, int thresh);
    }
}
















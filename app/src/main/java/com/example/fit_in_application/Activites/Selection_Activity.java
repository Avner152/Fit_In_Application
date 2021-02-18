package com.example.fit_in_application.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.Classes.DatabaseManager;
import com.example.fit_in_application.Classes.Food;
import com.example.fit_in_application.Classes.FoodAdapter;
import com.example.fit_in_application.Classes.Meal;
import com.example.fit_in_application.Classes.MealAdapter;
import com.example.fit_in_application.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Selection_Activity<chosenFoodInList> extends AppCompatActivity {
    public static final int BREAKFAST_THRESHOLD = 500;
    public static final int LUNCH_THRESHOLD = 1000;
    public static final int DINNER_THRESHOLD = 600;

    private int capturedTresh;
    private String chosenMealName = "";
    private double currentCalories = 0;
    private TextView mealName_tv, date_tv, ingredients_tv, calories_tv;
    private RecyclerView selec_RCV_meal, selec_RCV_food;
    private LinearLayoutManager linearLayoutManager;
    private FoodAdapter foodAdapter;
    private MealAdapter mealAdapter;
    private DatabaseManager dbm;
    private RadioButton rbBreakfast, rbLunch, rbDinner;
    private CardView cardView;
    private Button nextBtn, prevBtn;
    private Switch diySwitch;
    private Meal chosenMeal;
    private List<String> chosenFoodInList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cutOutDealer();
        setContentView(R.layout.activity_selection_);

        findViews();

        capturedTresh = 0;
        selec_RCV_food.setVisibility(View.GONE);
        if(chosenFoodInList == null)
            chosenFoodInList = new ArrayList<>();

        if(chosenMeal == null)
            chosenMeal = new Meal();


        createLists();
        setupRecyclerView();
        initViews();

    }

    private void cutOutDealer() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initViews() {
        // Buttons:
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(capturedTresh == 0)
                    Toast.makeText(Selection_Activity.this, "Please insert type of Meal...", Toast.LENGTH_SHORT).show();
                else {
                    chosenMeal.setMealName(chosenMealName);
                    chosenMeal.setCalories(currentCalories);
                    chosenMeal.setIngredients(chosenFoodInList);
                    chosenMeal.setMealName(mealName_tv.getText().toString());


                    Intent intent = new Intent(Selection_Activity.this, Confirmation_Activity.class);
                    intent.putExtra("meal", (Serializable) chosenMeal);
                    intent.putExtra("dbm", (Serializable) dbm);
                    startActivity(intent);

                }
            }
        });

        // Radio Buttons
    rbBreakfast.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            capturedTresh = BREAKFAST_THRESHOLD;
            foodAdapter.setSelectedThreshold(capturedTresh);        }
    });

        rbLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capturedTresh = LUNCH_THRESHOLD;
                foodAdapter.setSelectedThreshold(capturedTresh);
            }
        });

        rbDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capturedTresh = DINNER_THRESHOLD;
                foodAdapter.setSelectedThreshold(capturedTresh);
            }
        });

        // Switch
        diySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                currentCalories = 0;
                if(chosenFoodInList != null)
                    chosenFoodInList.clear();

                initText();
                if(isChecked) {
                    selec_RCV_food.setVisibility(View.VISIBLE);
                    selec_RCV_meal.setVisibility(View.GONE);
                }
                    else {
                    selec_RCV_food.setVisibility(View.GONE);
                    selec_RCV_meal.setVisibility(View.VISIBLE);
                }
            }

            private void initText() {
                mealName_tv.setText("Meal: ");
                ingredients_tv.setText("Ingredients: ");
                calories_tv.setText("Calories: ");
            }
        });

        // CardView:
        mealAdapter.setOnItemClickListener(new MealAdapter.OnItemClickListener() {


            @Override
            public void onItemClickListener(int position) {
                //
            }

            // meal on cardView:
            @Override
            public void onItemClickListener(Meal meal) {
                chosenMealName = meal.getMealName();
                mealName_tv.setText(chosenMealName);
                date_tv.setText(new Date().toString());
                String ingred = "";
                for (int i = 0; i < meal.getIngredients().size(); i++) {
                    ingred += meal.getIngredients().get(i) + " | ";
                    chosenFoodInList.add(meal.getIngredients().get(i));
                }

               ingredients_tv.setText("Ingredients: " + ingred);
               currentCalories = meal.getCalories();
               calories_tv.setText("Calories: "  + currentCalories);
            }
        });

        // Food on cardView:
        foodAdapter.setOnItemClick(new FoodAdapter.OnItemClick() {
            @Override
            public void onItemClick(Food food) {
                chosenMealName = "Do it Yourself";
                mealName_tv.setText(chosenMealName);
                date_tv.setText(new Date().toString());
                if(food.getCalories() != 0)
                    ingredients_tv.setText(ingredients_tv.getText() + food.getName() + " | ");
                currentCalories += food.getCalories();
                calories_tv.setText("Calories: " + currentCalories);

                //Chosen Meal:
                chosenFoodInList.add(food.getName());
            }
        });

    }


    private void setupRecyclerView() {
        // Food //
        selec_RCV_food = findViewById(R.id.selec_RCV_food);
        linearLayoutManager = new LinearLayoutManager(this);
        foodAdapter = new FoodAdapter(dbm.getFoodDatabase());
        selec_RCV_food.setLayoutManager(linearLayoutManager);
        selec_RCV_food.setHasFixedSize(true);
        selec_RCV_food.setAdapter(foodAdapter);


        // Meals //
        selec_RCV_meal = findViewById(R.id.selec_RCV_meal);
        linearLayoutManager = new LinearLayoutManager(this);
        mealAdapter = new MealAdapter(dbm.getMealDatabase());
        selec_RCV_meal.setLayoutManager(linearLayoutManager);
        selec_RCV_meal.setHasFixedSize(true);
        selec_RCV_meal.setAdapter(mealAdapter);
    }

    private void createLists() {
        if(dbm == null)
            dbm = new DatabaseManager();

        dbm.addFood();
        dbm.addMeal();
        String tmp;
        for (Food f: dbm.getFoodDatabase() ) {
            tmp = f.getCategorye();
            Log.d("TEMP", ": " + tmp + ", " + f.getName());
        }
    }

    private void findViews() {
    nextBtn = findViewById(R.id.selec_BTN_next);
    prevBtn = findViewById(R.id.selec_BTN_prev);
    selec_RCV_food = findViewById(R.id.selec_RCV_food);
    selec_RCV_meal = findViewById(R.id.selec_RCV_meal);
    rbBreakfast = findViewById(R.id.selec_rb_breakfast);
    rbLunch =  findViewById(R.id.selec_rb_lunch);
    rbDinner = findViewById(R.id.selec_rb_dinner);
    diySwitch = findViewById(R.id.diy_switch);
    cardView = findViewById(R.id.meal_CV);
    mealName_tv = findViewById(R.id.txtMeal);
    date_tv = findViewById(R.id.txtAddedDate);
    ingredients_tv = findViewById(R.id.txtIngredients);
    calories_tv = findViewById(R.id.txtCalories);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}

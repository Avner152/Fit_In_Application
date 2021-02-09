package com.example.fit_in_application.Activites;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.Classes.DatabaseManager;
import com.example.fit_in_application.Classes.Food;
import com.example.fit_in_application.Classes.FoodAdapter;
import com.example.fit_in_application.R;

public class Selection_Activity extends AppCompatActivity {

    private ArrayAdapter<CharSequence> breakfastAdapter, lunchAdapter, dinnerAdapter;
    private RecyclerView selec_RCV_food;
    private LinearLayoutManager linearLayoutManager;
    private FoodAdapter foodAdapter;
    private DatabaseManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_);
        findViews();
        createLists();
        setupRecyclerView();
        initViews();
    }

    private void initViews() {
    }

    private void setupRecyclerView() {
        selec_RCV_food = findViewById(R.id.selec_RCV_food);
        linearLayoutManager = new LinearLayoutManager(this);
        foodAdapter = new FoodAdapter(dbm.getFoodDatabase());
        selec_RCV_food.setLayoutManager(linearLayoutManager);
        selec_RCV_food.setHasFixedSize(true);
        selec_RCV_food.setAdapter(foodAdapter);

    }

    private void createLists() {
        if(dbm == null)
            dbm = new DatabaseManager();

        dbm.addFood();
        String tmp;
        for (Food f: dbm.getFoodDatabase() ) {
            tmp = f.getCategorye();
            Log.d("TEMP", ": " + tmp + ", " + f.getName());

        }
    }



    private void findViews() {
    selec_RCV_food = findViewById(R.id.selec_RCV_food);
    }

}
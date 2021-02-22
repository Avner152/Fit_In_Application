package com.example.fit_in_application.Activites;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.Classes.Fragment_map;
import com.example.fit_in_application.Classes.Meal;
import com.example.fit_in_application.Classes.MealAdapter;
import com.example.fit_in_application.Classes.MealEntity;
import com.example.fit_in_application.Fragments.FragmentTable;
import com.example.fit_in_application.R;

import java.util.List;

public class HistoryTableActivity extends AppCompatActivity implements FragmentTable.CallBack_list {

    private Fragment_map fragment_map;
    private List<Meal> mealSet;
    private LinearLayoutManager linearLayoutManager;
    private MealAdapter mealAdapter;
    private RecyclerView history_RCV_meal;
    private double d1, d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cutOutDealer();
        setContentView(R.layout.activity_history_table);

        MealEntity mealEntity = (MealEntity) getIntent().getSerializableExtra("entity");
        mealSet = mealEntity.getMealList();
        findViews();

        setupRecyclerView();

        fragment_map = new Fragment_map();
        getSupportFragmentManager().beginTransaction().add(R.id.score_LAY_map, fragment_map).commit();
    }

    private void setupRecyclerView() {
        // Meals //
        history_RCV_meal = findViewById(R.id.history_RCV_meal);
        linearLayoutManager = new LinearLayoutManager(this);

        mealAdapter = new MealAdapter(mealSet);
        mealAdapter.setTypeOfInflate(1);

        history_RCV_meal.setLayoutManager(linearLayoutManager);
        history_RCV_meal.setHasFixedSize(true);
        history_RCV_meal.setAdapter(mealAdapter);
    }

    private void cutOutDealer() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void findViews() {
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    public void onScoreSampleListener(double d1, double d2) {

    }
}
package com.example.fit_in_application.Activites;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.R;

public class Selection_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner breakfastSpinner, lunchSpinner, dinnerSpinner;
    private ArrayAdapter<CharSequence> breakfastAdapter, lunchAdapter, dinnerAdapter;
    private RecyclerView selec_RCV_Veg,selec_RCV_Diary,selec_RCV_Meat,selec_RCV_Cereal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_);
        findViews();
        initAdapters();

    }

    private void initAdapters() {
      // Breakfast
        breakfastAdapter = ArrayAdapter.createFromResource(this, R.array.Breakfast, android.R.layout.simple_spinner_item);
        breakfastAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        breakfastSpinner.setAdapter(breakfastAdapter);
        breakfastSpinner.setOnItemSelectedListener(this);
      // Lunch
        lunchAdapter = ArrayAdapter.createFromResource(this, R.array.Lunch, android.R.layout.simple_spinner_item);
        lunchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lunchSpinner.setAdapter(lunchAdapter);
        lunchSpinner.setOnItemSelectedListener(this);
      // dinner
        dinnerAdapter = ArrayAdapter.createFromResource(this, R.array.Dinner, android.R.layout.simple_spinner_item);
        dinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dinnerSpinner.setAdapter(dinnerAdapter);
        dinnerSpinner.setOnItemSelectedListener(this);
    }


    private void findViews() {
    breakfastSpinner = findViewById(R.id.selec_SPN_breakfast);
    lunchSpinner = findViewById(R.id.selec_SPN_lunch);
    dinnerSpinner = findViewById(R.id.selec_SPN_dinner);
    selec_RCV_Veg = findViewById(R.id.selec_RCV_col1);
    selec_RCV_Diary = findViewById(R.id.selec_RCV_col2);
    selec_RCV_Meat = findViewById(R.id.selec_RCV_col3);
    selec_RCV_Cereal = findViewById(R.id.selec_RCV_col2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String text = parent.getItemAtPosition(position).toString();
    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
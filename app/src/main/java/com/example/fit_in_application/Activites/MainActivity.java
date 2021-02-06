package com.example.fit_in_application.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fit_in_application.R;

public class MainActivity extends AppCompatActivity {

    private Button main_BTN_LogIn, main_BTN_About, main_BTN_Contact, main_BTN_Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();
    }

    private void findViews() {
            main_BTN_LogIn = findViewById(R.id.main_BTN_LogIn);
            main_BTN_About = findViewById(R.id.main_BTN_About);
            main_BTN_Contact = findViewById(R.id.main_BTN_Contact);
            main_BTN_Start = findViewById(R.id.main_BTN_Start);
    }

    private void initViews() {
        main_BTN_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // About Activity
        main_BTN_About.setOnClickListener(v -> {
           Intent intent = new Intent (MainActivity.this, About_Us_Activity.class);
           startActivity(intent);
        });

        main_BTN_Contact.setOnClickListener(v -> {
                    Intent intent = new Intent ( MainActivity.this, ContactActivity.class);
                   startActivity(intent);
        });

        main_BTN_Start.setOnClickListener(v -> {
            Intent intent = new Intent (MainActivity.this, Selection_Activity.class);
            startActivity(intent);
        });
    }


}
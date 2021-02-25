package com.example.fit_in_application.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fit_in_application.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

// Gilad Leshem 305357402
// Avner Levy 308063395

public class MainActivity extends AppCompatActivity {

    private Button main_BTN_LogIn, main_BTN_About, main_BTN_Contact, main_BTN_Start;
    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cutOutDealer();
        setContentView(R.layout.activity_main);
        findViews();
        initViews();


        // firebase:
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        //databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        if (firebaseUser != null) {
            main_BTN_Start.setVisibility(View.VISIBLE);
            main_BTN_LogIn.setText("Log Out");

        }
        else {
            main_BTN_Start.setVisibility(View.GONE);
            main_BTN_LogIn.setText("Log In");

        }

        }

    private void cutOutDealer() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void findViews() {
            main_BTN_LogIn = findViewById(R.id.main_BTN_LogIn);
            main_BTN_About = findViewById(R.id.main_BTN_About);
            main_BTN_Contact = findViewById(R.id.main_BTN_Contact);
            main_BTN_Start = findViewById(R.id.main_BTN_Start);
    }

    private void initViews() {
        // Log In Activity:
        main_BTN_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firebaseUser != null) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
                else
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        // About Activity:
        main_BTN_About.setOnClickListener(v -> {
           Intent intent = new Intent (MainActivity.this, About_Us_Activity.class);
           startActivity(intent);
        });


        main_BTN_Contact.setOnClickListener(v -> {
                   Intent intent = new Intent ( MainActivity.this, ContactActivity.class);
                   startActivity(intent);
        });

        // Start Activity:
        main_BTN_Start.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, Selection_Activity.class)));


        if(firebaseUser != null){
            main_BTN_LogIn.setText("Sign out");
            main_BTN_Start.setVisibility(View.VISIBLE);
        }
        else
            main_BTN_Start.setVisibility(View.GONE);

    }

}
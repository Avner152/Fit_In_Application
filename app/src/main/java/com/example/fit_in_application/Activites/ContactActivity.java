package com.example.fit_in_application.Activites;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fit_in_application.R;

public class ContactActivity extends AppCompatActivity {

    private Button submit_contact_Btn;
    private ImageView ty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cutOutDealer();
        setContentView(R.layout.activity_contact);
        findView();
        initViews();

    }

    private void findView() {
        submit_contact_Btn = (Button) findViewById(R.id.submit_contact_Btn);
        ty = findViewById(R.id.thank_you);

    }

    private void initViews() {
        submit_contact_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ty.setVisibility(View.VISIBLE);
            }
        });
    }

    private void cutOutDealer() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
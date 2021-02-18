package com.example.fit_in_application.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fit_in_application.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterationActivity extends AppCompatActivity {

    private EditText usernameEt, emailET, passwordET;
    private Button registerBtn, logInBtn, backBtn;

    //Firebase//
    FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cutOutDealer();

        setContentView(R.layout.activity_registeration);
        findViews();

        initViews();

    }

    private void cutOutDealer() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void register(String username, String email, String password) {

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                        String userid = firebaseUser.getUid().toString();
                        reference = FirebaseDatabase.getInstance().getReference("My_Users").child(userid);


                        // Hash
                        HashMap<String, String> hashMapForUsers = new HashMap<>();
                        hashMapForUsers.put("id", userid);
                        hashMapForUsers.put("username", username);

                        reference.setValue(hashMapForUsers).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(RegisterationActivity.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
                    }
                    else
                        Toast.makeText(RegisterationActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                }
            });

    }

    private void initViews() {
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEt.getText().toString().trim();
                String email = emailET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterationActivity.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                    else {
                    register(username, email, password);
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterationActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void findViews() {
        usernameEt = findViewById(R.id.usernameET);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        registerBtn = findViewById(R.id.register_Btn);
        backBtn = findViewById(R.id.back_Btn);
    }
}
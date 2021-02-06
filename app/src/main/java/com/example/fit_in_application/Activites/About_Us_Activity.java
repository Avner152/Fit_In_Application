package com.example.fit_in_application.Activites;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fit_in_application.R;

public class About_Us_Activity extends AppCompatActivity {

    private final String CONTACT_US = strId();
    private long mBackPressed;
    private Handler handler = new Handler();
    private String newStr = "";
    private static final int DELAY = 750, TIME_INTERVAL = 1000;
    private Button about_BTN_back, about_BTN_skip;
    private int curChar = 0;
    private MediaPlayer mp;
    private TextView tv;
//    private ImageView inst_IMG_wp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us_);
        initViews();
        ViewBottons();
        startDelay();
    }

    private void ViewBottons() {
        about_BTN_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBackPressed = System.currentTimeMillis();
                Log.d("pres time", "onClick: " + mBackPressed);
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                    Log.d("pres time", "onClick: " + mBackPressed + TIME_INTERVAL);
                    Log.d("pres time", "onClick: " + System.currentTimeMillis());

                    stopDelay();
                    finish();
                }
            }
        });
        about_BTN_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(CONTACT_US);
                stopDelay();
            }
        });
    }

    private void initViews() {
        tv = findViewById(R.id.about_TXT_us);
        about_BTN_back = findViewById(R.id.about_BTN_back);
        about_BTN_skip = findViewById(R.id.about_BTN_skip);
    }

    private void playSounds(int rawId) {
        mp = MediaPlayer.create(this, R.raw.snd_kboard);
        mp.start();
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            printMyStr(++curChar);
        }
    };

    private void printMyStr(int curChar) {
        newStr += CONTACT_US.charAt(curChar);

        if (curChar < 70)
            handler.postDelayed(r, 80);
        else if (curChar < CONTACT_US.length() - 1) {
            handler.postDelayed(r, 60);
            if (!mp.isPlaying())
                mp.start();
        } else if (curChar == CONTACT_US.length() - 1)
            stopDelay();
        tv.setText(newStr);
    }

    private void stopDelay() {
        //mp.stop();
        handler.removeCallbacks(r);

    }

    private void startDelay() {
        handler.postDelayed(r, DELAY);
    }

    private String strId() {
        return "Hello, Everyone!!\n" +
                "In Fit-In, we strive to keep you fit & healthy " +
                "At cure.fit, we strive to keep you fit & healthy through a range of holistic offerings" +
                "that include fitness and yoga, healthy meals, mental wellbeing and primary care.\n" +
                "Now anyone can now stay healthy from the safety of their homes with just a single app" +
                "that helps you to #BeBetterEveryDay";
    }

    @Override
    protected void onStart() {
        Log.d("instr.", "Been Started");
        super.onStart();
        printMyStr(curChar);
        playSounds(R.raw.snd_kboard);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
        stopDelay();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL < System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Tap back button in order to exit", Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();
    }
}
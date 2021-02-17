package com.example.fit_in_application.Activites;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fit_in_application.Classes.Fragment_map;
import com.example.fit_in_application.Fragments.FragmentTable;
import com.example.fit_in_application.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryTableActivity extends AppCompatActivity implements FragmentTable.CallBack_list {

    private FragmentTable fragmentTable = new FragmentTable();
    private Fragment_map fragment_map;
    private ListView listView;
    private List<String> myList = new ArrayList<>();
    private String str;
    private double d1, d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cutOutDealer();
        setContentView(R.layout.activity_history_table);
        findViews();
//        Glide.with(this).load(R.drawable.wpnew).into(score_IMG_wp);
        // get the data from the previous intend
        // create new bundle
        // link bundle to fragment
        Bundle bundle = new Bundle();
        fragmentTable.setArguments(bundle);
        listFragManager();

        //  MAP //
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.score_LAY_list, fragmentTable).commit();

        fragment_map = new Fragment_map();
        getSupportFragmentManager().beginTransaction().add(R.id.score_LAY_map, fragment_map).commit();
    }

    private void cutOutDealer() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void listFragManager() {
        fragmentTable.setCallBackList(this);
    }

    private void findViews() {
        listView = findViewById(R.id.score_list);
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
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        Log.d("DESROYSCORES", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public void onScoreSampleListener(double d1, double d2) {

    }
}
package com.example.fit_in_application.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fit_in_application.Classes.DatabaseManager;
import com.example.fit_in_application.R;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class FragmentTable extends Fragment {
    //private Button btn;
    private CallBack_list callBackList;
    private ListView score_list;
    private String fromJson;
    private ArrayList<String> topThree;
    //private Gson gson;
    private DatabaseManager dataBase;
//    findViews();
//    initViews()

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);
        findView(v);
        Bundle bundle = getArguments();
        //initiate variables
        topThree = new ArrayList<>();
        //gson = new Gson();

        // fromJson = MySPV.getInstance().getString("myKey","");
        if (fromJson != "") {
            //  dataBase = gson.fromJson(fromJson, MyDataBase.class);}
        }
            if (dataBase    != null) {
                Log.d("DATA BASE SIZE ARRAY", "" + dataBase.getMealDatabase().size());
                for (int i = 0; i < dataBase.getMealDatabase().size(); i++) {
                    if (i == 0)
                        topThree.add("The Champion: " + dataBase.getMealDatabase().get(i).toString());
                    else if (i == 1)
                        topThree.add("2nd place: " + dataBase.getMealDatabase().get(i).toString());
                    else if (i == 2)
                        topThree.add("3rd place: " + dataBase.getMealDatabase().get(i).toString());
                    else
                        topThree.add((i + 1) + "th place:" + dataBase.getMealDatabase().get(i).toString());
                }
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, topThree);
            score_list.setAdapter(adapter);

            initViews();
            return v;
        }

    private void findView(View v) {
        score_list = v.findViewById(R.id.score_list);
    }


    public interface CallBack_list{
        void onScoreSampleListener(double d1, double d2);
    }

    public void setCallBackList(CallBack_list callBackList) {
        this.callBackList = callBackList;
    }

    private void initViews() {
    }


}

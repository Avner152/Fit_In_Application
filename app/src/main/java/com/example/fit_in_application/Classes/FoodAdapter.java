package com.example.fit_in_application.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foodList;
    private int chosenMealPosition;
    private String chosenMealCat, chosenMealName;
    private double chosenMealCal;

    public FoodAdapter(List<Food> list){
        foodList = list;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);

        return new FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.tvName.setText(foodList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You Chose: " + foodList.get(position).getName(), Toast.LENGTH_SHORT).show();
                chosenMealCal = foodList.get(position).getCalories();
                chosenMealCat = foodList.get(position).getCategorye();
                chosenMealName = foodList.get(position).getName();

                // send it to next calculation //
            }
        });

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }


    public static class FoodViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
        tvName = itemView.findViewById(R.id.text_Item_Name);

        }
    }
}
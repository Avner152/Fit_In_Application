package com.example.fit_in_application.Classes;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foodList;
    private int typeOfInflate;
    private double chosenMealCal;
    private OnItemClick onItemClick;
    public FoodAdapter(List<Food> list){
        foodList = list;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v;
        if(typeOfInflate == 1)
          v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item2, parent, false);
       else
           v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item3, parent, false);

        return new FoodViewHolder(v, onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        if(typeOfInflate == 1) {
            if (foodList.get(position).getCalories() == 0) {
                holder.btn_item.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
                holder.btn_item.setText("<< " + foodList.get(position).getCategorye() + " >>");
            } else
                holder.btn_item.setText(foodList.get(position).getName());
        }
        else{
            holder.tv_item.setText(foodList.get(position).getName());
        }
        }

    public void setTypeOfInflate(int typeOfInflate) {
        this.typeOfInflate = typeOfInflate;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }


    public void setChosenMealCal(double chosenMealCal) {
        this.chosenMealCal = chosenMealCal;
    }

    public double getChosenMealCal() {
        return chosenMealCal;
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }


    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private Button btn_item;
        private TextView tv_item;

        public FoodViewHolder(@NonNull View itemView, OnItemClick onItemClick) {
            super(itemView);

            if(typeOfInflate == 1) {
                btn_item = itemView.findViewById(R.id.btn_Item_Name);
                btn_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClick.onItemClick(foodList.get(getAbsoluteAdapterPosition()));
                    }
                });
            }
            else{
                tv_item = itemView.findViewById(R.id.btn_Item_Name);
                 }
        }
    }

    public interface OnItemClick{
        void onItemClick (Food food);
    }
}


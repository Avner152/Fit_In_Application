package com.example.fit_in_application.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.Activites.Confirmation_Activity;
import com.example.fit_in_application.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> implements Confirmation_Activity.Markable {

    public static final int INFLATE_FOR_BUTTON = 0;
    public static final int INFLATE_FOR_SELECTION = 1;
    public static final int INFLATE_FOR_INSTANCE_TWO = 2;
    private List<Food> foodList;
    private int typeOfInflate, threshold;
    private double chosenMealCal, highestIngredientCalorie;
    private OnItemClick onItemClick;

    public FoodAdapter(List<Food> list){
        foodList = list;
    }

    public FoodAdapter(List<Food> list, int threshold){
        this.threshold = threshold;
        foodList = list;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v;
        if(typeOfInflate == INFLATE_FOR_BUTTON)
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        else
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item3, parent, false);

        return new FoodViewHolder(v, onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        if(typeOfInflate == INFLATE_FOR_BUTTON) {
            if (foodList.get(position).getCalories() == 0) {
                holder.btn_item.setText("<< " + foodList.get(position).getCategory() + " >>");
            } else
                holder.btn_item.setText(foodList.get(position).getName());
        }
        else if (typeOfInflate == INFLATE_FOR_SELECTION){ // INFLATE_FOR_CONFIRMATION
            holder.tv_item.setText(foodList.get(position).getName());
                if(markItems(foodList.get(position), chosenMealCal, threshold))
                holder.imageView.setImageResource(R.drawable.right);
            else
                holder.imageView.setImageResource(R.drawable.wrong);
        }
        else {
            holder.tv_item.setText(foodList.get(position).getName());
           if(foodList.get(position).getCalories() == highestIngredientCalorie)
               holder.imageView.setImageResource(R.drawable.target);
           else
               holder.imageView.setImageResource(R.drawable.like);

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

    @Override
    public boolean markItems(Food food, double chosenCalorieValue, int threshold) {
            if (chosenCalorieValue + food.getCalories()  <= threshold)
                return true;
        return false;
    }


    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private Button btn_item;
        private TextView tv_item;
        private ImageView imageView;

        public FoodViewHolder(@NonNull View itemView, OnItemClick onItemClick) {
            super(itemView);

            if(typeOfInflate == INFLATE_FOR_BUTTON) {
                btn_item = itemView.findViewById(R.id.btn_Item_Name);
                btn_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClick.onItemClick(foodList.get(getAbsoluteAdapterPosition()));
                    }
                });
            }
            else {
                tv_item = itemView.findViewById(R.id.tv_Item_Name);
                imageView = itemView.findViewById(R.id.image_meal);
            }
        }
    }

    public void setHighestIngredientCalorie(double highestIngredientCalorie) {
        this.highestIngredientCalorie = highestIngredientCalorie;
    }

    public interface OnItemClick{
        void onItemClick (Food food);
    }


}


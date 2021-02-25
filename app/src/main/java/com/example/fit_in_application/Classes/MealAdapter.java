package com.example.fit_in_application.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fit_in_application.R;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    public static final int INFLATE_FOR_SELECTION = 0;
    public static final int INFLATE_FOR_CHOSE = 1;
    public static final int INFLATE_FOR_HISTORY = 2;

    private OnItemClickListener onItemClickListener;
    private List<Meal> mealList;
    private int typeOfInflate;


    public MealAdapter(List<Meal> mealList) {
        this.mealList = mealList;
    }


    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        if(typeOfInflate == 0)
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        else
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item2, parent, false);
        return new MealViewHolder(v, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        if(typeOfInflate == INFLATE_FOR_SELECTION)
            holder.mealBtn.setText(mealList.get(position).getMealName());
        else
        {
            holder.tvMeal.setText(mealList.get(position).getMealName());
            String str = "";
            for (Food food: mealList.get(position).getFoodIngredients()) {
                str += (food.getName() + " | " );
            }
            holder.tvIndeg.setText(str);
            holder.tvCalorie.setText(holder.tvCalorie.getText() + (mealList.get(position).getCalories() + ""));
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public class MealViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMeal, tvCalorie, tvIndeg;
        private Button mealBtn;

        public MealViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            if (typeOfInflate == INFLATE_FOR_SELECTION) {
                mealBtn = itemView.findViewById(R.id.btn_Item_Name);
                mealBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClickListener(mealList.get(getAbsoluteAdapterPosition()));
                    }
                });

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onItemClickListener != null) {
                            int pos = getBindingAdapterPosition();
                            onItemClickListener.onItemClickListener(pos);
                        }
                    }
                });
            }

            else {
                tvMeal = itemView.findViewById(R.id.meal_name_history);
                tvIndeg = itemView.findViewById(R.id.meal_Ingredients_history);
                tvCalorie = itemView.findViewById(R.id.meal_Calorie_history);
                if (typeOfInflate == INFLATE_FOR_CHOSE){
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int pos = getAbsoluteAdapterPosition();

                        }
                    });
                }
            }
        }

    }

    public interface OnItemClickListener {
        void onItemClickListener(int position);
        void onItemClickListener(Meal meal);
    }

    public void setTypeOfInflate(int typeOfInflate) {
        this.typeOfInflate = typeOfInflate;
    }
}
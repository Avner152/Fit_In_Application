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

    private OnItemClickListener onItemClickListener;
    private List<Meal> mealList;
    private FoodAdapter.OnItemClick onItemClick;



    public MealAdapter(List<Meal> mealList) {
        this.mealList = mealList;
    }


    @NonNull
    @Override
    public MealAdapter.MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);

        return new MealAdapter.MealViewHolder(v, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MealAdapter.MealViewHolder holder, int position) {
        holder.mealBtn.setText(mealList.get(position).getMealName());
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public class MealViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMeal, tvDate, tvIndeg;
        private Button mealBtn;

        public MealViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
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
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position);
        void onItemClickListener(Meal meal);
    }

}
package edu.metrostate.ics.macrogroceryguide.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.metrostate.ics.macrogroceryguide.R;
import edu.metrostate.ics.macrogroceryguide.model.Food;

/**
 * Adapter for Recycler View to display food items from protein, fats and carbs lists properly
 * @author Macro Grocery Guide Group 4
 */

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.MyViewHolder> {

    private List<Food> foodList;
    private Context context;
    private OnItemClickListener onItemListener;

    /**
     * Constructor
     * @param context current context
     * @param foodList list to be displayed
     */
    public FoodRecyclerAdapter(Context context, List<Food> foodList, OnItemClickListener onItemListener){
        this.context = context;
        this.foodList = foodList;
        this.onItemListener = onItemListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.activity_row_layout, viewGroup, false);
        return new MyViewHolder(itemView, onItemListener);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {

        Food foodItem = (Food) foodList.get(i);
        viewHolder.foodName.setText(foodItem.getName());
        viewHolder.foodCalories.setText("Calories: " + Double.toString(foodItem.getCalories()));
        viewHolder.foodFat.setText("Fats: " + Double.toString(foodItem.getFat()));
        viewHolder.foodProtein.setText("Protein: " + Double.toString(foodItem.getProtein()));
        viewHolder.foodCarb.setText("Carbs: " + Double.toString(foodItem.getCarb()));
    }

    @Override
    public int getItemCount(){
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView foodName, foodCalories, foodFat, foodProtein, foodCarb;
        OnItemClickListener onItemListener;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView, OnItemClickListener onItemListener) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodNameTextView);
            foodCalories = itemView.findViewById(R.id.foodCaloriesTextView);
            foodFat = itemView.findViewById(R.id.foodFatTextView);
            foodProtein = itemView.findViewById(R.id.foodProteinTextView);
            foodCarb = itemView.findViewById(R.id.foodCarbTextView);
            this.onItemListener = onItemListener;
            linearLayout = (LinearLayout) itemView.findViewById(R.id.macroLinearLayout);

            //attach onClickListener to the entire view holder
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            //need to call onItemClick
            onItemListener.onItemClick(getAdapterPosition());


        }
    }

    /**
     * Interface used to detect the click of an item in the displayed list and interpret it
     */
    public interface OnItemClickListener{
        //used to send the position of the clicked item
        void onItemClick(int position);

    }

}


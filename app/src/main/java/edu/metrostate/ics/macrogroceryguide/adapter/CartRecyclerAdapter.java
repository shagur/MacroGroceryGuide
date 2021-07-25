package edu.metrostate.ics.macrogroceryguide.adapter;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import edu.metrostate.ics.macrogroceryguide.model.GroceryGuide;

/**
 * Adapter for Recycler View to display food items from protein, fats and carbs lists properly
 * @author Macro Grocery Guide Group 4
 */
public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.MyViewHolder> {
    private List<Food> foodList;
    private Context context;

    /**
     * Constructor
     * @param context current context
     * @param foodList list to be displayed
     */
    public CartRecyclerAdapter(Context context, List<Food> foodList){
        this.context = context;
        this.foodList = foodList;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.activity_row_layout, viewGroup, false);
        return new MyViewHolder(itemView);
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
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView foodName, foodCalories, foodFat, foodProtein, foodCarb;

        public MyViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodNameTextView);
            foodCalories = itemView.findViewById(R.id.foodCaloriesTextView);
            foodFat = itemView.findViewById(R.id.foodFatTextView);
            foodProtein = itemView.findViewById(R.id.foodProteinTextView);
            foodCarb = itemView.findViewById(R.id.foodCarbTextView);

        }
    }


}




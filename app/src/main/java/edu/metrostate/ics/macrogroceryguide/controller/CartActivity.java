package edu.metrostate.ics.macrogroceryguide.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import edu.metrostate.ics.macrogroceryguide.R;
import edu.metrostate.ics.macrogroceryguide.adapter.CartRecyclerAdapter;
import edu.metrostate.ics.macrogroceryguide.adapter.FoodRecyclerAdapter;
import edu.metrostate.ics.macrogroceryguide.model.Food;
import edu.metrostate.ics.macrogroceryguide.model.GroceryGuide;

/**
 * Activity to serve as basis for view res/layout/activity_view_cart.xml
 * @author Macro Grocery Guide Group 4
 */
public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private RecyclerView.Adapter cartAdapter;
    private FloatingActionButton backToMainMenuFAB;
    private FloatingActionButton addItemsToCartFAB;
    private Food groceryItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        //once page opens recycler view should populate with food objects
        recyclerView = findViewById(R.id.recycleViewCart);
        cartAdapter = new CartRecyclerAdapter(getApplicationContext(),
                GroceryGuide.getInstance().getGroceryList());
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        //set the item touch helper callback to my recycler view
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(cartAdapter);

        //locate buttons
        backToMainMenuFAB = findViewById(R.id.backToMainMenuFAB);
        addItemsToCartFAB = findViewById(R.id.addItemsToCartFAB);

        //capture addItemsToCartFAB clicks
        addItemsToCartFAB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent aintent = new Intent(CartActivity.this,
                        FoodTypeNavActivity.class);
                startActivity(aintent);
            }
        });
        //capture backToMainMenuFAB clicks
        backToMainMenuFAB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent bintent = new Intent(CartActivity.this, MainNavActivity.class);
                startActivity(bintent);
            }
        });

    }
    /**
     * first param is 0 since we will not be dragging, second parameter is the swipe direction
     * can reference a constant, can have more than one constant by |
     */
    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0,
            ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT){

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView,
                              @NonNull RecyclerView.ViewHolder viewHolder,
                              @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            /**
             * reference the adapter that is being set for the recycler view to delete at position
             * inside the adapter we have the view holder that's holding each individual view
             * inside the recycler view we have access to the viewHolder and
             * getAdapterPosition() gets the position of the object
             */
            GroceryGuide.getInstance().removeItemAtPos(viewHolder.getAdapterPosition());
            //notify the recycler view adapter that something has changed
            cartAdapter.notifyDataSetChanged();
        }
    };

}



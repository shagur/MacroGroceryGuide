
package edu.metrostate.ics.macrogroceryguide.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.metrostate.ics.macrogroceryguide.R;
import edu.metrostate.ics.macrogroceryguide.adapter.FoodRecyclerAdapter;
import edu.metrostate.ics.macrogroceryguide.model.Config;
import edu.metrostate.ics.macrogroceryguide.model.Food;
import edu.metrostate.ics.macrogroceryguide.model.GroceryGuide;
import edu.metrostate.ics.macrogroceryguide.model.RequestQueueSingleton;
import edu.metrostate.ics.macrogroceryguide.model.User;

/**
 * Activity to serve as basis for res/layout/activity_view_carbs.xml
 * @author Macro Grocery Guide Group 4
 */
public class ViewCarbs extends AppCompatActivity implements FoodRecyclerAdapter.OnItemClickListener {

    //view items
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private RecyclerView.Adapter carbsAdapter;
    private FloatingActionButton backToCart;
    private FloatingActionButton addToCart;
    //variables
    private List<Food> carbsList;
    private Food carbsItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_carbs);

        //populate the fatsList with list of foods in the fats category
        getData();

        //once the page opens the recyclerView should populate with food objects
        recyclerView = findViewById(R.id.recycleViewCarbs);
        carbsList = new ArrayList<>();
        carbsAdapter = new FoodRecyclerAdapter(getApplicationContext(), carbsList, this);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(carbsAdapter);

        //locate the backToCartFAB button
        backToCart = (FloatingActionButton) findViewById(R.id.backToCartFAB);
        //capture backToCartFAB button clicks
        backToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewCarbs.this, CartActivity.class));
            }
        });
        //locate the addToCartFAB button
        addToCart = (FloatingActionButton) findViewById(R.id.addToCartFAB);
        //capture addToCartFAB clicks
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carbsItem != null){
                    GroceryGuide.getInstance().addItem(carbsItem);

                    //notify user addition successful
                    Toast.makeText(getApplicationContext(), "Item Added to Cart", Toast.LENGTH_SHORT)
                            .show();
                }else{
                    Toast.makeText(getApplicationContext(),"Please select an item", Toast.LENGTH_LONG)
                            .show();
                }

            }
        });

    }

    //Get Request for JSONObject
    public void getData(){
        final ProgressDialog loading;
        loading = new ProgressDialog(this);
        loading.setMessage("Loading...");
        loading.show();

        //RequestQueue for Handle Network Request
        RequestQueue requestQueue = RequestQueueSingleton
                .getInstance(this.getApplicationContext()).getRequestQueue();
        String url = Config.CARBS_JSON_URL;
        JSONObject jsonObject = new JSONObject();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //parse data into ArrayList

                try {
                    JSONArray arrayOfCarbsFood = (JSONArray) response.get("carbs");
                    int length = arrayOfCarbsFood.length();
                    //create food objects
                    for(int i = 0; i < length; i++){

                        JSONObject foodItem = arrayOfCarbsFood.getJSONObject(i);

                        //getting attributes of the object
                        String id = foodItem.getString("id");
                        String name = foodItem.getString("name");
                        String foodgroup = foodItem.getString("foodgroup");
                        Double calories = foodItem.getDouble("calories");
                        Double fat = foodItem.getDouble("fat");
                        Double protein = foodItem.getDouble("protein");
                        Double carbohydrate = foodItem.getDouble("carbohydrate");

                        Food itemAddToList = new Food(id, name, foodgroup, calories, fat, protein, carbohydrate);

                        carbsList.add(itemAddToList);

                    }
                } catch (JSONException ex) {
                    ex.printStackTrace();
                    loading.dismiss();

                }
                carbsAdapter.notifyDataSetChanged();
                loading.dismiss();

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                Log.d("Error.Response", error.toString());
                loading.dismiss();
            }

        });
        RequestQueueSingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

    }
    @Override
    public void onItemClick(int position) {
        carbsItem = carbsList.get(position);
    }
}


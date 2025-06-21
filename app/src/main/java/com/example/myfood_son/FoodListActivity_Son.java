package com.example.myfood_son;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import com.example.myfood_son.Adapters.FoodAdapter_Son;
import com.example.myfood_son.Models.Food_NTNSon;
import com.example.myfood_son.database.FoodDAO_Son;

import java.util.ArrayList;

public class FoodListActivity_Son extends AppCompatActivity {

    RecyclerView rcvFoods_Son;
    ArrayList<Food_NTNSon> foodList;
    FoodAdapter_Son adapter;
    FoodDAO_Son foodDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail_item);

        rcvFoods_Son = findViewById(R.id.rcvFoods_Son);
        foodDAO = new FoodDAO_Son(this);

        int restaurantId = getIntent().getIntExtra("restaurantId", -1);
        foodList = foodDAO.getByRestaurant(restaurantId);

        adapter = new FoodAdapter_Son(this, foodList);
        rcvFoods_Son.setLayoutManager(new LinearLayoutManager(this));
        rcvFoods_Son.setAdapter(adapter);
    }
}

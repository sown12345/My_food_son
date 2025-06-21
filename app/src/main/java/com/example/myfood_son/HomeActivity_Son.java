package com.example.myfood_son;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import com.example.myfood_son.Adapters.RestaurantAdapter_Son;
import com.example.myfood_son.database.RestaurantDAO_Son;
import com.example.myfood_son.Models.Restaurant_NTNSon;

import java.util.ArrayList;

public class HomeActivity_Son extends AppCompatActivity {

    RecyclerView rcvRestaurants_Son;
    ArrayList<Restaurant_NTNSon> list;
    RestaurantAdapter_Son adapter;
    RestaurantDAO_Son dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvRestaurants_Son = findViewById(R.id.rcvRestaurants_Son);
        dao = new RestaurantDAO_Son(this);
        list = dao.getAllRestaurants();

        adapter = new RestaurantAdapter_Son(this, list);
        rcvRestaurants_Son.setLayoutManager(new LinearLayoutManager(this));
        rcvRestaurants_Son.setAdapter(adapter);
    }
}

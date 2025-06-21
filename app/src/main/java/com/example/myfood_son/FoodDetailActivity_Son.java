package com.example.myfood_son;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodexample_nhmanh.adapter.FoodDetailAdapter;
import com.example.myfoodexample_nhmanh.model.Food;
import com.example.myfoodexample_nhmanh.sqlite.FoodDao;

import java.util.ArrayList;
import java.util.List;

public class FoodDetailActivity extends AppCompatActivity {

    private RecyclerView rvFoodDetail;
    private FoodDao foodDao;
    private String foodId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        // Khởi tạo RecyclerView
        rvFoodDetail = findViewById(R.id.rvFoodDetail);
        rvFoodDetail.setLayoutManager(new LinearLayoutManager(this));
        foodDao = new FoodDao(this);

        // Lấy foodId từ Intent
        foodId = getIntent().getStringExtra("foodId");
        if (foodId == null) {
            Toast.makeText(this, "Không tìm thấy ID món ăn", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Lấy dữ liệu từ cơ sở dữ liệu
        Food food = foodDao.getById(foodId);
        List<Food> foodList = new ArrayList<>();
        if (food != null) {
            foodList.add(food); // Thêm món ăn duy nhất vào danh sách
        } else {
            Toast.makeText(this, "Không tìm thấy món ăn", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Cấu hình Adapter
        FoodDetailAdapter adapter = new FoodDetailAdapter(foodList);
        rvFoodDetail.setAdapter(adapter);
    }
}
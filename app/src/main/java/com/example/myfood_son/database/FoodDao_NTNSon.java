package com.example.myfood_son.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FoodDao_NTNSon {
    private SQLiteDatabase db;

    public FoodDao_NTNSon(Context context) {
        SQLiteHelper_NTNSon helper = new SQLiteHelper_NTNSon(context);

        db = helper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Food> get(String Food_NHMAnh, String... selectArgs) {
        List<Food> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(Food_NHMAnh, selectArgs);

        while (cursor.moveToNext()) {
            Food food = new Food();
            food.setFoodID(cursor.getString(cursor.getColumnIndex("FoodID")));
            food.setFood_Name(cursor.getString(cursor.getColumnIndex("Food_Name")));
            food.setType(cursor.getString(cursor.getColumnIndex("Type")));
            food.setDescription(cursor.getString(cursor.getColumnIndex("Description")));
            food.setFood_Image(cursor.getString(cursor.getColumnIndex("Food_Image")));
            food.setResID(cursor.getString(cursor.getColumnIndex("ResID")));

            list.add(food);
        }
        return list;
    }

    public List<Food> getAll(){
        String Food_NHMAnh = "SELECT * FROM Food";

        return get(Food_NHMAnh);
    }

    public Food getById(String FoodID){
        String Food_NHMAnh = "SELECT * FROM Food WHERE FoodID = ?";

        List<Food> list = get(Food_NHMAnh, FoodID);

        return list.isEmpty() ? null : list.get(0);
    }

    public List<Food> getByResId(String resId) {
        String sql = "SELECT * FROM Food WHERE ResID = ?";
        return get(sql, resId);
    }

    public long insert(Food food){
        ContentValues values = new ContentValues();
        values.put("FoodID", food.getFoodID());
        values.put("Food_Name", food.getFood_Name());
        values.put("Type", food.getType());
        values.put("Description", food.getDescription());
        values.put("Food_Image", food.getFood_Image());
        values.put("ResID", food.getResID());

        return db.insert("Food", null, values);
    }

    public long update(Food food){
        ContentValues values = new ContentValues();
        values.put("Food_Name", food.getFood_Name());
        values.put("Type", food.getType());
        values.put("Description", food.getDescription());
        values.put("Food_Image", food.getFood_Image());

        return db.update("Food", values, "FoodID=?", new String[]{food.getFoodID()});
    }

    public long delete(String FoodID){
        return db.delete("Food", "FoodID=?", new String[]{FoodID});
    }
}

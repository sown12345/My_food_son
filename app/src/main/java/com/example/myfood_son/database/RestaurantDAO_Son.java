package com.example.myfood_son.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_son.Models.Restaurant_NTNSon;

import java.util.ArrayList;

public class RestaurantDAO_Son {
    SQLiteHelper_NTNSon dbHelper;

    public RestaurantDAO_Son(Context context) {
        dbHelper = new SQLiteHelper_NTNSon(context);
    }

    public ArrayList<Restaurant_NTNSon> getAllRestaurants() {
        ArrayList<Restaurant_NTNSon> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Restaurant_Son", null);
        while (c.moveToNext()) {
            int id = c.getInt(0);
            String name = c.getString(1);
            String address = c.getString(2);
            String image = c.getString(3);
            list.add(new Restaurant_NTNSon(id, name, address, image));
        }
        c.close();
        return list;
    }
}

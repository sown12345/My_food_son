package com.example.myfood_son.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO_Son {
    SQLiteHelper_NTNSon dbHelper;

    public UserDAO_Son(Context context) {
        dbHelper = new SQLiteHelper_NTNSon(context);
    }

    public boolean checkLogin(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM User_Son WHERE Username=? AND Password=?", new String[]{username, password});
        boolean result = c.getCount() > 0;
        c.close();
        return result;
    }

    public boolean insertUser(String name, String gender, String dob, String phone, String address, String username, String password) {
        try {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("INSERT INTO User_Son (Name, Gender, DateOfBirth, Phone, Address, Username, Password) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    new Object[]{name, gender, dob, phone, address, username, password});
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

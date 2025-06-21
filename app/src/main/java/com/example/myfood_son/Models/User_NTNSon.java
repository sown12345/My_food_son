package com.example.myfood_son.Models;

public class User_NTNSon {
    public int userId;
    public String name, gender, dateOfBirth, phone, address, username, password;

    public User_NTNSon(int userId, String name, String gender, String dateOfBirth, String phone, String address, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
    }
}
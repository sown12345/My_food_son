package com.example.myfood_son.Models;
public class Food_NTNSon {
    public int foodId;
    public String name, description, type, image;
    public double price;
    public int restaurantId;

    public Food_NTNSon(int foodId, String name, String description, String type, double price, int restaurantId, String image) {
        this.foodId = foodId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.restaurantId = restaurantId;
        this.image = image;
    }
}

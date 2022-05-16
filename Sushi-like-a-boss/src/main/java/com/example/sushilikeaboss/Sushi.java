package com.example.sushilikeaboss;

public abstract class Sushi {
    private String name;
    private int quantity;
    private double price;

    protected Sushi(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

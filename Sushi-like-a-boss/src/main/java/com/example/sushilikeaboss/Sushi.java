package com.example.sushilikeaboss;

public abstract class Sushi {
    private String name;
    private int quantity;
    private double price;

    private int time;

    protected Sushi(String name, int quantity, double price, int time) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

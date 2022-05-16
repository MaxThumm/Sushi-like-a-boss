package com.example.sushilikeaboss;

import java.util.ArrayList;

public abstract class Set {
    private String name;
    private double price;
    protected ArrayList<Sushi> content;

    protected Set(String name, double price) {
        this.name = name;
        this.price = price;
        this.content = new ArrayList<>();
    }
}

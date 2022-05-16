package com.example.sushilikeaboss;

import java.util.ArrayList;

public abstract class Set extends Sushi {
    protected ArrayList<Sushi> content;

    protected Set(String name, int quantity, double price) {
        super(name, quantity, price);
        this.content = new ArrayList<>();
    }
}

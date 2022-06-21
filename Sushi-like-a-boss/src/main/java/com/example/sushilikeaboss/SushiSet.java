package com.example.sushilikeaboss;

import java.util.ArrayList;

public abstract class SushiSet extends Sushi {
    //List of sushis contained in the set
    protected ArrayList<Sushi> content;

    protected SushiSet(String name, int quantity, double price, int time) {
        super(name, quantity, price, time);
        this.content = new ArrayList<>();
    }
}

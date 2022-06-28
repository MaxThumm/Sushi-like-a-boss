package com.example.sushilikeaboss;

import java.util.ArrayList;

public abstract class SushiSet extends Sushi {
    //List of sushis contained in the set
    protected ArrayList<Sushi> content;

    /**
     * Setup of subclass SushiSet defining which parameters need to be included
     * @param name name of sushi set
     * @param quantity amount of sushi setse
     * @param price price of set
     * @param time time to prepare set
     */
    protected SushiSet(String name, int quantity, double price, int time) {
        super(name, quantity, price, time);
        this.content = new ArrayList<>();
    }
}

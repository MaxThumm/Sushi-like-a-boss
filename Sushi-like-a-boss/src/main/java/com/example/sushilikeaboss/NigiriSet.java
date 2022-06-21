package com.example.sushilikeaboss;

public class NigiriSet extends SushiSet {
    protected NigiriSet(int quantity) {
        //defining name and price of set
        super("Nigiri Set", quantity,18.0, 120);
        //adding contents of the Nigiri Set to contents list
        content.add(new SakeNigiri(2));
    }
}

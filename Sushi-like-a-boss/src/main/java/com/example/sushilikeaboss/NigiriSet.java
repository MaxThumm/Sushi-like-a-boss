package com.example.sushilikeaboss;

import java.util.ArrayList;

public class NigiriSet extends Set {
    protected NigiriSet(int quantity) {
        //defining name and price of set
        super("Nigiri Set", quantity,18.0);
        //adding contents of the Nigiri Set to contents list
        content.add(new SakeNigiri(2));
    }
}

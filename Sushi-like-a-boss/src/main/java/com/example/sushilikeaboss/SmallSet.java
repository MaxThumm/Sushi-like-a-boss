package com.example.sushilikeaboss;

import java.util.ArrayList;

public class SmallSet extends Set {
    protected SmallSet(int quantity) {
        //defining name and price of set
        super("Small Set", quantity,18.5);
        //adding contents of the Nigiri Set to contents list
        content.add(new SakeNigiri(2));
        content.add(new UmamiNigiri(2));
    }
}

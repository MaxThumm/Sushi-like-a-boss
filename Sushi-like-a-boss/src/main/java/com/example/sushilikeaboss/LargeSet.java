package com.example.sushilikeaboss;

import java.util.ArrayList;

public class LargeSet extends Set {
    protected LargeSet(int quantity) {
        //defining name and price of set
        super("Large Set", quantity,38.9);
        //adding contents of the Nigiri Set to contents list
        content.add(new SakeNigiri(8));
        content.add(new UmamiNigiri(8));
    }
}

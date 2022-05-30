package com.example.sushilikeaboss;

import java.util.List;

public class LargeSet extends SushiSet {
    protected LargeSet(int quantity) {
        //defining name and price of set
        super("Large Set", quantity, 38.9);
        //adding contents of the Nigiri Set to contents list
        content.addAll(List.of(
                new EbiNigiri(1),
                new MaguroNigri(1),
                new SakeNigiri(1),
                new TamagoNigiri(1),
                new MaguroMaki(2),
                new KappaMaki(2),
                new DaikonMaki(2),
                new CaliforniaRoll(2),
                new SantaCruzRoll(2)
        ));
}}


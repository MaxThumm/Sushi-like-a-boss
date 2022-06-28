package com.example.sushilikeaboss;

import java.util.List;

public class SmallSet extends SushiSet {

    /**
     * Setup of small set including price, time and name
     * @param quantity amount of small sets as parameter
     */
    protected SmallSet(int quantity) {
        //defining name and price of set
        super("Small Set", quantity,18.5, 110);
        //adding contents of the Nigiri Set to contents list
        content.addAll(List.of(
                new EbiNigiri(1),
                new MaguroNigri(1),
                new SakeNigiri(1),
                new TamagoNigiri(1),
                new MaguroMaki(1),
                new KappaMaki(1),
                new DaikonMaki(1),
                new CaliforniaRoll(2),
                new SantaCruzRoll(2)
        ));
    }
}

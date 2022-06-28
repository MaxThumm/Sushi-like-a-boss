package com.example.sushilikeaboss;
import java.util.List;

public class NigriMakiSet extends SushiSet{

    /**
     * Setup of Nigiri Maki set including price, time and name
     * @param quantity amount of Nigiri Maki sets as parameter
     */
    protected NigriMakiSet (int quantity){
        super("Nigiri and Maki Set", quantity, 12, 90);
        content.addAll(List.of(
                new MaguroNigri(3),
                new SakeNigiri(3),
                new KappaMaki(1),
                new DaikonMaki (1)
        ));
    }
}

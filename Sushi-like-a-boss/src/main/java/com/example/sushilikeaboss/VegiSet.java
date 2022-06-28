package com.example.sushilikeaboss;

import java.util.List;

public class VegiSet extends SushiSet{

    /**
     * Setup of vegi set including price, time and name
     * @param quantity amount of vegi sets as parameter
     */

        protected VegiSet(int quantity) {
            //defining name and price of set
            super("Vegi Set", quantity, 33.9, 160);
            //adding contents of the Vegi Set to contents list
            content.addAll(List.of(
                    new UmamiNigiri(4),
                    new TamagoNigiri(2),
                    new KappaMaki(3),
                    new DaikonMaki (3)
            ));
        }


}

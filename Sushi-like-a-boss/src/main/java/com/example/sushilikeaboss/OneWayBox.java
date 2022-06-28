package com.example.sushilikeaboss;

public class OneWayBox extends Sushi {

    /**
     * Setup of oneway box including price, time and name
     * @param quantity amount of oneway box is entered as a parameter
     */

        protected OneWayBox(int quantity) {
            super("Oneway Box", quantity, 1, 0);
        }

}



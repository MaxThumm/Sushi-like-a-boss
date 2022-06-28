package com.example.sushilikeaboss;

public class SoySauce extends Sushi {

    /**
     * Setup of Soy Sauce including price, time and name
     * @param quantity amount of Soy Sauce is entered as a parameter
     */
    protected SoySauce(int quantity) {
        super("Soy Sauce", quantity, 0.2, 0);
    }

}

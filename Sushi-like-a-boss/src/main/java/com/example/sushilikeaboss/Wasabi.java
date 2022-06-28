package com.example.sushilikeaboss;

public class Wasabi extends Sushi{

    /**
     * Setup of Wasabi including price, time and name
     * @param quantity amount of wasabi is entered as a parameter
     */
    protected Wasabi(int quantity) {
        super("Wasabi", quantity, 0.1, 0);
    }
}

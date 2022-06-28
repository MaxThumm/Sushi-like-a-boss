package com.example.sushilikeaboss;

public class UmamiNigiri extends Sushi {

    /**
     * Setup of Umami Nigiri including price, time and name
     * @param quantity amount of Umami Nigiri Sushi is entered as a parameter
     */
    protected UmamiNigiri(int quantity) {
        super("Umami Nigiri", quantity, 2.7, 40);
    }
}

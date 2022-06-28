package com.example.sushilikeaboss;

public class AvocadoMaki extends Sushi {

    /**
     * Setup of Avocado maki including price, time and name
     * @param quantity amount of Avocado maki is entered as a parameter
     */

    protected AvocadoMaki(String name, int quantity, double price, int time) {
        super("Avocado Maki", quantity, 2.9, 15);
    }
}

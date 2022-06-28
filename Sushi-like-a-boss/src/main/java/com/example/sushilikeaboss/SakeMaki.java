package com.example.sushilikeaboss;

public class SakeMaki extends Sushi {


    /**
     * Setup of Sake Maki including price, time and name
     * @param quantity amount of Sake Maki Sushi is entered as a parameter
     */
    protected SakeMaki(String name, int quantity, double price) {
        super("Sake Maki", quantity, 3, 10);
    }
}

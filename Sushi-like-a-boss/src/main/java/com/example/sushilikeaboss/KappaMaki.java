package com.example.sushilikeaboss;

public class KappaMaki extends Sushi {

    /**
     * Setup of Kappa Maki Sushi including price, time and name
     * @param quantity amount of Kappa Maki Sushi is entered as a parameter
     */

    protected KappaMaki(int quantity) {
        super("Kappa Maki", quantity, 2.5, 30);
    }
}

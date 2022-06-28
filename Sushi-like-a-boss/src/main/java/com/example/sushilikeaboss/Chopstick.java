package com.example.sushilikeaboss;

public class Chopstick extends Sushi {

    /**
     * Setup of Chopsticks including price, time and name
     * @param quantity amount of Chopsticks is entered as a parameter
     */
    protected Chopstick(int quantity) {
        super("Chopstick", quantity, 0.1, 0);
    }

}

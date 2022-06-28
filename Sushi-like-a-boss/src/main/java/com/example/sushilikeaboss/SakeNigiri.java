package com.example.sushilikeaboss;

public class SakeNigiri extends Sushi {


    /**
     * Setup of Sake Nigiri including price, time and name
     * @param quantity amount of Sake Nigiri Sushi is entered as a parameter
     */
    protected SakeNigiri(int quantity) {
        super("Sake Nigiri", quantity, 3.5, 20);
    }
}

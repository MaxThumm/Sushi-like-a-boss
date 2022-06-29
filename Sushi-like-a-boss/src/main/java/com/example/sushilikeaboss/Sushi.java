package com.example.sushilikeaboss;

public abstract class Sushi {
    private String name;
    private int quantity;
    private double price;

    private int time;

    /**
     * Setup of class sushi defining what parameters are needed
     * @param name name of sushi
     * @param quantity amount of sushi
     * @param price price of one sushi
     * @param time time needed to prepare sushi
     */
    protected Sushi(String name, int quantity, double price, int time) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.time = time;
    }

    /**
     * getter method for sushi name
     * @return name of sushi
     */
    public String getName() {
        return name;
    }

    /**
     * getter method for quantitiy of sushis
     * @return quantitiy of sushis
     */

    public int getQuantity() {
        return quantity;
    }

    /**
     * getter method for price of sushi
     * @return price of sushi
     */
    public double getPrice() {
        return price;
    }

    /**
     * getter method for time needed to prepare sushi
     * @return time needed
     */
    public int getTime() {
        return time;
    }

    /**
     * setter method for name
     * @param name name of sushi
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter method for quantitiy
     * @param quantity quantitiy of sushi
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * setter method for price
     * @param price price of sushi
     */

    public void setPrice(double price) {
        this.price = price;
    }
}

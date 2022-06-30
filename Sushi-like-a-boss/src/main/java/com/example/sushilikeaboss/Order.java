package com.example.sushilikeaboss;

import java.util.ArrayList;

public class Order {
    //useful for later implementation. Restorant or customer could for example find specific orders by id
    private int id;
    private ArrayList<Sushi> items;
    private double total;

    private int totalTime;
    private String firstName;
    private String name;
    private int zipCode;
    private String city;
    private String street;
    private String houseNo;
    private String email;
    private DeliveryType deliveryType;
    private PaymentMethod paymentMethod;

    /**
     * Setup of an order
     * @param id unique order id handed over as a parameter
     */
    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.total = 0;
        this.firstName = "";
        this.name = "";
        this.zipCode = -1;
        this.city = "";

        this.paymentMethod = PaymentMethod.CASH;
        this.deliveryType = DeliveryType.PICKUP;
    }

    /**
    Getter for item list of order
    @return Item list of the order
     */
    public ArrayList<Sushi> getItems() {
        return items;
    }

    /**
     * Method ads item to the order and updates total amount in order
     * @param item sushi that should be added to order
     */

    public void addItem(Sushi item) {
        boolean isInItems = false;
        for (Sushi s : items) {
            if (s.getClass() == item.getClass()) {
                s.setQuantity(s.getQuantity() + item.getQuantity());
                isInItems = true;
            }
        }
        if (!isInItems) {
            this.items.add(item);
        }
        updateTotal();
        updateTime();
    }

    /**
     * Setter for delivery type
     * @param deliveryType hands delivery type to instance variable
    */
    public void setDeliveryType(DeliveryType deliveryType){
        this.deliveryType = deliveryType;
    }

    /**
     * Getter for delivery type
     * @return delivery type of instance
     */
    public DeliveryType getDeliveryType(){
        return deliveryType;
    }


    /**
     * Removes sushi items from order
     * @param item is sushi that should be removed
     */
    public void removeItem(Sushi item) {
        Sushi itemToRemove = null;
        for (Sushi s : items) {
            if (s.getClass() == item.getClass()) {
                int newQuantity = s.getQuantity() - item.getQuantity();
                if (newQuantity > 0) {
                    s.setQuantity(newQuantity);
                } else {
                    itemToRemove = s;
                }
            }
        }
        if (itemToRemove != null) {
            items.remove(itemToRemove);
        }
        updateTotal();
        updateTime();
    }


    /**
    Updating total price of the current order.
     */
    private void updateTotal() {
        double newTotal = 0;
        for (Sushi s : items) {
            newTotal = newTotal + (s.getPrice() * s.getQuantity());
        }
        total = newTotal;
    }

    /**
     * Updates the total time needed to prepare the order
     */
    private void updateTime(){
        int newTime = 0;
        for (Sushi s : items){
            newTime = newTime + (s.getTime() * s.getQuantity());
        }
        if (deliveryType == DeliveryType.EXPRESS) {
            newTime = newTime + 600;
        }
        else if (deliveryType == DeliveryType.NORMAL) {
            newTime = newTime + 1200;
        }
        totalTime = newTime;
    }

    /**
     * Returns ID of the order.
     * @return Order ID is returned.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets ID of the order.
     * @param id New int value of the ID.
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Returns total price of all products in the items list.
     * @return Integer of total price of the order.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Sets total prive of all products in the items list.
     * @param total New total price of the order.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Updates total time necessary to prepare the order and returns it.
     * @return Total preparation time of the order.
     */
    public int getTotalTime() {
        updateTime();
        return totalTime;
    }

    /**
     * Sets total time necessary to prepare the order
     * @param totalTime New total time
     */
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    /**
     * Returns first name of the customer who placed the order
     * @return First Name saved in the order
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name of the customer who placed the order
     * @param firstName First name of customer
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns last name of the customer who placed the order
     * @return Last Name saved in the order
     */
    public String getName() {
        return name;
    }

    /**
     * Sets last name of the customer who placed the order
     * @param name Last name of customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns zip code of the customer who placed the order
     * @return Zip code saved in the order
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code of the customer who placed the order
     * @param zipCode Zip code of customer
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Returns city of the customer who placed the order
     * @return City saved in the order
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city of the customer who placed the order
     * @param city City of customer
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns street of the customer who placed the order
     * @return Street saved in the order
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street of the customer who placed the order
     * @param street Street of customer
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns house or apartment number of the customer who placed the order
     * @return House number saved in the order
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * Sets house or apartment number of the customer who placed the order
     * @param houseNo Street of customer
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * Returns email address of the customer who placed the order
     * @return Email address saved in the order
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email adress of the customer who placed the order
     * @param email Email address of customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns quantity of a product within the shopping cart (list items)
     * @param clazz class of the product (sushi) you want to get the quantity of
     * @return if the desired product is found in items, its quantity is returned, otherwise "0" is returned
     */
    public int getQuantityOfSushi(Class<? extends Sushi> clazz) {
        for (Sushi item : getItems()) {
            if (clazz == item.getClass()) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    /**
     * Returns selected payment method of the order
     * @return payment method
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets desired payment method of the order
     * @param paymentMethod desired payment method
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

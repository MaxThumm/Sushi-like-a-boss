package com.example.sushilikeaboss;

import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Sushi> items;
    private double total;

    private int totalTime;
    private boolean isOrdered;
    private String shippingMethod;
    private String firstName;
    private String name;
    private int zipCode;
    private String city;
    private String street;
    private String houseNo;
    private String email;
    private DeliveryType deliveryType;
    private PaymentMethod paymentMethod;

    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.total = 0;
        this.firstName = "";
        this.name = "";
        this.zipCode = -1;
        this.city = "";

        this.isOrdered = false;
        this.paymentMethod = PaymentMethod.CASH;
        this.deliveryType = DeliveryType.PICKUP;
    }

    /*
    Getter for item list of order
    @return Item list of the order
     */
    public ArrayList<Sushi> getItems() {
        return items;
    }

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
     *
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
        totalTime = newTime;
    }

    /**
    @return String containing all items in the items list. Can be used for order confirmation or status bar.
     */
    public String outputContent() {
        String output = items.get(0).getQuantity() + " " + items.get(0).getName();
        for (int i = 1; i < items.size(); i++) {
            output = output + ", " + items.get(i).getQuantity() + " " + items.get(i).getName();
        }
        return output;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }

    public int getQuantityOfSushi(Class<? extends Sushi> clazz) {
        for (Sushi item : getItems()) {
            if (clazz == item.getClass()) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

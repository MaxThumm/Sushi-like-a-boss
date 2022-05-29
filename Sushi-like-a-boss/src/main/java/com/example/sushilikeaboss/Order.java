package com.example.sushilikeaboss;

import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<Sushi> items;
    private double total;
    private boolean isOrdered;

    public Order(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.total = 0;
        isOrdered = false;
    }

    /*
    Getter for item list of order
    @return Item list of the order
     */
    public ArrayList<Sushi> getItems (){
        return items;
    }
    public void addItem(Sushi item){
        boolean isInItems = false;
        for (Sushi s:items) {
            if (s.getClass() == item.getClass()) {
                s.setQuantity(s.getQuantity()+item.getQuantity());
                isInItems = true;
            }
        }
        if (!isInItems) {
            this.items.add(item);
        }
        updateTotal();
    }

    /**
     * Removes sushi items from order
     * @param item is sushi that should be removed
     */
    public void removeItem(Sushi item){
        Sushi itemToRemove = null;
        for (Sushi s: items){
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
    }



    /*
    Updating total price of the current order.
     */
    private void updateTotal() {
        double newTotal = 0;
        for (Sushi s:items) {
            newTotal = newTotal + (s.getPrice() * s.getQuantity());
        }
        total = newTotal;
    }

    /*
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

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }
}

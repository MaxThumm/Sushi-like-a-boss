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

    //Methode gibt die items einer Order aus
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

    public void updateTotal() {
        double newTotal = 0;
        for (Sushi s:items) {
            newTotal = newTotal + (s.getPrice() * s.getQuantity());
        }
    }

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

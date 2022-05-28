package com.example.sushilikeaboss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label totalCostsBasketText;

    //Input field for quantity of Sake Nigiri to be removed from order
    @FXML
    private TextField removeSakeNigiriQ;

    //Input field for quantity of Sake Nigiri to be added to order
    @FXML
    private TextField addSakeNigiriQ;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Wohoo it works :) Welcome to our Sushi Store!");
    }

    @FXML
    private void goToCustomPage(ActionEvent event){

    }

    /*
    Adding number of Sake Nigiri from input field to order
     */
    @FXML
    private void addSakeNigiri() {
        int quantity;
        try {
            quantity = Integer.parseInt(addSakeNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSakeNigiri(quantity);
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Sake Nigiri added to your shopping cart";
        //Updates the total costs of shopping basket
        HelloApplication.updateTotal(quantity);
        //Changes the text to the new price
     //   totalCostsBasketText.setText("CHF" + orders.get(0).total);
    }

    /*
Removing number of Sake Nigiri from input field from order
 */
    @FXML
    private void removeSakeNigiri() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeSakeNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeSakeNigiri(quantityRemove);
        reloadOrders();
        String text = quantityRemove + " Sake Nigiri removed from your shopping cart";
        welcomeText.setText(text);
    }


    @FXML
    private ListView<String> aktelleBestellungListView;


    /**
     * Method contains current shopping basket
     */
    private void reloadOrders() {
        //gets the current order and saves it as new variable
        Order currentOrder = HelloApplication.orders.get(0);
        //Gets items from the current order and saves them into arraylist
        ArrayList<Sushi> sushisInOrder = currentOrder.getItems();
        ArrayList<String> ordersAsString = new ArrayList<>();
        //converts all Sushis in list to String
        for (Sushi sushi : sushisInOrder) {
            ordersAsString.add(sushi.getName() + " " + sushi.getQuantity() + " pieces");
        }
        aktelleBestellungListView.getItems().clear();
        aktelleBestellungListView.getItems().addAll(ordersAsString);
    }




}
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
    private TextField removeSakeNigiriQ;

    @FXML
    private TextField addSakeNigiriQ;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Wohoo it works :) Welcome to our Sushi Store!");
    }

    @FXML
    private void goToCustomPage(ActionEvent event){

    }

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
        reloadOrders();
        String text = quantity + " Sake Nigiri added to your shopping cart";
        welcomeText.setText(text);
    }

    @FXML
    private ListView<String> aktelleBestellungListView;


    /**
     * Method shows current shopping basket
     */
    private void reloadOrders() {
        //gets the current order and saves it as new variable
        Order currentOrder = HelloApplication.orders.get(0);
        //Gets items from the current order and saves them into arraylist
        ArrayList<Sushi> sushisInOrder = currentOrder.getItems();
        ArrayList<String> ordersAsString = new ArrayList<>();

        //converts all Sushis in listto String
        for (Sushi sushi : sushisInOrder) {
            ordersAsString.add(sushi.getName() + " " + sushi.getQuantity());
        }
        aktelleBestellungListView.getItems().clear();
        aktelleBestellungListView.getItems().addAll(ordersAsString);
    }




}
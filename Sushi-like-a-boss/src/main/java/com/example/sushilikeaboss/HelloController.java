package com.example.sushilikeaboss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;

    @FXML
    private Label totalCostsBasketText;

    //Input field for quantity of Sake Nigiri to be removed from order
    @FXML
    private TextField removeSakeNigiriQ;

    //Input field for quantity of Ebi Nigiri to be removed from order
    @FXML
    private TextField removeEbiNigiriQ;

    //Input field for quantity of Umami Nigiri to be removed from order
    @FXML
    private TextField removeUmamiNigiriQ;

    //Input field for quantity of Inari Nigiri to be removed from order
    @FXML
    private TextField removeInariNigiriQ;

    //Input field for quantity of small sets to be removed from order
    @FXML
    private TextField removeSmallSetQ;

    //Input field for quantity of large sets to be removed from order
    @FXML
    private TextField removeLargeSetQ;

    //Input field for quantity of Tamago Nigiri to be removed from order
    @FXML
    private TextField removeTamagoNigiriQ;

    //Input field for quantity of Maguro Nigiri to be removed from order
    @FXML
    private TextField removeMaguroNigiriQ;



    //Input field for quantity of Sake Nigiri to be added to order
    @FXML
    private TextField addSakeNigiriQ;

    //Input field for quantity of Umami Nigiri to be added to order
    @FXML
    private TextField addUmamiNigiriQ;

    //Input field for Ebi Nigiri that should be added to order
    @FXML
    private TextField addEbiNigiriQ;

    //Input field for quantity of Sake Inari to be added to order
    @FXML
    private TextField addInariNigiriQ;

    //Input field for quantity of Tamago Nigiri to be added to order
    @FXML
    private TextField addTamagoNigiriQ;

    //Input field for quantity of large sets to be added to order
    @FXML
    private TextField addMaguroNigiriQ;


    //Input field for quantity of small sets to be added to order
    @FXML
    private TextField addSmallSetQ;

    //Input field for quantity of large sets to be added to order
    @FXML
    private TextField addLargeSetQ;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Wohoo it works :) Welcome to our Sushi Store!");
    }

    @FXML
    private void goToCustomPage(ActionEvent event){

    }

    /**
     * Adding number of Sake Nigiri from input field to order
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
        HelloApplication.addSushi(new SakeNigiri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Sake Nigiri added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    /**
     * Adding number of Ebi Nigiri from input field to order
     */
    @FXML
    private void addEbiNigiri() {
        int quantity;
        try {
            quantity = Integer.parseInt(addEbiNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new EbiNigiri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Ebi Nigiri added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    /**
     * Adding number of Umami Nigiri from input field to order
     */
    @FXML
    private void addUmamiNigiri() {
        int quantity;
        try {
            quantity = Integer.parseInt(addUmamiNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new UmamiNigiri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Umami Nigiri added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    /**
     * Adding number of Umami Nigiri from input field to order
     */
    @FXML
    private void addInariNigiri() {
        int quantity;
        try {
            quantity = Integer.parseInt(addInariNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new InariNigri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Inari Nigiri added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    /**
     * Adding number of Tamago Nigiri from input field to order
     */
    @FXML
    private void addTamagoNigiri() {
        int quantity;
        try {
            quantity = Integer.parseInt(addTamagoNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new TamagoNigiri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Tamago Nigiri added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }
    /**
     * Adding number of Maguro Nigiri from input field to order
     */
    @FXML
    private void addMaguroNigiri() {
        int quantity;
        try {
            quantity = Integer.parseInt(addMaguroNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new MaguroNigri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Maguro Nigiri added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    /**
     * Adding number of small sets from input field to order
     */
    @FXML
    private void addSmallSet() {
        int quantity;
        try {
            quantity = Integer.parseInt(addSmallSetQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new SmallSet(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Small set added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    /**
     * Adding number of large sets from input field to order
     */
    @FXML
    private void addLargeSet() {
        int quantity;
        try {
            quantity = Integer.parseInt(addLargeSetQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new LargeSet(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " large set added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    /**
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
        HelloApplication.removeSushi(new SakeNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Sake Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeEbiNigiri() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeEbiNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeSushi(new EbiNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Ebi Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeUmamiNigiri() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeUmamiNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeSushi(new UmamiNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Umami Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeInariNigiri() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeInariNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeSushi(new InariNigri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Inari Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeTamagoNigiri() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeTamagoNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeSushi(new TamagoNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Tamago Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeMaguroNigiri() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeMaguroNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeSushi(new MaguroNigri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Maguro Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeSmallSet() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeSmallSetQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeSushi(new SmallSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " small set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeLargeSet() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeLargeSetQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeSushi(new LargeSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " large set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
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

    public void switchtoScene1FromCustom(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = HelloApplication.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
        reloadOrders();
    }

    public void switchToCheckout1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Checkout-1.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = HelloApplication.getPrimaryStage();
        stage.setScene(scene);
        stage.show();

    }

    public void switchToCustom(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("custom-window.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = HelloApplication.getPrimaryStage();
        stage.setScene(scene);
        stage.show();

    }



}
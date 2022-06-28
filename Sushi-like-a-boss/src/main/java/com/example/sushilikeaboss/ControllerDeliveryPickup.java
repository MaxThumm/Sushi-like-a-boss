package com.example.sushilikeaboss;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller for Checkout-4.fxml
 */

public class ControllerDeliveryPickup {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;

    @FXML
    private Label totalCostsBasketText;

    @FXML
    private ListView<String> aktelleBestellungListView;

    @FXML
    public Button shippingButton;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField nameTextField;



    @FXML
    private TextField emailTextField;

    @FXML
    private Text timeText;

    @FXML
    private Text timeTextExpress;

    @FXML
    private Text timeTextShipping;




    public ControllerDeliveryPickup() {
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Wohoo it works :) Welcome to our Sushi Store!");

    }

    @FXML
    private void goToCustomPage(ActionEvent event){

    }

    /**
     * parses amount of ordered sushi
     */
    private int parseIntOrZero(TextField addEbiNigiriQ) {
        try {
            return Integer.parseInt(addEbiNigiriQ.getText());
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }



    private void updateTotalCostsBasketText() {
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }



    @FXML
    public void initialize() {
        reloadOrders();
        totalTimePickup();
        totalTimeExpress();
        totalTimeShipping();
        updateTotalCostsBasketText();
    }



    /**
     * Calculates time needed to prepare sushi and updates text for sushi pickup accordingly
     */
    private void totalTimePickup(){
        // because the method is evoked whenever a scene is initialized, null case implemented
        if (timeText == null) {
            return;
        }
        Order currentOrder = HelloApplication.orders.get(0);
        int timeCurrentOrder = currentOrder.getTotalTime()/60;
        timeText.setText("Your sushi is ready for pickup in " + timeCurrentOrder + " minutes");
    }

    /**
     * Calculates time needed to prepare sushi and updates text for express delivery accordingly
     */
    private void totalTimeExpress(){
        if (timeTextExpress == null) {
            return;
        }
        Order currentOrder = HelloApplication.orders.get(0);
        // 5 minutes added to the order time for express deliery
        int timeCurrentOrder = currentOrder.getTotalTime()/60 + 5;
        timeTextExpress.setText("Your sushi delivered to you in " + timeCurrentOrder + " minutes");
    }

    /**
     * Calculates time needed to prepare sushi and updates text for normal delivery accordingly
     */
    private void totalTimeShipping(){
        if (timeTextShipping == null) {
            return;
        }
        Order currentOrder = HelloApplication.orders.get(0);
        // 20 minutes added to the order time for delivery
        int timeCurrentOrder = currentOrder.getTotalTime()/60 + 15;
        timeTextShipping.setText("Your sushi delivered to you in " + timeCurrentOrder + " minutes");
    }


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
            double decimalPrice = Math.round(sushi.getPrice()* sushi.getQuantity()*100.0)/100.0;
            ordersAsString.add(sushi.getName() + " " + sushi.getQuantity() + " pieces");
        }
        aktelleBestellungListView.getItems().clear();
        aktelleBestellungListView.getItems().addAll(ordersAsString);
    }

    public void switchtoScene1FromCustom(ActionEvent event) throws IOException {
        showFxml("hello-view.fxml");
    }

    public void switchToCheckout1(ActionEvent event) throws IOException {
        showFxml("Checkout-1.fxml");
    }

    public void switchToCustom(ActionEvent event) throws IOException {
        showFxml("custom-window.fxml");
    }

    public void switchToMenus(ActionEvent event) throws IOException {
        showFxml("ordering-window.fxml");
    }


    public void switchToCheckout2(ActionEvent event) throws IOException {
        showFxml("Checkout-2.fxml");
    }

    public void switchToCheckout3(ActionEvent event) throws IOException {
        showFxml("Checkout-3.fxml");
    }

    public void switchToCheckout4(ActionEvent event) throws IOException {
        showFxml("Checkout-4.fxml");
    }

    public void switchToOrderCofirmation(ActionEvent event) throws IOException {
        showFxml("Order-confirmation.fxml");
    }

    private void showFxml(String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = HelloApplication.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method hands over DeliveryType "Express" to instance of order when express button is klicked.
     */
    @FXML
    protected void expressShippingButtonKlick() {
        Order currentOrder = HelloApplication.orders.get(0);
        currentOrder.setDeliveryType(DeliveryType.EXPRESS);
    }

    /**
     * Method hands over DeliveryType "Normal" to instance of order when normal button is klicked.
     */
    @FXML
    protected void normalShippingButtonKlick() {
        Order currentOrder = HelloApplication.orders.get(0);
        currentOrder.setDeliveryType(DeliveryType.NORMAL);
    }

    /**
     * Method hands over DeliveryType "Pickup" to instance of order when pickup button is klicked.
     */
    @FXML
    protected void pickUpShippingButtonKlick() {
        Order currentOrder = HelloApplication.orders.get(0);
        currentOrder.setDeliveryType(DeliveryType.PICKUP);
    }





    @FXML
    private void toCheckout(ActionEvent event) throws IOException {
        if (HelloApplication.orders.get(0).getDeliveryType() == DeliveryType.PICKUP) {
            switchToCheckout4(event);
        }
        else {
            switchToCheckout3(event);
        }
    }




    @FXML
    private TableView orderTableView;

    @FXML
    private TableColumn<Sushi, Integer> quantityCol;

    @FXML
    private TableColumn<Sushi, Integer> itemCol;

    @FXML
    private TableColumn<Sushi, Integer> priceCol;


    private void loadOrderTable() {
        ObservableList<Sushi> orderList = FXCollections.observableArrayList(HelloApplication.orders.get(0).getItems());
        orderTableView.setItems(orderList);
        Order currentOrder = HelloApplication.orders.get(0);
        ArrayList<Sushi> sushisInOrder = currentOrder.getItems();
        ArrayList<String> ordersAsString = new ArrayList<>();
    }

    @FXML
    private void proceedToOrder(ActionEvent event) throws IOException {
        if (HelloApplication.orders.get(0).getItems().isEmpty()) {
            welcomeText.setText("Shopping cart empty. Please add items to place an order.");
        }
        else {
            switchToCheckout1(event);
        }
    }

    @FXML
    private ToggleGroup packagingGroup;

    @FXML
    private void toCheckout2(ActionEvent event) throws IOException {
        if (packagingGroup.getSelectedToggle() == null) {
            welcomeText.setText("No packaging selected. Please select a packaging to proceed!");
        }
        else {
            switchToCheckout2(event);
        }
    }

}
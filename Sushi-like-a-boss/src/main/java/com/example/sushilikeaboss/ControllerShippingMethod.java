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
 *  Controller for deliverymethod-window.FXML
 */

public class ControllerShippingMethod {
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
    private Text timeText;
    @FXML
    private Text timeTextExpress;
    @FXML
    private Text timeTextShipping;



    public ControllerShippingMethod() {
    }



    /**
     * initialize method is evoked after change of window and does setup by evoking necessary methods
     */
    @FXML
    public void initialize() {
        reloadOrders();
        totalTimePickup();
        totalTimeExpress();
        totalTimeShipping();
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
        // 10 minutes added to the order time for express deliery
        int timeCurrentOrder = currentOrder.getTotalTime()/60 + 10;
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
        int timeCurrentOrder = currentOrder.getTotalTime()/60 + 20;
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

    /**
     *Switches to scene "Packaging-and-Addon-Window.fxml"
     * @param event Action event triggering scene switch
     * @throws IOException
     */
    public void switchToCheckout1(ActionEvent event) throws IOException {
        showFxml("Packaging-and-Addon-Window.fxml");
    }


    /**
     *Switches to scene "Personal-info-shipping-window.fxml"
     * @param event Action event triggering scene switch
     * @throws IOException
     */
    public void switchToCheckout3(ActionEvent event) throws IOException {
        showFxml("Personal-info-shipping-window.fxml");
    }

    /**
     *Switches to scene "Personal-info-pickup-window.fxml"
     * @param event Action event triggering scene switch
     * @throws IOException
     */
    public void switchToCheckout4(ActionEvent event) throws IOException {
        showFxml("Personal-info-pickup-window.fxml");
    }


    /**
     * Loads and shows new scene
     * @param fxmlFileName FXML file name of new scene
     * @throws IOException
     */
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

    /**
     * Depending on chosen delivery method switchToCheckout4 or switchToCheckout3 method is evoked. These methods then open new scene.
     * @param event Action event triggering scene switch
     * @throws IOException
     */
    @FXML
    private void toCheckout(ActionEvent event) throws IOException {
        if (HelloApplication.orders.get(0).getDeliveryType() == DeliveryType.PICKUP) {
            switchToCheckout4(event);
        }
        else {
            switchToCheckout3(event);
        }
    }
}
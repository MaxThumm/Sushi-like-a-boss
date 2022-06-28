package com.example.sushilikeaboss;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller for Checkout-3.FXML
 */

public class ControllerConfirmation {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;

    @FXML
    private Label totalCostsBasketText;


    @FXML
    public Button shippingButton;


    public ControllerConfirmation() {
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


    /**
     * initialize method is evoked after change of window and does setup by evoking necessary methods
     */

    @FXML
    public void initialize() {
        loadOrderConfirmation();

    }






    public void switchtoScene1FromCustom(ActionEvent event) throws IOException {
        showFxml("Choose-menu-custom.window.fxml");
    }

    @FXML
    public void switchtoStartWindow(ActionEvent event) throws IOException {
        showFxml("Start-window.fxml");
    }

    public void switchToCheckout1(ActionEvent event) throws IOException {
        showFxml("Packaging-and-Addon-Window.fxml");
    }

    public void switchToCustom(ActionEvent event) throws IOException {
        showFxml("Custom-window.fxml");
    }

    public void switchToMenus(ActionEvent event) throws IOException {
        showFxml("Menu-window.fxml");
    }


    public void switchToCheckout2(ActionEvent event) throws IOException {
        showFxml("Deliverymethod-window.fxml");
    }

    public void switchToCheckout3(ActionEvent event) throws IOException {
        showFxml("Personal-info-shipping-window.fxml");
    }

    public void switchToCheckout4(ActionEvent event) throws IOException {
        showFxml("Personal-info-pickup-window.fxml");
    }

    @FXML
    public void switchToOrderCofirmation(ActionEvent event) throws IOException {
        showFxml("Order-confirmation-window.fxml");
        loadOrderConfirmation();
    }

    private void showFxml(String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = HelloApplication.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void toCheckout(ActionEvent event) throws IOException {
        if (HelloApplication.orders.get(0).getDeliveryType().equals(DeliveryType.PICKUP)) {
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

        quantityCol.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));

        itemCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        priceCol.setCellValueFactory(
                new PropertyValueFactory<>("price"));

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

    /**
     * Method hands over PaymentMethod "CASH" to instance of order when cash payment Radio Button is selected.
     */
    @FXML
    private void setCashPayment() {
        HelloApplication.orders.get(0).setPaymentMethod(PaymentMethod.CASH);
    }

    /**
     * Method hands over PaymentMethod "TWINT" to instance of order when twint payment Radio Button is selected.
     */
    @FXML
    private void setTwintPayment() {
        HelloApplication.orders.get(0).setPaymentMethod(PaymentMethod.TWINT);
    }

    /**
     * Method hands over PaymentMethod "CREDITCARD" to instance of order when credit card payment Radio Button is selected.
     */
    @FXML
    private void setCreditCardPayment() {
        HelloApplication.orders.get(0).setPaymentMethod(PaymentMethod.CREDITCARD);
    }

    @FXML
    private Label nameText;

    @FXML
    private Label emailText;

    @FXML
    private Label adressText;

    @FXML
    private Label deliveryMethodText;

    @FXML
    private Label paymentMethodText;

    @FXML
    private void loadOrderConfirmation() {
        Order currentOrder = HelloApplication.orders.get(0);
        nameText.setText(currentOrder.getFirstName() + " " + currentOrder.getName());
        emailText.setText(currentOrder.getEmail());
        if (currentOrder.getZipCode() == -1 && currentOrder.getCity().equals("") && currentOrder.getStreet().equals("") && currentOrder.getHouseNo().equals("")) {
            adressText.setText("");
        }
        else {
            adressText.setText(currentOrder.getStreet() + " " + currentOrder.getHouseNo() + ", " + currentOrder.getZipCode() + ", " + currentOrder.getCity());
        }

        if (currentOrder.getDeliveryType().equals(DeliveryType.NORMAL)) {
            deliveryMethodText.setText("Standard delivery - Your order will arrive in " + currentOrder.getTotalTime()/60 + " minutes");
        }
        else if (currentOrder.getDeliveryType().equals(DeliveryType.EXPRESS)) {
            deliveryMethodText.setText("Express delivery - Your order will arrive in " + currentOrder.getTotalTime()/60 + " minutes");
        }
        else {
            deliveryMethodText.setText("Pickup - Your order is ready to pickup in " + + currentOrder.getTotalTime()/60 + " minutes");
        }

        if (currentOrder.getPaymentMethod().equals(PaymentMethod.CREDITCARD)) {
            paymentMethodText.setText("Credit card");
        }
        else if (currentOrder.getPaymentMethod().equals(PaymentMethod.TWINT)) {
            paymentMethodText.setText("Twint");
        }
        else {
            paymentMethodText.setText("Cash");
        }
        updateTotalCostsBasketText();
        loadOrderTable();
    }

    @FXML
    private void updateTotalCostsBasketText() {
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

}
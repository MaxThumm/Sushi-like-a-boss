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
 * Controller for Personal-info-pickup-window.FXML and Personal-info-shipping-window-FXML
 */

public class ControllerContactInformation {
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
    private TextField zipTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField emailTextField;


    public ControllerContactInformation() {
    }


    /**
     * Parses Integer from the TextField, which is handed over
     * @param textField TextField to parse Integer from.
     * @return trys to return of parsed Integer. If not possible "0" is returned.
     */
    private int parseIntOrZero(TextField textField) {
        try {
            return Integer.parseInt(textField.getText());
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
        reloadOrders();

    }

    /**
     * Saves shipping information (name, adress, email).
     * Used for checkout with delivery (standard or express), when the adress needs to be submitted.
     */
    private void saveShippingInformation1() {
        String firstName = firstNameTextField.getText();
        String name = nameTextField.getText();
        int zipCode = parseIntOrZero(zipTextField);
        String city = cityTextField.getText();
        String street = streetTextField.getText();
        String houseNo = numberTextField.getText();
        String email = emailTextField.getText();

        HelloApplication.addShippingInformation(firstName, name, zipCode, city, street, houseNo, email);

        String text = "Shipping information saved!";
        welcomeText.setText(text);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Saves shipping information (name & email).
     * Used for checkout without delivery (pickup), when NO adress needs to be submitted.
     */

    private void saveShippingInformation2() {
        String firstName = firstNameTextField.getText();
        String name = nameTextField.getText();
        String email = emailTextField.getText();

        HelloApplication.addShippingInformation(firstName, name, -1, "", "", "", email);

        String text = "Shipping information saved!";
        welcomeText.setText(text);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
     * Switches to delivery method scene when triggered by event
     * @param event triggering the method
     * @throws IOException
     */
    public void switchToCheckout2(ActionEvent event) throws IOException {
        showFxml("Deliverymethod-window.fxml");
    }

    /**
     * Switches to order confirmation scene when triggered by event
     * @param event triggering the method
     * @throws IOException
     */
    @FXML
    public void switchToOrderCofirmation(ActionEvent event) throws IOException {
        showFxml("Order-confirmation-window.fxml");
    }


    /**
     * Loads and shows a chosen scene.
     * @param fxmlFileName name of the fxml File which should be loaded and shown.
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
     * Saves all necessary shipping information for an order with delivery (standard or express) within the order and switches to the order confirmation, if all text fields are filled. Otherwise, an error message is shown.
     * @param event Event triggering the method
     * @throws IOException
     */
    @FXML
    private void placeOrder1(ActionEvent event) throws IOException {
        if (!firstNameTextField.getText().trim().equals("") && !nameTextField.getText().trim().equals("") && !zipTextField.getText().trim().equals("") && !cityTextField.getText().trim().equals("") && !streetTextField.getText().trim().equals("") && !numberTextField.getText().trim().equals("") && !emailTextField.getText().trim().equals("")) {
            saveShippingInformation1();
            switchToOrderCofirmation(event);
        }
        else {
            welcomeText.setText("Please fill out all text boxes to continue!");
        }
    }


    /**
     * Saves all necessary shipping information for an order without delivery (pickup) within the order and switches to the order confirmation, if all text fields are filled. Otherwise, an error message is shown.
     * @param event Event triggering the method
     * @throws IOException
     */
    @FXML
    private void placeOrder2(ActionEvent event) throws IOException {
        if (!firstNameTextField.getText().trim().equals("") && !nameTextField.getText().trim().equals("") && !emailTextField.getText().trim().equals("")) {
            saveShippingInformation2();
            switchToOrderCofirmation(event);
        }
        else {
            welcomeText.setText("Please fill out all text boxes to continue!");
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

    /**
     * Updates the text output showing the total price of the items within the shopping cart.
     */
    @FXML
    private void updateTotalCostsBasketText() {
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }



}
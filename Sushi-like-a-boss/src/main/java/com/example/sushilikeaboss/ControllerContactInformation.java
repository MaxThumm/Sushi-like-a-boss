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







    @FXML
    public void initialize() {
        reloadOrders();

    }








    @FXML
    private void onShippingButtonClick() {
        String firstName = firstNameTextField.getText();
        String name = nameTextField.getText();
        int zipCode = parseIntOrZero(zipTextField);
        String city = cityTextField.getText();
        String street = streetTextField.getText();
        String houseNo = numberTextField.getText();
        String email = emailTextField.getText();

        HelloApplication.addShippingInformation(firstName, name, zipCode, city, street, houseNo, email);

        //Changes the text to the new amount
        String text = "Shipping information saved!";
        welcomeText.setText(text);

        try {
            Thread.sleep(1000);
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

    @FXML
    private void placeOrder(ActionEvent event) throws IOException {
        if (!firstNameTextField.getText().trim().equals("") && !nameTextField.getText().trim().equals("") && !zipTextField.getText().trim().equals("") && !cityTextField.getText().trim().equals("") && !streetTextField.getText().trim().equals("") && !numberTextField.getText().trim().equals("") && !emailTextField.getText().trim().equals("")) {
            welcomeText.setText("Please fill out all text boxes to continue!");
        }
        else {
            switchToOrderCofirmation(event);
        }
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
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
 * Controller for Order-confirmation-window.FXML
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
    @FXML
    private TableView orderTableView;
    @FXML
    private TableColumn<Sushi, Integer> quantityCol;
    @FXML
    private TableColumn<Sushi, Integer> itemCol;
    @FXML
    private TableColumn<Sushi, Integer> priceCol;
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



    public ControllerConfirmation() {
    }


    /**
     * initialize method is evoked after change of window and does setup by evoking necessary methods
     */
    @FXML
    public void initialize() {
        loadOrderConfirmation();

    }

    /**
     * Switches to scene "Start-window.fxml"
     * @param event Action event triggering scene switch
     * @throws IOException
     */
    @FXML
    public void switchtoStartWindow(ActionEvent event) throws IOException {
        showFxml("Start-window.fxml");
    }

    /**
     * Loads and shows new scene
     * @param fxmlFileName file name of new scene
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
     * Loads TableView showing order details
     */
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

    /**
     * Loads all information displayed in order-confirmation scene
     */
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

    /**
     * Updates total cost of items in the shopping cart
     */
    @FXML
    private void updateTotalCostsBasketText() {
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

}
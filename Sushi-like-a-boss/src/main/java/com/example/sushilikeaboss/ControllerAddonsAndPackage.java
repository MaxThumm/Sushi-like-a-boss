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

public class ControllerAddonsAndPackage {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;
    @FXML
    private Label totalCostsBasketText;
    @FXML
    private TextField removeChopsticksQ;
    @FXML
    private TextField removeGingerQ;
    @FXML
    private TextField removeSoySauceQ;
    @FXML
    private TextField removeWasabiSauceQ;
    @FXML
    private TextField addChopsticksQ;
    @FXML
    private TextField addSoySauceQ;
    @FXML
    private TextField addGingerQ;
    @FXML
    private TextField addWasabiQ;
    @FXML
    private ListView<String> aktelleBestellungListView;
    @FXML
    public Button shippingButton;
    @FXML
    private Label soySaucePrice;
    @FXML
    private Label chostickPrice;
    @FXML
    private Label wasabiPrice;
    @FXML
    private Label gingerPrice;

    public ControllerAddonsAndPackage() {
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

    /**
     * Method gets the price of one wasabi and sets it to the corresponding price tag
     */
    private void wasabiPriceTag() {
        if (wasabiPrice == null) {
            return;
        }
        double price = new Wasabi(1).getPrice();
        wasabiPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one ginger and sets it to the corresponding price tag
     */
    private void gingerPriceTag() {
        if (gingerPrice == null) {
            return;
        }
        double price = new Ginger(1).getPrice();
        gingerPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one set of chopsticks and sets it to the corresponding price tag
     */

    private void chopStickPriceTag() {
        if (chostickPrice == null) {
            return;
        }
        double price = new Chopstick(1).getPrice();
        chostickPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one soy sauce and sets it to the corresponding price tag
     */
    private void soySaucePriceTag() {
        if (soySaucePrice == null) {
            return;
        }
        double price = new SoySauce(1).getPrice();
        soySaucePrice.setText(price + " CHF");
    }


    /**
     * Adding number of chopsticks from input field to order
     */
    @FXML
    private void addChopsticks() {
        int quantity = parseIntOrZero(addChopsticksQ);
        HelloApplication.addSushi(new Chopstick(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " chopstick added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of soy sauces from input field to order
     */
    @FXML
    private void addSoySauce() {
        int quantity = parseIntOrZero(addSoySauceQ);
        HelloApplication.addSushi(new SoySauce(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " soy sauce added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of ginger from input field to order
     */
    @FXML
    private void addGinger() {
        int quantity = parseIntOrZero(addGingerQ);
        HelloApplication.addSushi(new Ginger(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " ginger added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of wasabi from input field to order
     */
    @FXML
    private void addWasabi() {
        int quantity = parseIntOrZero(addWasabiQ);
        HelloApplication.addSushi(new Wasabi (quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " wasabi added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeChopsticks() {
        int quantityRemove = parseIntOrZero(removeChopsticksQ);
        HelloApplication.removeItem(new Chopstick (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " chopstick set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeSoySauce() {
        int quantityRemove = parseIntOrZero(removeSoySauceQ);
        HelloApplication.removeItem(new SoySauce (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " soy sauce set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }
    @FXML
    private void removeGinger() {
        int quantityRemove = parseIntOrZero(removeGingerQ);
        HelloApplication.removeItem(new Ginger (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " ginger set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeWasabi() {
        int quantityRemove = parseIntOrZero(removeWasabiSauceQ);
        HelloApplication.removeItem(new Wasabi (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " wasabi removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }


    /**
     * Adds a recircle box to the order if there is no box in the order.
     */
    @FXML
    private void addRecircleBox() {
        int quantity;
        //könnte ich noch anpassen auf die Menge die benötigt wird
        quantity = 1;
        //gets the current order and saves it as new variable
        Order currentOrder = HelloApplication.orders.get(0);
        //gets the quantitiy of recircle boxes in the current order and saves it as new variable
        int quantityInOrder = currentOrder.getQuantityOfSushi(Recircle.class);
        if (quantityInOrder <= 0) {
            HelloApplication.addSushi(new Recircle(quantity));
            //Ads the newly ordered amount to the shopping cart list
            reloadOrders();
            //Changes the text to the new amount
            String text = quantity + " Recircle Box added to your shopping cart";
            welcomeText.setText(text);
            // saves the price in decimal values in order to avoid long numbers after comma
            updateTotalCostsBasketText();

        }
        else{
            HelloApplication.removeItem(new Recircle (quantity));
            reloadOrders();
            String text = quantity + " Recircle Box removed from your shopping cart";
            welcomeText.setText(text);
            // saves the price in decimal values in order to avoid long numbers after comma
            updateTotalCostsBasketText();

        }
    }

    /**
     * Adds a oneway box to the order if there is no box in the order.
     */
    @FXML
    private void addOneWayBox() {
        int quantity;
        //könnte ich noch anpassen auf die Menge die benötigt wird
        quantity = 1;
        //gets the current order and saves it as new variable
        Order currentOrder = HelloApplication.orders.get(0);
        //gets the quantitiy of recircle boxes in the current order and saves it as new variable
        int quantityInOrder = currentOrder.getQuantityOfSushi(OneWayBox.class);
        if (quantityInOrder <= 0) {
            HelloApplication.addSushi(new OneWayBox(quantity));
            //Ads the newly ordered amount to the shopping cart list
            reloadOrders();
            //Changes the text to the new amount
            String text = quantity + " Oneway Box added to your shopping cart";
            welcomeText.setText(text);
            // saves the price in decimal values in order to avoid long numbers after comma
            updateTotalCostsBasketText();

        }
        else{
            HelloApplication.removeItem(new OneWayBox (quantity));
            reloadOrders();
            String text = quantity + " Oneway Box removed from your shopping cart";
            welcomeText.setText(text);
            // saves the price in decimal values in order to avoid long numbers after comma
            updateTotalCostsBasketText();

        }
    }

    /**
     * initialize method is evoked after change of window and does setup by evoking necessary methods
     */
    @FXML
    public void initialize() {
        reloadOrders();
        updateTotalCostsBasketText();
        gingerPriceTag();
        wasabiPriceTag();
        soySaucePriceTag();
        chopStickPriceTag();
        if (HelloApplication.orders.get(0).getQuantityOfSushi(OneWayBox.class) == 0){
            addRecircleBox();
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


    public void switchToCustom(ActionEvent event) throws IOException {
        showFxml("Custom-window.fxml");
    }

    public void switchToMenus(ActionEvent event) throws IOException {
        showFxml("Menu-window.fxml");
    }


    public void switchToCheckout2(ActionEvent event) throws IOException {
        showFxml("Deliverymethod-window.fxml");
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
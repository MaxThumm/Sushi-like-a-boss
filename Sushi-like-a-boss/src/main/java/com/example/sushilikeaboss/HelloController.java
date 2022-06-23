package com.example.sushilikeaboss;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    @FXML
    private TextField removeChopsticksQ;

    @FXML
    private TextField removeGingerQ;

    @FXML
    private TextField removeSoySauceQ;

    @FXML
    private TextField removeWasabiSauceQ;




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

    @FXML
    private Text timeText;









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

    @FXML
    private void addChopsticks() {
        int quantity;
        try {
            quantity = Integer.parseInt(addChopsticksQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new Chopstick(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " chopstick added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void addSoySauce() {
        int quantity;
        try {
            quantity = Integer.parseInt(addSoySauceQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new SoySauce(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " soy sauce added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void addGinger() {
        int quantity;
        try {
            quantity = Integer.parseInt(addGingerQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new Ginger(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " ginger added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void addWasabi() {
        int quantity;
        try {
            quantity = Integer.parseInt(addWasabiQ.getText());
        }
        catch (NumberFormatException e) {
            quantity = 1;
        }
        HelloApplication.addSushi(new Wasabi (quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " wasabi added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private Button addARecircleBox;

    /**
     * Adds a recircle box to the order if there is no box in the order. Then changes the text in the button to "remove"
     * and when klicked box is removed from the order.
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
            double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal() * 100.0) / 100.0;
            //Changes the text to the new price in decimal
            totalCostsBasketText.setText("CHF " + decimalPrice);
            //If Box has been put into shopping cart the text is changed to remove
            addARecircleBox.setText("Remove");

        }
        else{
            HelloApplication.removeItem(new Recircle (quantity));
            reloadOrders();
            String text = quantity + " Recircle Box removed from your shopping cart";
            welcomeText.setText(text);
            // saves the price in decimal values in order to avoid long numbers after comma
            double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
            //Changes the text to the new price in decimal
            totalCostsBasketText.setText("CHF " + decimalPrice);
            addARecircleBox.setText("Select");

        }
    }

    @FXML
    private Button oneWayBox;

    /**
     * Adds a recircle box to the order if there is no box in the order. Then changes the text in the button to "remove"
     * and when klicked box is removed from the order.
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
            double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal() * 100.0) / 100.0;
            //Changes the text to the new price in decimal
            totalCostsBasketText.setText("CHF " + decimalPrice);
            //If Box has been put into shopping cart the text is changed to remove
            oneWayBox.setText("Remove");

        }
        else{
            HelloApplication.removeItem(new OneWayBox (quantity));
            reloadOrders();
            String text = quantity + " Oneway Box removed from your shopping cart";
            welcomeText.setText(text);
            // saves the price in decimal values in order to avoid long numbers after comma
            double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
            //Changes the text to the new price in decimal
            totalCostsBasketText.setText("CHF " + decimalPrice);
            oneWayBox.setText("Select");

        }
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
        HelloApplication.removeItem(new SakeNigiri (quantityRemove));
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
        HelloApplication.removeItem(new EbiNigiri (quantityRemove));
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
        HelloApplication.removeItem(new UmamiNigiri (quantityRemove));
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
        HelloApplication.removeItem(new InariNigri (quantityRemove));
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
        HelloApplication.removeItem(new TamagoNigiri (quantityRemove));
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
        HelloApplication.removeItem(new MaguroNigri (quantityRemove));
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
        HelloApplication.removeItem(new SmallSet (quantityRemove));
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
        HelloApplication.removeItem(new LargeSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " large set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeChopsticks() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeChopsticksQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeItem(new Chopstick (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " chopstick set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeSoySauce() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeSoySauceQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeItem(new SoySauce (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " soy sauce set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }
    @FXML
    private void removeGinger() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeGingerQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeItem(new Ginger (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " ginger set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void removeWasabi() {
        int quantityRemove;
        try {
            quantityRemove = Integer.parseInt(removeWasabiSauceQ.getText());
        }
        catch (NumberFormatException e) {
            quantityRemove = 1;
        }
        HelloApplication.removeItem(new Wasabi (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " wasabi removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }

    @FXML
    private void onShippingButtonClick() {
        String firstName = firstNameTextField.getText();
        String name = nameTextField.getText();
        int zipCode;
        try {
            zipCode = Integer.parseInt(zipTextField.getText());
        }
        catch (NumberFormatException e) {
            zipCode = -1;
        }
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
     *
     */
    @FXML
    private void totalTimePickup(){
        Order currentOrder = HelloApplication.orders.get(0);
        int timeCurrentOrder = currentOrder.getTotalTime();
        timeText.setText("Your sushi is ready for pickup in" + String.valueOf(timeCurrentOrder) + "minutes");
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
        reloadOrders();
    }

    public void switchToCustom(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("custom-window.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = HelloApplication.getPrimaryStage();
        stage.setScene(scene);
        stage.show();

    }

    public void switchToCheckout2(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Checkout-2.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = HelloApplication.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
        reloadOrders();
    }

    public void switchToCheckout3(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Checkout-3.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = HelloApplication.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
        reloadOrders();
    }

    public void switchToCheckout4(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Checkout-4.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = HelloApplication.getPrimaryStage();
        stage.setScene(scene);
        stage.show();
        reloadOrders();
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
    private void placeOrder() {
        if (!firstNameTextField.getText().trim().equals("") && !nameTextField.getText().trim().equals("") && !zipTextField.getText().trim().equals("") && !cityTextField.getText().trim().equals("") && !streetTextField.getText().trim().equals("") && !numberTextField.getText().trim().equals("") && !emailTextField.getText().trim().equals("")) {
            welcomeText.setText("Please fill out all text boxes to continue!");
        }
        else {
            //next scene
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

}
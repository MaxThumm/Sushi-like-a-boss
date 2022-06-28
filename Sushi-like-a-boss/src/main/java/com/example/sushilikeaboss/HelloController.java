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
    private TextField removeVegiSetQ;

    @FXML
    private TextField removeNigriMakiSetQ;
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
    private TextField addVegiSetQ;

    @FXML
    private TextField addNigriMakiSetQ;

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
    private Text timeTextExpress;

    @FXML
    private Text timeTextShipping;

    @FXML
    private Label soySaucePrice;

    @FXML
    private Label chostickPrice;

    @FXML
    private Label wasabiPrice;

    @FXML
    private Label gingerPrice;


    public HelloController() {
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
     * Adding number of Sake Nigiri from input field to order
     */
    @FXML
    private void addSakeNigiri() {
        int quantity = parseIntOrZero(addSakeNigiriQ);
        HelloApplication.addSushi(new SakeNigiri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Sake Nigiri added to your shopping cart";
        welcomeText.setText(text);
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of Ebi Nigiri from input field to order
     */
    @FXML
    private void addEbiNigiri() {
        int quantity = parseIntOrZero(addEbiNigiriQ);
        HelloApplication.addSushi(new EbiNigiri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Ebi Nigiri added to your shopping cart";
        welcomeText.setText(text);
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of Umami Nigiri from input field to order
     */
    @FXML
    private void addUmamiNigiri() {
        int quantity = parseIntOrZero(addUmamiNigiriQ);
        HelloApplication.addSushi(new UmamiNigiri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Umami Nigiri added to your shopping cart";
        welcomeText.setText(text);
        updateTotalCostsBasketText();
    }

    private void updateTotalCostsBasketText() {
        // saves the price in decimal values in order to avoid long numbers after comma
        double decimalPrice = Math.round(HelloApplication.orders.get(0).getTotal()*100.0)/100.0;
        //Changes the text to the new price in decimal
        totalCostsBasketText.setText("CHF " + decimalPrice);
    }


    private void gingerText() {
        if (gingerPrice == null) {
            return;
        }
        int quantity = parseIntOrZero(addGingerQ);
        double decimalPrice = Math.round(Sushi.getPrice() * quantity * 100.0) / 100.0;
        gingerPrice.setText(decimalPrice + " CHF");
    }





    /**
     * Adding number of Umami Nigiri from input field to order
     */
    @FXML
    private void addInariNigiri() {
        int quantity = parseIntOrZero(addInariNigiriQ);
        HelloApplication.addSushi(new InariNigri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Inari Nigiri added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of Tamago Nigiri from input field to order
     */
    @FXML
    private void addTamagoNigiri() {
        int quantity = parseIntOrZero(addTamagoNigiriQ);
        HelloApplication.addSushi(new TamagoNigiri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Tamago Nigiri added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }
    /**
     * Adding number of Maguro Nigiri from input field to order
     */
    @FXML
    private void addMaguroNigiri() {
        int quantity = parseIntOrZero(addMaguroNigiriQ);
        HelloApplication.addSushi(new MaguroNigri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Maguro Nigiri added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of small sets from input field to order
     */
    @FXML
    private void addSmallSet() {
        int quantity = parseIntOrZero(addSmallSetQ);
        HelloApplication.addSushi(new SmallSet(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Small set added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of large sets from input field to order
     */
    @FXML
    private void addLargeSet() {
        int quantity = parseIntOrZero(addLargeSetQ);
        HelloApplication.addSushi(new LargeSet(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " large set added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void addNigiriMakiSet() {
        int quantity = parseIntOrZero(addNigriMakiSetQ);
        HelloApplication.addSushi(new NigriMakiSet(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Nigri and Maki set added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void addVegiSetSet() {
        int quantity = parseIntOrZero(addVegiSetQ);
        HelloApplication.addSushi(new VegiSet(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Vegi set added to your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

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
            updateTotalCostsBasketText();
            //If Box has been put into shopping cart the text is changed to remove
            addARecircleBox.setText("Remove");

        }
        else{
            HelloApplication.removeItem(new Recircle (quantity));
            reloadOrders();
            String text = quantity + " Recircle Box removed from your shopping cart";
            welcomeText.setText(text);
            // saves the price in decimal values in order to avoid long numbers after comma
            updateTotalCostsBasketText();
            addARecircleBox.setText("Select");

        }
    }

    @FXML
    public void initialize() {
        reloadOrders();
        totalTimePickup();
        totalTimeExpress();
        totalTimeShipping();
        updateTotalCostsBasketText();
        gingerText();
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
            updateTotalCostsBasketText();
            //If Box has been put into shopping cart the text is changed to remove
            oneWayBox.setText("Remove");

        }
        else{
            HelloApplication.removeItem(new OneWayBox (quantity));
            reloadOrders();
            String text = quantity + " Oneway Box removed from your shopping cart";
            welcomeText.setText(text);
            // saves the price in decimal values in order to avoid long numbers after comma
            updateTotalCostsBasketText();
            oneWayBox.setText("Select");

        }
    }



    /**
    Removing number of Sake Nigiri from input field from order
    */
    @FXML
    private void removeSakeNigiri() {
        int quantityRemove = parseIntOrZero(removeSakeNigiriQ);
        HelloApplication.removeItem(new SakeNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Sake Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeEbiNigiri() {
        int quantityRemove = parseIntOrZero(removeEbiNigiriQ);
        HelloApplication.removeItem(new EbiNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Ebi Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeUmamiNigiri() {
        int quantityRemove = parseIntOrZero(removeUmamiNigiriQ);
        HelloApplication.removeItem(new UmamiNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Umami Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeInariNigiri() {
        int quantityRemove = parseIntOrZero(removeInariNigiriQ);
        HelloApplication.removeItem(new InariNigri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Inari Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeTamagoNigiri() {
        int quantityRemove = parseIntOrZero(removeTamagoNigiriQ);
        HelloApplication.removeItem(new TamagoNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Tamago Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeMaguroNigiri() {
        int quantityRemove = parseIntOrZero(removeMaguroNigiriQ);
        HelloApplication.removeItem(new MaguroNigri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Maguro Nigiri removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeSmallSet() {
        int quantityRemove = parseIntOrZero(removeSmallSetQ);
        HelloApplication.removeItem(new SmallSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " small set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeLargeSet() {
        int quantityRemove = parseIntOrZero(removeLargeSetQ);
        HelloApplication.removeItem(new LargeSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " large set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeVegiSet() {
        int quantityRemove = parseIntOrZero(removeVegiSetQ);
        HelloApplication.removeItem(new VegiSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " vegi set removed from your shopping cart";
        welcomeText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    @FXML
    private void removeNigriMakiSet() {
        int quantityRemove = parseIntOrZero(removeNigriMakiSetQ);
        HelloApplication.removeItem(new NigriMakiSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Nigiri and Maki set removed from your shopping cart";
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
            ordersAsString.add(sushi.getName() + " " + sushi.getQuantity() + " pieces for CHF " + decimalPrice);
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
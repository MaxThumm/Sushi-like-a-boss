package com.example.sushilikeaboss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller for menu-window.FXML and custom-window.FXML
 */
public class ControllerSushiOrdering {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label informationText;

    @FXML
    private Label totalCostsBasketText;

    //Input field for quantity of Sake Nigiri to be removed from order
    @FXML
    private TextField removeSakeNigiriQ;

    @FXML
    private TextField removeEbiNigiriQ;

    @FXML
    private TextField removeUmamiNigiriQ;

    @FXML
    private TextField removeInariNigiriQ;

    @FXML
    private TextField removeSmallSetQ;

    @FXML
    private TextField removeLargeSetQ;

    @FXML
    private TextField removeVegiSetQ;
    @FXML
    private TextField removeNigriMakiSetQ;
    @FXML
    private TextField removeTamagoNigiriQ;
    @FXML
    private TextField removeMaguroNigiriQ;

    //Input field for quantity of Sake Nigiri to be added to order
    @FXML
    private TextField addSakeNigiriQ;
    @FXML
    private TextField addUmamiNigiriQ;
    @FXML
    private TextField addEbiNigiriQ;
    @FXML
    private TextField addInariNigiriQ;
    @FXML
    private TextField addTamagoNigiriQ;
    @FXML
    private TextField addMaguroNigiriQ;
    @FXML
    private TextField addSmallSetQ;
    @FXML
    private TextField addLargeSetQ;
    @FXML
    private TextField addVegiSetQ;
    @FXML
    private TextField addNigriMakiSetQ;
    @FXML
    private ListView<String> aktelleBestellungListView;
    @FXML
    public Button shippingButton;

    @FXML
    private Label sakeNigiriPrice;

    @FXML
    private Label umamiNigiriPrice;

    @FXML
    private Label ebiNigiriPrice;

    @FXML
    private Label inariNigiriPrice;

    @FXML
    private Label tamagoNigiriPrice;

    @FXML
    private Label nigiriMakiSetPrice;

    @FXML
    private Label vegiSetPrice;

    @FXML
    private Label largeSetPrice;
    @FXML
    private Label maguroNigiriPrice;

    @FXML
    private Label smallSetPrice;

    public ControllerSushiOrdering() {
    }

    /**
     * parses amount of ordered sushi
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
        informationText.setText(text);
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
        informationText.setText(text);
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
        informationText.setText(text);
        updateTotalCostsBasketText();
    }

    /**
     * Updates the costs of the shopping basket
     */
    private void updateTotalCostsBasketText() {
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
        int quantity = parseIntOrZero(addInariNigiriQ);
        HelloApplication.addSushi(new InariNigri(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Inari Nigiri added to your shopping cart";
        informationText.setText(text);
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
        informationText.setText(text);
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
        informationText.setText(text);
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
        informationText.setText(text);
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
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of nigiri maki sets from input field to order
     */
    @FXML
    private void addNigiriMakiSet() {
        int quantity = parseIntOrZero(addNigriMakiSetQ);
        HelloApplication.addSushi(new NigriMakiSet(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Nigri and Maki set added to your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     * Adding number of vegi sets from input field to order
     */
    @FXML
    private void addVegiSetSet() {
        int quantity = parseIntOrZero(addVegiSetQ);
        HelloApplication.addSushi(new VegiSet(quantity));
        //Ads the newly ordered amount to the shopping cart list
        reloadOrders();
        //Changes the text to the new amount
        String text = quantity + " Vegi set added to your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
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
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     Removing number of Ebi Nigiri from input field from order
     */

    @FXML
    private void removeEbiNigiri() {
        int quantityRemove = parseIntOrZero(removeEbiNigiriQ);
        HelloApplication.removeItem(new EbiNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Ebi Nigiri removed from your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     Removing number of Umami Nigiri from input field from order
     */

    @FXML
    private void removeUmamiNigiri() {
        int quantityRemove = parseIntOrZero(removeUmamiNigiriQ);
        HelloApplication.removeItem(new UmamiNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Umami Nigiri removed from your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     Removing number of Inari Nigiri from input field from order
     */

    @FXML
    private void removeInariNigiri() {
        int quantityRemove = parseIntOrZero(removeInariNigiriQ);
        HelloApplication.removeItem(new InariNigri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Inari Nigiri removed from your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     Removing number of Tamago Nigiri from input field from order
     */

    @FXML
    private void removeTamagoNigiri() {
        int quantityRemove = parseIntOrZero(removeTamagoNigiriQ);
        HelloApplication.removeItem(new TamagoNigiri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Tamago Nigiri removed from your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     Removing number of Maguro Nigiri from input field from order
     */

    @FXML
    private void removeMaguroNigiri() {
        int quantityRemove = parseIntOrZero(removeMaguroNigiriQ);
        HelloApplication.removeItem(new MaguroNigri (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Maguro Nigiri removed from your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     Removing number of small sets from input field from order
     */

    @FXML
    private void removeSmallSet() {
        int quantityRemove = parseIntOrZero(removeSmallSetQ);
        HelloApplication.removeItem(new SmallSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " small set removed from your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     Removing number of large sets from input field from order
     */

    @FXML
    private void removeLargeSet() {
        int quantityRemove = parseIntOrZero(removeLargeSetQ);
        HelloApplication.removeItem(new LargeSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " large set removed from your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     Removing number of vegi sets from input field from order
     */

    @FXML
    private void removeVegiSet() {
        int quantityRemove = parseIntOrZero(removeVegiSetQ);
        HelloApplication.removeItem(new VegiSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " vegi set removed from your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     Removing number of Nigiri Maki Set from input field from order
     */

    @FXML
    private void removeNigiriMakiSet() {
        int quantityRemove = parseIntOrZero(removeNigriMakiSetQ);
        HelloApplication.removeItem(new NigriMakiSet (quantityRemove));
        reloadOrders();
        String text = quantityRemove + " Nigiri and Maki set removed from your shopping cart";
        informationText.setText(text);
        // saves the price in decimal values in order to avoid long numbers after comma
        updateTotalCostsBasketText();
    }

    /**
     * Method gets the price of one Sake Nigiri and sets it to the corresponding price tag
     */

    private void sakeNigiriPriceTag() {
        // exception handling because method is evoked in both menu and custom window
        if (sakeNigiriPrice == null) {
            return;
        }
        double price = new SakeNigiri(1).getPrice();
        sakeNigiriPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one Ebi Nigiri and sets it to the corresponding price tag
     */
    private void ebiNigiriPriceTag() {
        if (ebiNigiriPrice == null) {
            return;
        }
        double price = new EbiNigiri(1).getPrice();
        ebiNigiriPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one Umami Nigiri and sets it to the corresponding price tag
     */
    private void umamiNigiriPriceTag() {
        if (umamiNigiriPrice == null) {
            return;
        }
        double price = new UmamiNigiri(1).getPrice();
        umamiNigiriPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one Inari Nigiri and sets it to the corresponding price tag
     */
    private void inariPriceTag() {
        if (inariNigiriPrice == null) {
            return;
        }
        double price = new InariNigri(1).getPrice();
        inariNigiriPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one Tamago Nigiri and sets it to the corresponding price tag
     */
    private void tamagoNigiriPriceTag() {
        if (tamagoNigiriPrice == null) {
            return;
        }
        double price = new TamagoNigiri(1).getPrice();
        tamagoNigiriPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one Maguro Nigiri and sets it to the corresponding price tag
     */
    private void maguroNigiriPriceTag() {
        if (maguroNigiriPrice == null) {
            return;
        }
        double price = new MaguroNigri(1).getPrice();
        maguroNigiriPrice.setText(price + " CHF");
    }


    /**
     * Method gets the price of one large set and sets it to the corresponding price tag
     */
    private void largeSetPriceTag() {
        if (largeSetPrice == null) {
            return;
        }
        double price = new LargeSet(1).getPrice();
        largeSetPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one small set and sets it to the corresponding price tag
     */
    private void smallSetPriceTag() {
        if (smallSetPrice == null) {
            return;
        }
        double price = new SmallSet(1).getPrice();
        smallSetPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one vegi set and sets it to the corresponding price tag
     */
    private void vegiSetPriceTag() {
        if (vegiSetPrice == null) {
            return;
        }
        double price = new VegiSet(1).getPrice();
        vegiSetPrice.setText(price + " CHF");
    }

    /**
     * Method gets the price of one nigiri maki set and sets it to the corresponding price tag
     */

    private void nigiriMakiSetPriceTag() {
        if (nigiriMakiSetPrice == null) {
            return;
        }
        double price = new NigriMakiSet(1).getPrice();
        nigiriMakiSetPrice.setText(price + " CHF");
    }

    /**
     * initialize method is evoked after change of window and does setup by evoking necessary methods
     */
    @FXML
    public void initialize() {
        reloadOrders();
        updateTotalCostsBasketText();
        sakeNigiriPriceTag();
        ebiNigiriPriceTag();
        umamiNigiriPriceTag();
        inariPriceTag();
        maguroNigiriPriceTag();
        tamagoNigiriPriceTag();
        largeSetPriceTag();
        smallSetPriceTag();
        nigiriMakiSetPriceTag();
        vegiSetPriceTag();
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
     * Evokes switchToCheckout1 method which opens Packaging-and-Addon-Window.fxml if there is an item in the shoopping cart. If there is no item an error message is displayed
     * @param event action event triggering scene switch
     * @throws IOException
     */

    @FXML
    private void proceedToOrder(ActionEvent event) throws IOException {
        if (HelloApplication.orders.get(0).getItems().isEmpty()) {
            informationText.setText("Shopping cart empty. Please add items to place an order.");
        }
        else {
            switchToCheckout1(event);
        }
    }


    /**
     *Switches to scene "Choose-menu-custom.window.fxml"
     * @param event Action event triggering scene switch
     * @throws IOException
     */
    public void switchtoScene1FromCustom(ActionEvent event) throws IOException {
        showFxml("Choose-menu-custom.window.fxml");
    }

    /**
     *Switches to scene "Packaging-and-Addon-Window.fxml
     * @param event Action event triggering scene switch
     * @throws IOException
     */
    public void switchToCheckout1(ActionEvent event) throws IOException {
        showFxml("Packaging-and-Addon-Window.fxml");
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


}
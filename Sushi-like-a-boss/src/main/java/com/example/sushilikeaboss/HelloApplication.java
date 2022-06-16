package com.example.sushilikeaboss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class HelloApplication extends Application {
    //List of all orders placed and in progress. Fist one is most recent one.
    public static LinkedList<Order> orders;

    /*
    Starting new order. New order gets added to first spot in order list.
     */
    public static void newOrder() {
        Order newOrder = new Order(orders.size());
        orders.add(0, newOrder);
    }

    /*
    Finish and place order.
    @return Order confirmation is returned as String.
     */
    public static String placeOrder() {
        orders.get(0).setOrdered(true);
        String confirmation = "Order placed. Your order ID is " + orders.get(0).getId() + ". It consists of " + orders.get(0).outputContent() + ". The total is " + orders.get(0).getTotal() + ".";
        return confirmation;
    }

    /**
     * Method adds Sushis to the Order
     * @param sushi is sushi subclass that should be added
     */
    public static void addSushi(Sushi sushi) {
        orders.get(0).addItem(sushi);
    }

    public static void addShippingInformation(String firstName, String name, int zipCode, String city, String street, String number, String email) {
        orders.get(0).setFistName(firstName);
        orders.get(0).setName(name);
        orders.get(0).setZipCode(zipCode);
        orders.get(0).setCity(city);
        orders.get(0).setStreet(street);
        orders.get(0).setHouseNo(number);
        orders.get(0).setEmail(email);
    }


    private static Stage primaryStage; // **Declare static Stage**

    private void setPrimaryStage(Stage stage) {
        HelloApplication.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return HelloApplication.primaryStage;
    }


    /**
     * Submitted number of Sake Nigiri remove from item list (shopping cart) within the order.
     *
     * @param quantity desired quantity to remove from the shopping cart
     */
    public static void removeItem (Sushi sushi) {
        orders.get(0).removeItem(sushi);
    }


    /**
     * /*
     * Submitted number of Nigiri Sets get added to item list (shopping cart) within the order.
     *
     * @param quantity desired quantitiy to add to shopping cart
     *                 <p>
     *                 public static void addNigiriSet(int quantity) {
     *                 orders.get(0).addItem(new NigiriSet(quantity));
     *                 }
     *                 <p>
     *                 private static Stage primaryStage; // **Declare static Stage**
     *                 <p>
     *                 private void setPrimaryStage(Stage stage) {
     *                 HelloApplication.primaryStage = stage;
     *                 }
     *                 <p>
     *                 static public Stage getPrimaryStage() {
     *                 return HelloApplication.primaryStage;
     *                 }
     */

    @Override
    public void start(Stage stage) throws IOException {
        setPrimaryStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1800, 900);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        //new order list initiated when program is started
        orders = new LinkedList<Order>();
        newOrder(); //to be linked with button "Place new order"

        launch();


    }
}
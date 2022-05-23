package com.example.sushilikeaboss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class HelloApplication extends Application {
     public static LinkedList<Order> orders;

    public static void newOrder() {
        Order newOrder = new Order(orders.size());
        orders.add(0, newOrder);
    }

    public static String placeOrder() {
        orders.get(0).setOrdered(true);
        String confirmation = "Order placed. Your order ID is " + orders.get(0).getId() + ". It consists of " + orders.get(0).outputContent() + ". The total is " + orders.get(0).getTotal() + ".";
        return confirmation;
    }

    public static void addSakeNigiri(int quantity) {
        orders.get(0).addItem(new SakeNigiri(quantity));
    }

    public static void addNigiriSet(int quantity) {
        orders.get(0).addItem(new NigiriSet(quantity));
    }

    private static Stage primaryStage; // **Declare static Stage**

    private void setPrimaryStage(Stage stage) {
        HelloApplication.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return HelloApplication.primaryStage;
    }

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
        orders = new LinkedList<Order>();
        newOrder();

        launch();


    }
}
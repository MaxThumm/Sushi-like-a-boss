package com.example.sushilikeaboss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Wohoo it works :) Welcome to our Sushi Store!");
    }

    @FXML
    private void goToCustomPage(ActionEvent event){

    }

    @FXML
    private void addSakeNigiri() {
        int quantity = 1;
        HelloApplication.addSakeNigiri(quantity);
        String text = quantity + " Sake Nigiri added to your shopping cart";
        welcomeText.setText(text);
    }


}
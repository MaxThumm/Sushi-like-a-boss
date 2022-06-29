package com.example.sushilikeaboss;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for choose-menu-custom-window.fxml
 */

public class ControllerMenuOrCustomSelection {
    private Stage stage;
    private Scene scene;
    private Parent root;


    /**
     * Method sets up new FXML that should be shown
     * @param fxmlFileName FMXL file to be executed
     * @throws IOException exception handling code so normal flow of program can be maintained
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
     * Method changes scene to custom-window FXML
     * @param event evokes the method and thereby change of scene
     * @throws IOException
     */

    public void switchtoScene2(ActionEvent event) throws IOException {
        showFxml("Custom-window.fxml");
    }

    /**
     * Method changes scene to ordering-window FXML
     * @param event evokes the method and thereby change of scene
     * @throws IOException
     */

    public void switchtoScene3(ActionEvent event) throws IOException {
        showFxml("Menu-window.fxml");
    }


}

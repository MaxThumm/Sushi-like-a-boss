package com.example.sushilikeaboss;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerScreen0 {
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
     *Method changes scene to hello-view FXML
     * @param event evokes the method and thereby change of scene
     * @throws IOException
     */

    public void switchtoScene1(ActionEvent event) throws IOException {
        showFxml("hello-view.fxml");
    }




}

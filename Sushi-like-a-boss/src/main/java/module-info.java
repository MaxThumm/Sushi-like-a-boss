module com.example.sushilikeaboss {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sushilikeaboss to javafx.fxml;
    exports com.example.sushilikeaboss;
}
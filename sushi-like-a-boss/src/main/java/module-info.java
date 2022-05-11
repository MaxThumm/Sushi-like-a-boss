module com.sushilikeaboss.sushilikeaboss {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sushilikeaboss.sushilikeaboss to javafx.fxml;
    exports com.sushilikeaboss.sushilikeaboss;
}
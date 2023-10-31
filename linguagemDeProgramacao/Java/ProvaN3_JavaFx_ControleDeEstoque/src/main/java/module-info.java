module com.controleestoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens com.controleestoque to javafx.fxml;
    exports com.controleestoque;
}
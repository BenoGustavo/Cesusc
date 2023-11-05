module com.controleestoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires atlantafx.base;

    opens com.controleestoque to javafx.fxml;

    opens com.controleestoque.connection.database to javafx.base;

    exports com.controleestoque;
}
module com.controleestoque {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires atlantafx.base;
    requires javafx.graphics;

    opens com.controleestoque to javafx.fxml;

    opens com.controleestoque.connection.database to javafx.base;

    exports com.controleestoque;
}
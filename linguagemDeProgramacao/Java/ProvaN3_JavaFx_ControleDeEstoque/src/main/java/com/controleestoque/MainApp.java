package com.controleestoque;

import java.io.IOException;
import java.sql.SQLException;

import com.controleestoque.connection.database.ProductsController;

import atlantafx.base.theme.Dracula;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    private static Stage stage;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        Application.setUserAgentStylesheet(new Dracula().getUserAgentStylesheet());

        stage = s;
        stage.setResizable(false);
        setRoot("mainPage", "Sistema de gerenciamento de produtos");
    }

    public static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws SQLException {
        ProductsController databaseController = new ProductsController(
                "src/main/java/com/controleestoque/connection/database/Database.db");

        databaseController.checkDatabaseConnection();

        launch(args);
    }

}

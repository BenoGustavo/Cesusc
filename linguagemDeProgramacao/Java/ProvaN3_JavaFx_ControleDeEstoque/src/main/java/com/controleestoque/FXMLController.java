package com.controleestoque;

/*
Put header here


 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class FXMLController implements Initializable {

    @FXML
    private Button createBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button returnBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private void returnBtnFunction() throws IOException {
        MainApp.setRoot("mainPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void loadCreationPage() throws IOException {
        MainApp.setRoot("createProductPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void loadUpdatePage(ActionEvent event) throws IOException {
        MainApp.setRoot("updateProductPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void loadDeletePage(ActionEvent event) throws IOException {
        MainApp.setRoot("deleteProductPage", "Sistema de gerenciamento de produtos");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}

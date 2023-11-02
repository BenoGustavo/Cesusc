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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreatePageController implements Initializable {

    @FXML
    private Button returnBtn, createProductBtn;
    @FXML
    private TextField productNameInput, productPriceInput, quantityInput;

    @FXML
    private void returnBtnFunction() throws IOException {
        MainApp.setRoot("mainPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void createProductFunction(ActionEvent event) throws IOException {
        // Todo
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utils.filterProductNameInput(productNameInput);
        Utils.filterProductPriceInput(productPriceInput);
        Utils.filterQuantityInput(quantityInput);
    }
}

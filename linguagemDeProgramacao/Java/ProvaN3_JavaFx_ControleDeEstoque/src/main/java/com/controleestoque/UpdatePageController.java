package com.controleestoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdatePageController implements Initializable {

    @FXML
    private Button returnBtn;

    @FXML
    private TextField productIdInput, productNameInput, productPriceInput, quantityInput;

    @FXML
    private void returnBtnFunction() throws IOException {
        MainApp.setRoot("mainPage", "Sistema de gerenciamento de produtos");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Utils.filterIdInput(productIdInput);
        Utils.filterProductNameInput(productNameInput);
        Utils.filterProductPriceInput(productPriceInput);
        Utils.filterQuantityInput(quantityInput);
    }
}

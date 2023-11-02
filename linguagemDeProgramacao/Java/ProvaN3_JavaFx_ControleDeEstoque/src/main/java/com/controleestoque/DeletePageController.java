package com.controleestoque;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeletePageController implements Initializable {

    @FXML
    private Button returnBtn, deleteProductBtn;
    @FXML
    private TextField productidInput;

    @FXML
    private void returnBtnFunction() throws IOException {
        MainApp.setRoot("mainPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void deleteProduct() throws IOException {
        // TODO: implement deleteProduct
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utils.filterIdInput(productidInput);
    }

}

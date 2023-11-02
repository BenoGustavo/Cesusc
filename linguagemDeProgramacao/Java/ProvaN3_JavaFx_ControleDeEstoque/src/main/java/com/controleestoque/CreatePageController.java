package com.controleestoque;

/*
Put header here


 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class CreatePageController implements Initializable {

    @FXML
    private Button returnBtn;

    @FXML
    private TextField productNameInput;
    @FXML
    private TextField productPriceInput;
    @FXML
    private TextField quantityInput;

    @FXML
    private Button createProductBtn;

    @FXML
    private void returnBtnFunction() throws IOException {
        MainApp.setRoot("mainPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void createProductFunction(ActionEvent event) throws IOException {

    }

    // Allow only letters, spaces and numbers in the product name input
    private void filterProductNameInput() {
        productNameInput.textProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    if (!newValue.matches("\\sa-zA-Z0-9*")) {
                        productNameInput.setText(newValue.replaceAll("[^\\sa-zA-Z0-9]*", ""));
                    }
                });
    }

    // Allow only numbers in and points the product price input
    private void filterProductPriceInput() {
        productPriceInput.textProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    if (newValue.isEmpty() || newValue.startsWith(".")) {
                        productPriceInput.setText("");

                    } else if (newValue.contains("..")) {
                        productPriceInput.setText(oldValue);

                    } else if (!newValue.matches("\\d*(\\.\\d*)?")) {
                        productPriceInput.setText(newValue.replaceAll("[^\\d.]", ""));

                    }
                });
    }

    // Allow only numbers
    private void filterQuantityInput() {
        quantityInput.textProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    if (!newValue.matches("\\d*")) {
                        quantityInput.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filterProductNameInput();
        filterProductPriceInput();
        filterQuantityInput();
    }
}

package com.controleestoque;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class Utils {

    /////////////////////////////////////////////////////////////////////////////////////
    // The codes above are used to filter the inputs of the user using regex//
    /////////////////////////////////////////////////////////////////////////////////////

    // Allow only letters, spaces and numbers in the product name input
    static void filterProductNameInput(TextField productNameInput) {
        productNameInput.textProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    if (!newValue.matches("\\sa-zA-Z0-9*")) {
                        productNameInput.setText(newValue.replaceAll("[^\\sa-zA-Z0-9]*", ""));
                    }
                });
    }

    // Allow only numbers in and points the product price input
    static void filterProductPriceInput(TextField productPriceInput) {
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
    static void filterQuantityInput(TextField quantityInput) {
        quantityInput.textProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    if (!newValue.matches("\\d*")) {
                        quantityInput.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                });
    }

    // Allow only numbers
    static void filterIdInput(TextField productIdInput) {
        productIdInput.textProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    if (!newValue.matches("\\d*")) {
                        productIdInput.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                });
    }
}

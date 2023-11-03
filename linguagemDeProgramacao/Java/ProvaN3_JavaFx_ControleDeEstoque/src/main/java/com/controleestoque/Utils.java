package com.controleestoque;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Utils {

    // Using *args to check for empty text fields
    public static boolean checkFilledTextFields(String title, String header, String content,
            Alert.AlertType alertType, TextField... textFields) {
        for (TextField textField : textFields) {

            // If the text field is empty, triggers the showAlert function show an alert
            if (textField.getText().isEmpty()) {
                Utils.showAlert(title, header, content, alertType);
                return true;
            }
        }
        return false;
    }

    // Shows and alert pop-up with the given parameters
    public static void showAlert(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        // Makes the alert not resizable
        alert.resizableProperty().setValue(false);
        // Sets the size of the alert
        alert.getDialogPane().setPrefSize(alert.getDialogPane().getWidth(), alert.getDialogPane().getHeight());

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

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

package com.controleestoque;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Utils {

    public static final ImageView RETURN_ICON = new ImageView(
            "file:src/main/resources/images/return.png");

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
                    // Check if the new value is empty or starts with a space, also checks if the
                    // user is trying to insert simbols
                    if (!newValue.matches("\\sa-zA-Z0-9*")) {
                        productNameInput.setText(newValue.replaceAll("[^\\sa-zA-Z0-9]*", ""));
                    }
                });
    }

    // Allow only numbers in and points the product price input
    static void filterProductPriceInput(TextField productPriceInput) {
        productPriceInput.textProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    // Check if the new value is empty or starts with a dot
                    if (newValue.isEmpty() || newValue.startsWith(".")) {
                        productPriceInput.setText("");
                        // Checks if the user is trying to insert more than one dot
                    } else if (newValue.length() - newValue.replace(".", "").length() > 1) {
                        productPriceInput.setText(oldValue);
                        // Checks if the user is trying to insert simbols, or letters
                    } else if (!newValue.matches("\\d*(\\.\\d*)?")) {
                        productPriceInput.setText(newValue.replaceAll("[^\\d.]", ""));
                    }

                    // Check if there are more than two digits after the dot
                    int dotIndex = newValue.indexOf(".");
                    if (dotIndex != -1 && newValue.length() - dotIndex - 1 > 2) {
                        productPriceInput.setText(newValue.substring(0, dotIndex + 3));
                    }

                });
    }

    // Allow only numbers
    static void filterQuantityInput(TextField quantityInput) {
        quantityInput.textProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    // Only allow numbers
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

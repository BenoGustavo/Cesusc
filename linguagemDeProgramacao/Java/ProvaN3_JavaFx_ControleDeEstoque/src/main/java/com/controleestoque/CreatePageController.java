package com.controleestoque;

/*
Put header here


 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.controleestoque.connection.database.ProductsController;
import com.controleestoque.connection.database.ProductsModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private void createProductFunction(ActionEvent event) throws IOException, SQLException {

        // Checks if the user has filled all the fields
        if (Utils.checkFilledTextFields("Erro", "Campos vazios",
                "Por favor, preencha todos os campos", Alert.AlertType.WARNING,
                productNameInput, productPriceInput, quantityInput)) {
            return;
        }

        String productName = productNameInput.getText();
        String productPrice = productPriceInput.getText();
        String productQuantity = quantityInput.getText();

        ProductsController databaseController = new ProductsController(
                "src/main/java/com/controleestoque/connection/database/Database.db");

        ProductsModel newProduct = new ProductsModel(productName, Double.parseDouble(productPrice),
                Integer.parseInt(productQuantity));

        // Checks for errors while creating the product then show to the user the status
        try {
            databaseController.create(newProduct);
            Utils.showAlert("Sucesso", "Produto criado com sucesso",
                    "O produto " + productName + " foi criado com sucesso", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            Utils.showAlert("Erro", "Erro ao criar produto", "Error: " + e.getMessage(),
                    Alert.AlertType.ERROR);
            return;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utils.filterProductNameInput(productNameInput);
        Utils.filterProductPriceInput(productPriceInput);
        Utils.filterQuantityInput(quantityInput);
    }
}

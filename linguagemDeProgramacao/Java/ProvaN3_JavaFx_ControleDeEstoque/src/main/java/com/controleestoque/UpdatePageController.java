package com.controleestoque;

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

public class UpdatePageController implements Initializable {

    @FXML
    private Button returnBtn, createProductBtn;

    @FXML
    private TextField productIdInput, productNameInput, productPriceInput, quantityInput;

    @FXML
    private void returnBtnFunction() throws IOException {
        MainApp.setRoot("mainPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void updateProduct(ActionEvent event) throws SQLException {
        // Checks if the user has filled all the fields
        if (Utils.checkFilledTextFields("Erro", "Campos vazios",
                "Por favor, preencha todos os campos", Alert.AlertType.WARNING,
                productIdInput, productNameInput, productPriceInput, quantityInput)) {
            return;
        }

        String productId = productIdInput.getText();
        String productName = productNameInput.getText();
        String productPrice = productPriceInput.getText();
        String productQuantity = quantityInput.getText();

        ProductsController databaseController = new ProductsController(
                "src/main/java/com/controleestoque/connection/database/Database.db");

        ProductsModel productToUpdate = databaseController.findProduct(databaseController.getProductList(),
                Integer.parseInt(productId));

        if (productToUpdate != null) {
            productToUpdate.setName(productName);
            productToUpdate.setPrice(Double.parseDouble(productPrice));
            productToUpdate.setQuantity(Integer.parseInt(productQuantity));

            try {
                databaseController.update(productToUpdate);
                Utils.showAlert("Sucesso", "Produto atualizado com sucesso",
                        "O produto " + productName + " foi atualizado com sucesso", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                Utils.showAlert("Erro", "Erro ao criar produto", "Error: " + e.getMessage(),
                        Alert.AlertType.ERROR);
            }
        } else {
            Utils.showAlert("Erro", "Produto não encontrado",
                    "O produto com o ID " + productId + " não foi na base de dados encontrado", Alert.AlertType.ERROR);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        returnBtn.setGraphic(Utils.RETURN_ICON);

        Utils.filterIdInput(productIdInput);
        Utils.filterProductNameInput(productNameInput);
        Utils.filterProductPriceInput(productPriceInput);
        Utils.filterQuantityInput(quantityInput);
    }
}

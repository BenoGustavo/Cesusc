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
            databaseController.update(productToUpdate);
        } else {
            // NEED TO IMPLMENT AN ALLERT HERE
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Utils.filterIdInput(productIdInput);
        Utils.filterProductNameInput(productNameInput);
        Utils.filterProductPriceInput(productPriceInput);
        Utils.filterQuantityInput(quantityInput);
    }
}

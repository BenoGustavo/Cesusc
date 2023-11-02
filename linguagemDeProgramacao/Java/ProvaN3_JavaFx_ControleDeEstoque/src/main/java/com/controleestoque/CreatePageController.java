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
        String productName = productNameInput.getText();
        String productPrice = productPriceInput.getText();
        String productQuantity = quantityInput.getText();

        ProductsController databaseController = new ProductsController(
                "src/main/java/com/controleestoque/connection/database/Database.db");

        ProductsModel newProduct = new ProductsModel(productName, Double.parseDouble(productPrice),
                Integer.parseInt(productQuantity));

        databaseController.create(newProduct);

        // NEED TO IMPLMENT AN ALLERT HERE
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utils.filterProductNameInput(productNameInput);
        Utils.filterProductPriceInput(productPriceInput);
        Utils.filterQuantityInput(quantityInput);
    }
}

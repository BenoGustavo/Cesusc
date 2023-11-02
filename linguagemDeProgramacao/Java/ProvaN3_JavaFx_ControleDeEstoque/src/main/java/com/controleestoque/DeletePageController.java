package com.controleestoque;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.controleestoque.connection.database.ProductsController;
import com.controleestoque.connection.database.ProductsModel;

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
    private void deleteProduct() throws IOException, SQLException {
        String productId = productidInput.getText();

        ProductsController databaseController = new ProductsController(
                "src/main/java/com/controleestoque/connection/database/Database.db");

        ProductsModel productToDelete = databaseController.findProduct(databaseController.getProductList(),
                Integer.parseInt(productId));

        if (productToDelete != null) {
            databaseController.delete(productToDelete);
        } else {
            // NEED TO IMPLMENT AN ALLERT HERE
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utils.filterIdInput(productidInput);
    }

}

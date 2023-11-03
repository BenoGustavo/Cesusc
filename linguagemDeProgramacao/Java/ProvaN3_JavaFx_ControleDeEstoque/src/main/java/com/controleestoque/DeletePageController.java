package com.controleestoque;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.controleestoque.connection.database.ProductsController;
import com.controleestoque.connection.database.ProductsModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

        // Checks if the user has filled all the fields
        if (Utils.checkFilledTextFields("Erro", "Campos vazios",
                "Por favor, preencha todos os campos", Alert.AlertType.WARNING,
                productidInput)) {
            return;
        }

        String productId = productidInput.getText();

        ProductsController databaseController = new ProductsController(
                "src/main/java/com/controleestoque/connection/database/Database.db");

        ProductsModel productToDelete = databaseController.findProduct(databaseController.getProductList(),
                Integer.parseInt(productId));

        if (productToDelete != null) {
            try {
                databaseController.delete(productToDelete);

                Utils.showAlert("Sucesso", "Produto deletado com sucesso",
                        "O produto " + productToDelete.getName() + " foi deletado com sucesso",
                        Alert.AlertType.INFORMATION);
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utils.filterIdInput(productidInput);
    }

}

package com.controleestoque;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.controleestoque.connection.database.ProductsController;
import com.controleestoque.connection.database.ProductsModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class DeletePageController implements Initializable {

    @FXML
    private Button returnBtn, deleteProductBtn;
    @FXML
    private TextField productidInput;

    @FXML
    private TableView<ProductsModel> tableData;
    @FXML
    private TableColumn<String, String> idColumn, nameColumn;

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

                feedTable();

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

    private void feedTable() throws SQLException {
        ProductsController databaseController = new ProductsController(
                "src/main/java/com/controleestoque/connection/database/Database.db");

        // Create an ObservableList of Product objects
        ObservableList<ProductsModel> productList = FXCollections
                .observableArrayList(databaseController.getProductList());

        // Set the items property of the TableView to the productList
        tableData.setItems(productList);

        // Set the cell value factories for each column
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        returnBtn.setGraphic(Utils.RETURN_ICON);

        Utils.filterIdInput(productidInput);
        try {
            feedTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

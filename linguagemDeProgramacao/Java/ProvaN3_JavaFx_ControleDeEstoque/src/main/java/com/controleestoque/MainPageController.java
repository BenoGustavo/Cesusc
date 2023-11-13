package com.controleestoque;

/*
Put header here


 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.controleestoque.connection.database.ProductsController;
import com.controleestoque.connection.database.ProductsModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainPageController implements Initializable {

    @FXML
    private Button createBtn, updateBtn, deleteBtn, returnBtn;

    @FXML
    private TableView<ProductsModel> tableDataBase;
    @FXML
    private TableColumn<String, String> idColumn, nameColumn, priceColumn, quantityColumn, createdColumn,
            updatedColumn;

    @FXML
    private TextField searchBar;

    @FXML
    private void returnBtnFunction() throws IOException {
        MainApp.setRoot("mainPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void loadCreationPage() throws IOException {
        MainApp.setRoot("createProductPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void loadUpdatePage(ActionEvent event) throws IOException {
        MainApp.setRoot("updateProductPage", "Sistema de gerenciamento de produtos");
    }

    @FXML
    private void loadDeletePage(ActionEvent event) throws IOException {
        MainApp.setRoot("deleteProductPage", "Sistema de gerenciamento de produtos");
    }

    // Search bar filter
    private void searchBarFilter() throws SQLException {
        ProductsController databaseController = new ProductsController(
                "src/main/java/com/controleestoque/connection/database/Database.db");

        ArrayList<ProductsModel> data = databaseController.getProductList();

        ObservableList<ProductsModel> productList = FXCollections.observableArrayList(data);
        FilteredList<ProductsModel> filteredData = new FilteredList<ProductsModel>(productList, p -> true);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(product -> {
                // If filter text is empty, display all products.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare product name with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (product.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches product name.
                }

                return false; // Does not match.
            });
        });

        tableDataBase.setItems(filteredData);
    }

    // FEEDS THE TABLE WITH THE DATABASE DATA
    private void feedTable() throws SQLException {
        ProductsController databaseController = new ProductsController(
                "src/main/java/com/controleestoque/connection/database/Database.db");

        // Create an ObservableList of Product objects
        ObservableList<ProductsModel> productList = FXCollections
                .observableArrayList(databaseController.getProductList());

        // Set the items property of the TableView to the productList
        tableDataBase.setItems(productList);

        // Set the cell value factories for each column
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        createdColumn.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        updatedColumn.setCellValueFactory(new PropertyValueFactory<>("lastTimeUpdated"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utils.filterProductNameInput(searchBar);
        try {
            feedTable();
            searchBarFilter();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

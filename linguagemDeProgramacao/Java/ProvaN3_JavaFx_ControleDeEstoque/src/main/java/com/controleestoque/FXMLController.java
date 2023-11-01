package com.controleestoque;
/*
Put header here


 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private Button createBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private void loadCreationPage() {
        System.out.println("Creation button pressed");
    }

    @FXML
    private void loadUpdatePage(ActionEvent event) {
        searchBar.setText("loadUpdatePage button clicked");
    }

    @FXML
    private void loadDeletePage(ActionEvent event) {
        searchBar.setText("delete button clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createBtn.setOnAction(e -> loadCreationPage());
        updateBtn.setOnAction(e -> loadUpdatePage(e));
        deleteBtn.setOnAction(e -> loadDeletePage(e));
    }
}

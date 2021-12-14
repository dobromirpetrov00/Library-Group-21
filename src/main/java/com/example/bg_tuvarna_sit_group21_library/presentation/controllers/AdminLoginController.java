package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Connect.Connection;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UsersListViewModel;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.tree.Statement;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AdminLoginController {
    @FXML
    public Label labelWrongInfo;

    @FXML
    public Button goBackButton;

    @FXML
    private Button adminLogin;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    private final AdminService service = AdminService.getInstance();
    private static final Logger log = Logger.getLogger(AdminLoginController.class);

    @FXML
    public void onButtonClick(ActionEvent actionEvent) throws IOException {

        UsersListViewModel admintoLogin = new UsersListViewModel(usernameField.getText().toString(),passwordField.getText().toString());
        PropertyConfigurator.configure(AdminLoginController.class.getResource(Constants.Configurations.LOG4J_PROPERTIES));

        if (service.adminLogin(admintoLogin)) {
            Stage stage2 = (Stage) adminLogin.getScene().getWindow();
            stage2.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.adminView));
            Parent root = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("Administrator - " + usernameField.getText());
            stage.show();
            log.info("Admin " + usernameField.getText() + " logged successfully");
        } else {
            labelWrongInfo.setText("Invalid username or password");
            labelWrongInfo.setStyle("-fx-alignment: center; -fx-background-color: white");
            log.error("Wrong username or password");
        }
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.View.HELLO_VIEW));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login Menu");
        stage.setResizable(false);
        stage.show();
    }
}
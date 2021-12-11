package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Statuses;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Usertypes;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class CreateOperatorController {

    private final AdminService service = AdminService.getInstance();
    private static final Logger log = Logger.getLogger(AdminLoginController.class);

    @FXML
    public Button createOperatorButton;

    @FXML
    public TextField opName;

    @FXML
    public PasswordField opPass;

    @FXML
    public TextField opDate;

    @FXML
    public TextField opRating;

    @FXML
    public Button goBackButton;

    @FXML
    public void createOperatorButtonPressed(ActionEvent actionEvent) {
        String name = opName.getText();
        String pass = opPass.getText();
        int date = Integer.parseInt(opDate.getText());
        String rate = opRating.getText();

        Statuses st = new Statuses();
        st.setId(1);

        Usertypes ut = new Usertypes();
        ut.setId(2);

        Users u = new Users(name, pass, date, rate, st, ut);

        service.createOperator(u);
    }

    public void onGoBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.adminView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Administrator Menu");
        stage.show();
    }
}

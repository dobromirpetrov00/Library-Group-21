package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    public TextField opTwoNames;

    @FXML
    public TextField opPhone;

    @FXML
    public TextField opEmail;

    @FXML
    public Label wrongLabel;

    @FXML
    public void createOperatorButtonPressed(ActionEvent actionEvent) {
        String name = opName.getText();
        String pass = opPass.getText();
        //int date = Integer.parseInt(opDate.getText());
        String dateIf = opDate.getText();
        String rate = opRating.getText();
        String twoNames = opTwoNames.getText();
        String phone = opPhone.getText();
        String email = opEmail.getText();

        Statuses st = new Statuses();
        st.setId(1);

        Usertypes ut = new Usertypes();
        ut.setId(2);

        if(name.isBlank()){
            wrongLabel.setText("Enter a username");
        }
        else if(pass.isBlank()){
            wrongLabel.setText("Enter a password");
        }
        else if(dateIf.isBlank() || dateIf.length()!=8) {
            wrongLabel.setText("Enter a valid date (ex: 01012020)");
        }
        else if(rate.isBlank() || rate.length()<1 || rate.length()>10){
            wrongLabel.setText("Enter rating from 1 to 10");
        }
        else if(twoNames.isBlank()){
            wrongLabel.setText("Enter two names");
        }
        else if(phone.isBlank() || phone.length()!=10){
            wrongLabel.setText("Enter phone number - 10 numbers");
        }
        else if(email.isBlank()){
            wrongLabel.setText("Enter an email");
        }
        else {
            int date = Integer.parseInt(opDate.getText());

            Users u = new Users(name, pass, date, rate, st, ut);
            UserInfos v = new UserInfos(twoNames, phone, email, u);
            Forms f = new Forms(date, u);

            service.createOperator(u, v, f);
        }
    }

    @FXML
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

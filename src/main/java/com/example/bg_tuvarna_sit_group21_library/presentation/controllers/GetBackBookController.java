package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import com.example.bg_tuvarna_sit_group21_library.services.BookService;
import com.example.bg_tuvarna_sit_group21_library.services.OperatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class GetBackBookController {
    private final OperatorService service = OperatorService.getInstance();
    private final BookService bservice = BookService.getInstance();
    private static final Logger log = Logger.getLogger(GiveBookController.class);

    @FXML
    public Button getBackBookButton;

    @FXML
    public Button goBackButton;

    @FXML
    public TextField bookId;

    @FXML
    public TextField rdUserId;

    @FXML
    public TextField rdUsername;

    @FXML
    public TextField rdPassword;

    @FXML
    public Label wrongLabel;

    @FXML
    public void getBackBookButtonClick(ActionEvent actionEvent) {
        Integer readerID = Integer.parseInt(rdUserId.getText());
        Integer bookID = Integer.parseInt(bookId.getText());
        String username = rdUsername.getText();
        String password = rdPassword.getText();

        Books book = new Books();
        book.setId(bookID);

        Users reader = new Users();
        reader.setId(readerID);

        bservice.rmvBookUserLend(book,reader);
//        bservice.rmvUserFromLendBook(reader);
//        bservice.rmvBookFromLendInfos(book);
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.operatorView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Operator Menu");
        stage.setResizable(false);
        stage.show();
    }
}

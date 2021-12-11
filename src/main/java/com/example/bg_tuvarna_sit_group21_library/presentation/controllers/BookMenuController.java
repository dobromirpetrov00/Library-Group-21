package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Statuses;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Usertypes;
import com.example.bg_tuvarna_sit_group21_library.services.BookService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class BookMenuController {

    private final BookService service = BookService.getInstance();
    private static final Logger log = Logger.getLogger(BookMenuController.class);

    @FXML
    public Button addBookButton;

    @FXML
    public Button giveBookButton;

    @FXML
    public Button archiveBookButton;

    @FXML
    public Button scrapBookButton;

    @FXML
    public Button goBackButton;

    @FXML
    public void onAddBookButtonClick(ActionEvent actionEvent) throws IOException {

        Stage stage2 = (Stage) addBookButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.addBookView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Add Book");
        stage.show();

//        String name = opName.getText();
//        String pass = opPass.getText();
//        int date = Integer.parseInt(opDate.getText());
//        String rate = opRating.getText();
//
//        Statuses st = new Statuses();
//        st.setId(1);
//
//        Usertypes ut = new Usertypes();
//        ut.setId(2);
//
//        Users u = new Users(name, pass, date, rate, st, ut);
//
//        service.addBook(addbook);
    }

    @FXML
    public void onGiveBookButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) giveBookButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.giveBookView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Give Book");
        stage.show();
    }

    @FXML
    public void onArchiveBookButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) archiveBookButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.archiveBookView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Archive Book");
        stage.show();
    }

    @FXML
    public void onScrapBookButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) scrapBookButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.scrapBookView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Scrap Book");
        stage.show();
    }

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
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

package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
import com.example.bg_tuvarna_sit_group21_library.services.AdminService;
import com.example.bg_tuvarna_sit_group21_library.services.BookService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class AddBookController {
    private final BookService service = BookService.getInstance();
    private static final Logger log = Logger.getLogger(AdminLoginController.class);

    @FXML
    public Button goBackButton;

    @FXML
    public Button addBookButton;

    @FXML
    public TextField bookName;

    @FXML
    public TextField bookAuthor;

    @FXML
    public TextField bookGenre;

    @FXML
    public TextField bookYear;

    @FXML
    public TextField bookIsForArchive;

    @FXML
    public TextField bookTotal;

    @FXML
    public TextField bookAvailable;

    @FXML
    public TextField bookReadingRoom;

    @FXML
    public void goBackButtonClick(ActionEvent actionEvent) throws IOException {
        Stage stage2 = (Stage) goBackButton.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LoginView.bookOptionsView));
        Parent root = (Parent) fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Book Menu");
        stage.show();
    }

    @FXML
    public void addBookButtonClick(ActionEvent actionEvent) {

        //info za books
        String name = bookName.getText();
        String author = bookAuthor.getText();
        String genre = bookGenre.getText();
        int year = Integer.parseInt(bookYear.getText());
        String isForArchive = bookIsForArchive.getText();

        //info za booksstored
        int total = Integer.parseInt(bookTotal.getText());
        int available = Integer.parseInt(bookAvailable.getText());
        int readingRoom = Integer.parseInt(bookReadingRoom.getText());

        //info za exemplars


        //define Books
        Books book = new Books(name,author,genre,year,isForArchive);

        //define Booksstored
        Booksstored booksstored = new Booksstored(total,available,readingRoom);

        Bookstates bs = new Bookstates();


        //define Exemplars
        Exemplars ex = new Exemplars(book,);


        //service.addBook(book,booksstored,);

//        String name = opName.getText();
//        String pass = opPass.getText();
//        int date = Integer.parseInt(opDate.getText());
//        String rate = opRating.getText();
//        String twoNames = opTwoNames.getText();
//        String phone = opPhone.getText();
//        String email = opEmail.getText();
//
//        Statuses st = new Statuses();
//        st.setId(1);
//
//        Usertypes ut = new Usertypes();
//        ut.setId(2);
//
//        Users u = new Users(name, pass, date, rate, st, ut);
//        UserInfos v = new UserInfos(twoNames, phone, email, u);
//
//        Forms f = new Forms(date, u);
//
//        service.createOperator(u, v, f);
    }
}

package com.example.bg_tuvarna_sit_group21_library.presentation.controllers;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Booksstored;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Exemplars;
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

public class ScrapBookController {
    private final BookService service = BookService.getInstance();
    private static final Logger log = Logger.getLogger(ScrapBookController.class);

    @FXML
    public Button goBackButton;

    @FXML
    public Button scrapBookButton;

    @FXML
    public TextField bookIdDel;

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

//    @FXML
//    public void scrapBookButtonClick(ActionEvent actionEvent) {
//        Integer bookIdGet = Integer.parseInt(bookIdDel.getText());
//
//        Books books = new Books();
//        books.setId(bookIdGet);
//
//        Exemplars exemplar = new Exemplars();
//        exemplar.setBookBookid(books);
//
//        service.deleteBook(books,exemplar);
//    }

    @FXML
    public void scrapBookButtonClick(ActionEvent actionEvent) {
        Integer bookIdGet = Integer.parseInt(bookIdDel.getText());

        Books book = new Books();
        book.setId(bookIdGet);

        Booksstored booksstored = new Booksstored();
        booksstored.setBooks(book);

        Exemplars exemplar = new Exemplars();
        exemplar.setBookBookid(book);

        service.deleteBook(book,booksstored,exemplar);
    }
}

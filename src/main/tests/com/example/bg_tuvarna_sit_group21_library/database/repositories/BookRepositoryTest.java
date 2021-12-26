package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {
    private Query query;
    boolean VarAlreadySetToArchiveLater;
    private BookRepository repository;
    private Books book1;

    @BeforeEach
    void setUp() {
        VarAlreadySetToArchiveLater = query.uniqueResult() != null;
        book1.setId(2);
    }

    @Test
    void alreadySetToArchiveLater() {
        assertEquals(VarAlreadySetToArchiveLater,repository.alreadySetToArchiveLater(book1));
    }

    @Test
    void archiveBookForLater() {
    }

    @Test
    void addBook() {
    }

    @Test
    void removeBookFromAvailable() {
    }

    @Test
    void ifLeftEnough() {
    }

    @Test
    void ifExists() {
    }

    @Test
    void ifArchived() {
    }

    @Test
    void archiveBook() {
    }

    @Test
    void deleteBook() {
    }

    @Test
    void ifLendbookIDExists() {
    }

    @Test
    void getLendBookId() {
    }

    @Test
    void removeBookUserLend() {
    }

    @Test
    void addBookToAvailable() {
    }

    @Test
    void getBooksInfo() {
    }

    @Test
    void getLendBooksInfo() {
    }
}
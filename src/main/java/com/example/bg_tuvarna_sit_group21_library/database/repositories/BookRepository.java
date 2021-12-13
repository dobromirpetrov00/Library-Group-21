package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Connect.Connection;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Booksstored;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Exemplars;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookRepository {
    public static BookRepository getInstance() { return BookRepository.BookRepositoryHolder.INSTANCE;}

    private static class BookRepositoryHolder {
        public static final BookRepository INSTANCE = new BookRepository();
    }

    private static final Logger log = Logger.getLogger(BookRepository.class);

    public void addBook(Books book, Booksstored booksstored, Exemplars exemplars){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(book);
            session.save(booksstored);
            session.save(exemplars);
            log.info("Book added successfully");
        } catch (Exception ex) {
            log.error("Add book error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }
}

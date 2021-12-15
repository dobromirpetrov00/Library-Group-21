package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Connect.Connection;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Booksstored;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Bookstates;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Exemplars;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;

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

    public boolean ifExists(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String exists = "select 1 from Books t where t.id=:id";
        Query query = session.getSession().createQuery(exists);
        query.setParameter("id",book.getId());

        return (query.uniqueResult() != null);
    }

    public boolean ifArchived(Books book, Bookstates bookstate){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String archived = "select 1 from Exemplars where bookBookid=:bookBookid and stateStateid=:stateStateid";
        Query query = session.getSession().createQuery(archived);
        query.setParameter("bookBookid",book);
        query.setParameter("stateStateid",bookstate);

        return (query.uniqueResult() != null);
    }

    // трябва проверката дали е архивирана да става в exemplars
//    public boolean ifArchived(Books book){
//        Session session = Connection.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        String archived = "select 1 from Books where id=:id and isarchived=:isarchived";
//        Query query = session.getSession().createQuery(archived);
//        query.setParameter("id",book.getId());
//        query.setParameter("isarchived","no");
//
//        return (query.uniqueResult() != null);
//    }

    //не трябва да се променя isarchived
    public void archiveBook(Books book, Exemplars exemplar, Booksstored booksstored) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer bkid = book.getId();

        try {
            String exupd = "UPDATE Exemplars SET stateStateid = 2 WHERE bookBookid = :bookBookid";
            Query exquery = session.getSession().createQuery(exupd);
            exquery.setParameter("bookBookid", book);

            String bkstupd = "UPDATE Booksstored SET readingroom = readingroom - 1, total = total - 1 WHERE id = :id";
            Query bkstquery = session.getSession().createQuery(bkstupd);
            bkstquery.setParameter("id", bkid);

//            String bkupd = "UPDATE Books SET isarchived = 'yes' WHERE id = :id";
//            Query bookquery = session.getSession().createQuery(bkupd);
//            bookquery.setParameter("id", bkid);

//            bookquery.executeUpdate();
            bkstquery.executeUpdate();
            exquery.executeUpdate();

            log.info("Book archived successfully");
        } catch (Exception e) {
            log.error("Archive book error: " + e.getMessage());
        } finally {
            transaction.commit();
        }
    }

//    public void archiveBook(Books book, Exemplars exemplar, Booksstored booksstored){
//        Session session = Connection.openSession();
//        Transaction transaction = session.beginTransaction();
//        try{
//            session.update(book);
//            session.update(exemplar);
//            session.update(booksstored);
//
//            log.info("Book archived successfully");
//        } catch (Exception e){
//            log.error("Archive book error: " + e.getMessage());
//        } finally {
//            transaction.commit();
//        }
//    }

    public void deleteBook(Books book, Booksstored booksstored, Exemplars exemplars) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {

            String exsql = "delete from Exemplars where bookBookid=:bookBookid";
            Query exempq = session.createQuery(exsql);
            exempq.setParameter("bookBookid",exemplars.getBookBookid());

            String bssql = "delete from Booksstored where id=:id";
            Query booksstq = session.createQuery(bssql);
            booksstq.setParameter("id",book.getId());

            String booksql = "delete from Books where id=:id";
            Query bookq = session.createQuery(booksql);
            bookq.setParameter("id",book.getId());

            exempq.executeUpdate();
            booksstq.executeUpdate();
            bookq.executeUpdate();

            log.info("Book deleted successfully");
        } catch (Exception ex) {
            log.error("Delete book error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }
}

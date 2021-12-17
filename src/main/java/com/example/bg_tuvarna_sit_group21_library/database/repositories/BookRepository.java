package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Connect.Connection;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class BookRepository {
    public static BookRepository getInstance() { return BookRepository.BookRepositoryHolder.INSTANCE;}

    private static class BookRepositoryHolder {
        public static final BookRepository INSTANCE = new BookRepository();
    }

    private static final Logger log = Logger.getLogger(BookRepository.class);

    public boolean alreadySetToArchiveLater(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer bkid = book.getId();
        String bkarch = "yes";

        String exists = "select 1 from Books t where t.id=:id and t.isarchived=:isarch";
        Query query = session.getSession().createQuery(exists);
        query.setParameter("id",bkid);
        query.setParameter("isarch",bkarch);

        return (query.uniqueResult() != null);
    }

    public void archiveBookForLater(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer bkid = book.getId();

        try {
            String bkupd = "UPDATE Books SET isarchived = 'yes' WHERE id = :id";
            Query bookquery = session.getSession().createQuery(bkupd);
            bookquery.setParameter("id", bkid);

            bookquery.executeUpdate();
            log.info("Book successfully set to archive for later");
        } catch (Exception e){
            log.error("Archive for later error: " + e.getMessage());
        } finally {
            transaction.commit();
        }
    }

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

    public void removeBookFromAvailable(Books book){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer bkid = book.getId();

        try {
            String bkstupd = "UPDATE Booksstored SET available = available - 1, total = total - 1 WHERE id = :id";
            Query bkstquery = session.getSession().createQuery(bkstupd);
            bkstquery.setParameter("id", bkid);

            bkstquery.executeUpdate();
            log.info("Removed one book from available");
        } catch (Exception e){
            log.error("Remove one from available error: " + e.getMessage());
        } finally {
            transaction.commit();
        }
    }

/*    public Integer getLendBooksId(Users user){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String lndbookid = "SELECT 1 FROM Lendbooks WHERE usersUserid=:id";
        Query lndbkqry = session.getSession().createQuery(lndbookid);
        lndbkqry.setParameter("id", user);

        lndbkqry.executeUpdate();
        log.info("Get Lendbook ID successfully");

        return
    }*/

//    public void removeBookFromLendInfos(Books book){
//        Session session = Connection.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Integer bkid = book.getId();
//
//        try {
//            String bkstupd = "DELETE FROM Lendinfos WHERE bookBookid = :id";
//            Query bkstquery = session.getSession().createQuery(bkstupd);
//            bkstquery.setParameter("id", book);
//
//            bkstquery.executeUpdate();
//            log.info("Book returned successfully");
//        } catch (Exception e){
//            log.error("Book return error: " + e.getMessage());
//        } finally {
//            transaction.commit();
//        }
//    }
//
//    public void removeUserFromLendBooks(Users reader){
//        Session session = Connection.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Integer user__id = reader.getId();
//
//        try {
//            String bkstupd = "DELETE FROM Lendbooks WHERE usersUserid = :id";
//            Query bkstquery = session.getSession().createQuery(bkstupd);
//            bkstquery.setParameter("id", reader);
//
//            bkstquery.executeUpdate();
//            log.info("Book returned successfully");
//        } catch (Exception e){
//            log.error("Book return error: " + e.getMessage());
//        } finally {
//            transaction.commit();
//        }
//    }

    public boolean ifLeftEnough(Books book, Booksstored bookstored){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        String exists = "select 1 from Booksstored t where t.id=:id and t.available>0";
        Query query = session.getSession().createQuery(exists);
        query.setParameter("id",book.getId());

        return (query.uniqueResult() != null);
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

    public void removeBookUserLend(Books book, Users reader){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        try{
            String booksql = "delete from Lendinfos where bookBookid=:bkid";
            Query bookqry = session.createQuery(booksql);
            bookqry.setParameter("bkid",book);

            /*String readersql = "delete from Lendbooks where usersUserid=:rdrid";
            Query readerqry = session.createQuery(readersql);
            readerqry.setParameter("rdrid",reader);*/

            bookqry.executeUpdate();
            //readerqry.executeUpdate();

            log.info("Book returned successfully");
        } catch (Exception e){
            log.error("Book return error: " + e.getMessage());
        } finally {
            transaction.commit();
        }
    }

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

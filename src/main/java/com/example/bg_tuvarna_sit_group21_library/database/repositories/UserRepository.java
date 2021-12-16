package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Connect.Connection;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Forms;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.UserInfos;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UsersListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private static final Logger log = Logger.getLogger(UserRepository.class);

    public static UserRepository getInstance() { return UserRepository.UserRepositoryHolder.INSTANCE;}

    private static class UserRepositoryHolder {
        public static final UserRepository INSTANCE = new UserRepository();
    }

    public List<Users> getAllUsers() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Users> users = new LinkedList<>();
        try {
            String jpql = "SELECT t FROM Users t";
            users.addAll(session.createQuery(jpql, Users.class).getResultList());
            log.info("Get all users");
        } catch (Exception ex) {
            log.error("Get users error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }

        return users;
    }

    public List<Books> getAllNeedToBeArchived(){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Books> books = new LinkedList<>();

        String archived = "SELECT t FROM Books t";

        books.addAll(session.createQuery(archived, Books.class).getResultList());

        return books;
    }

//    public int getAllNeedToBeArchived(){
//        Session session = Connection.openSession();
//        Transaction transaction = session.beginTransaction();
//        List<Books> books = new LinkedList<>();
//
//        int count = 0;
//        String yes="yes";
//
//        String archived = "SELECT t FROM Books t";
//
//        books.addAll(session.createQuery(archived, Books.class).getResultList());
//
//        for(Books b : books){
//            if(b.getIsarchived().equals(yes))
//                count++;
//        }
//
//        return count;
//    }

    public void createUser(Users user, UserInfos userInfos, Forms forms){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(user);
            session.save(forms);
            session.save(userInfos);
            log.info("User created successfully");
        } catch (Exception ex) {
            log.error("Insert user error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }

    public void createReader(Users user, UserInfos userInfos, Forms forms){
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(user);
            session.save(forms);
            session.save(userInfos);
            log.info("Reader created successfully");
        } catch (Exception ex) {
            log.error("Insert reader error: " + ex.getMessage());
            //Connection.openSessionClose();
        } finally {
            transaction.commit();
        }
    }

    public Integer getLastId() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();

        Integer lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();

        return lastId;
    }

}

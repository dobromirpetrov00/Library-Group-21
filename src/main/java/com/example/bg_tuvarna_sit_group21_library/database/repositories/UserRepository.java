package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Connect.Connection;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

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
            Connection.openSessionClose();
        } finally {
            transaction.commit();
        }

        return users;
    }
}

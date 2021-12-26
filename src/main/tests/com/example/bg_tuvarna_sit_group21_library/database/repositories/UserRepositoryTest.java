package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;
    private boolean VarIfReaderExists, VarIfExists;
    private Users userIfReaderExists, userIfExists;

    @BeforeEach
    void setUp() {
        //ifReaderExists
        userRepository = UserRepository.getInstance();
        VarIfReaderExists = true;
        userIfReaderExists = new Users();
        userIfReaderExists.setId(1);

        //ifExists
        VarIfExists = true;
        userIfExists = new Users();
        userIfExists.setId(2);
        userIfExists.setUsername("lyuboslav");
        userIfExists.setPassword("1234");
    }

    @Test
    void getSubmittedFormsAll() {
    }

    @Test
    void getUsersRatingAll() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getAllNeedToBeArchived() {
    }

    @Test
    void lendBook() {
    }

    @Test
    void createUser() {
    }

    @Test
    void createReader() {
    }

    @Test
    void deleteReader() {
    }

    // DONE
    @Test
    void ifReaderExists() {
        assertEquals(VarIfReaderExists,userRepository.ifReaderExists(userIfReaderExists));
    }

    // DONE
    @Test
    void ifExists() {
        assertEquals(VarIfExists,userRepository.ifExists(userIfExists));
    }

    @Test
    void getUsersInfo() {
    }
}
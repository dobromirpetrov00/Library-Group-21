package com.example.bg_tuvarna_sit_group21_library.database.repositories;

import org.apache.log4j.Logger;

public class UserRepository {
    private static final Logger log = Logger.getLogger(UserRepository.class);

    private static UserRepository getInstance() { return UserRepository.UserRepositoryHolder.INSTANCE;}

    private static class UserRepositoryHolder {
        public static final UserRepository INSTANCE = new UserRepository();
    }


}

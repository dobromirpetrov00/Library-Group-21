package com.example.bg_tuvarna_sit_group21_library.services;

import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import com.example.bg_tuvarna_sit_group21_library.database.repositories.UserRepository;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UsersListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class OperatorService {
    private final UserRepository repository = UserRepository.getInstance();

    public static OperatorService getInstance() {
        return OperatorService.OperatorServiceHolder.INSTANCE;
    }

    private static class OperatorServiceHolder {
        public static final OperatorService INSTANCE = new OperatorService();
    }

    public ObservableList<UsersListViewModel> getAllUsers() {
        List<Users> users = repository.getAllUsers();

        return FXCollections.observableList(
                users
                        .stream()
                        .map(t -> new UsersListViewModel(
                                t.getId(),
                                t.getUsername(),
                                t.getPassword(),
                                t.getApprovaldate(),
                                t.getRating(),
                                t.getStatusStatusid().getId(),
                                t.getUserUsertypeid().getId()
                        )).collect(Collectors.toList()));
    }



    public boolean operatorLogin(UsersListViewModel a) {

        ObservableList<UsersListViewModel> allUsers = getAllUsers();
        boolean login = false;

        for(UsersListViewModel oper:allUsers) {
            if(oper.getUsername().equals(a.getUsername())) {
                if(oper.getPassword().equals(a.getPassword()))
                    login=true;
            }
        }

        return login;
    }
}

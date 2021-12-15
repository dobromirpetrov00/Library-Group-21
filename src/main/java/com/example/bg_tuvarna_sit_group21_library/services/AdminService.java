package com.example.bg_tuvarna_sit_group21_library.services;

import com.example.bg_tuvarna_sit_group21_library.constants.Constants;
import com.example.bg_tuvarna_sit_group21_library.database.Connect.Connection;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Forms;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.UserInfos;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Users;
import com.example.bg_tuvarna_sit_group21_library.database.repositories.UserRepository;
import com.example.bg_tuvarna_sit_group21_library.presentation.models.UsersListViewModel;
import com.example.bg_tuvarna_sit_group21_library.database.Connect.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class AdminService {
    private final UserRepository repository = UserRepository.getInstance();

    public static AdminService getInstance() {
        return AdminServiceHolder.INSTANCE;
    }

    private static class AdminServiceHolder {
        public static final AdminService INSTANCE = new AdminService();
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

    public boolean adminLogin(UsersListViewModel a) {

        ObservableList<UsersListViewModel> allUsers = getAllUsers();
        boolean login = false;

        for(UsersListViewModel admin:allUsers) {
            if(admin.getUsername().equals(a.getUsername())) {
                if(admin.getPassword().equals(a.getPassword()))
                    if(admin.getUser_usertypeid()==1)
                        login=true;
            }
        }

        return login;
    }

    public void createOperator(Users a, UserInfos v, Forms f){
        repository.createUser(a, v, f);
    }

    public Integer returnLastId(){
        return repository.getLastId();
    }

    public int needToBeArchive(){ return repository.getAllNeedToBeArchived(); }
}

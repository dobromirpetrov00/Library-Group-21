package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "user_infos")
public class UserInfos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
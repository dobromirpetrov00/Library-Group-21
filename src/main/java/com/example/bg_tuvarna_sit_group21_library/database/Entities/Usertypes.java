package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "usertypes")
public class Usertypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usertypeid", nullable = false)
    private Integer id;

    @Column(name = "usertype", nullable = false, length = 30)
    private String usertype;


}
package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "bookstates")
public class Bookstates {
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stateid", nullable = false)
    private Integer id;

    @OneToOne(mappedBy = "stateStateid")
    private Exemplars exemplars;

    @Column(name = "state", nullable = false, length = 30)
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
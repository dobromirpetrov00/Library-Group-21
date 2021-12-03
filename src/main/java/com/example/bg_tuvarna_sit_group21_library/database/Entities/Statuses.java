package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
public class Statuses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statusid", nullable = false)
    private Integer id;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exemplars getExemplars() {
        return exemplars;
    }

    public void setExemplars(Exemplars exemplars) {
        this.exemplars = exemplars;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Bookstates{" +
                "id=" + id +
                ", exemplars=" + exemplars +
                ", state='" + state + '\'' +
                '}';
    }
}
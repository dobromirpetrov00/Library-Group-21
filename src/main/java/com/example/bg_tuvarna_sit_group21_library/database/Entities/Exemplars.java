package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "exemplars")
public class Exemplars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exemplarid", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_stateid_stateid", referencedColumnName = "stateid")
    private Bookstates stateStateid;

    @OneToOne(optional = false)
    @JoinColumn(name = "book_bookid_bookid", nullable = false)
    private Books bookBookid;

    public Bookstates getStateStateid() {
        return stateStateid;
    }

    public void setStateStateid(Bookstates stateStateid) {
        this.stateStateid = stateStateid;
    }

    public Books getBookBookid() {
        return bookBookid;
    }

    public void setBookBookid(Books bookBookid) {
        this.bookBookid = bookBookid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
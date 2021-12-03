package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "lendbooks")
public class Lendbooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lendbooksid", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_userid", nullable = false)
    private Users usersUserid;

    @Column(name = "lenddate", nullable = false)
    private Integer lenddate;

    public Integer getLenddate() {
        return lenddate;
    }

    public void setLenddate(Integer lenddate) {
        this.lenddate = lenddate;
    }

    public Users getUserUserid() {
        return usersUserid;
    }

    public void setUserUserid(Users usersUserid) {
        this.usersUserid = usersUserid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
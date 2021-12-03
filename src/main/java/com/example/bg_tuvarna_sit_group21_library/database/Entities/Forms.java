package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "forms")
public class Forms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "formid", nullable = false)
    private Integer id;

    @Column(name = "creationdate", nullable = false)
    private Integer creationdate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_userid", nullable = false)
    private Users usersUserid;

    public Users getUserUserid() {
        return usersUserid;
    }

    public void setUserUserid(Users usersUserid) {
        this.usersUserid = usersUserid;
    }

    public Integer getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Integer creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
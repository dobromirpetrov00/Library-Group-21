package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Column(name = "approvaldate", nullable = false)
    private Integer approvaldate;

    @Column(name = "rating", nullable = false, length = 30)
    private String rating;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status_statusid", nullable = false)
    private Statuses statusStatusid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lend_lendbooksid", nullable = false)
    private Lendbooks lendLendbooksid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_usertypeid", nullable = false)
    private Usertypes userUsertypeid;

    public Usertypes getUserUsertypeid() {
        return userUsertypeid;
    }

    public void setUserUsertypeid(Usertypes userUsertypeid) {
        this.userUsertypeid = userUsertypeid;
    }

    public Lendbooks getLendLendbooksid() {
        return lendLendbooksid;
    }

    public void setLendLendbooksid(Lendbooks lendLendbooksid) {
        this.lendLendbooksid = lendLendbooksid;
    }

    public Statuses getStatusStatusid() {
        return statusStatusid;
    }

    public void setStatusStatusid(Statuses statusStatusid) {
        this.statusStatusid = statusStatusid;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getApprovaldate() {
        return approvaldate;
    }

    public void setApprovaldate(Integer approvaldate) {
        this.approvaldate = approvaldate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
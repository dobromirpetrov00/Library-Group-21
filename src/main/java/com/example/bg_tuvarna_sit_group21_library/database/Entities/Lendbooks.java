package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "lendbooks")
public class Lendbooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lendbooksid", nullable = false)
    private Integer id;

    @Column(name = "lenddate", nullable = false)
    private Integer lenddate;

    @OneToOne(mappedBy = "lendLendbooksid")
    private Lendinfos lendinfos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_userid", nullable = false)
    private Users usersUserid;

    
}
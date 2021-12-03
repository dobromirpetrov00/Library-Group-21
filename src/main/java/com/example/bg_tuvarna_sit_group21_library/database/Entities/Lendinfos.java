package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "lendinfos")
public class Lendinfos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lendinfoid", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lend_lendbooksid", nullable = false)
    private Lendbooks lendLendbooksid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_bookid", nullable = false)
    private Books bookBookid;

    public Books getBookBookid() {
        return bookBookid;
    }

    public void setBookBookid(Books bookBookid) {
        this.bookBookid = bookBookid;
    }

    public Lendbooks getLendLendbooksid() {
        return lendLendbooksid;
    }

    public void setLendLendbooksid(Lendbooks lendLendbooksid) {
        this.lendLendbooksid = lendLendbooksid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
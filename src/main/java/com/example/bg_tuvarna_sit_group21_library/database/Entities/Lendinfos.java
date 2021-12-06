package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "lendinfos")
public class Lendinfos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lendinfoid", nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_bookid", referencedColumnName = "bookid")
    private Books bookBookid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lend_lendbooksid", referencedColumnName = "lendbooksid")
    private Lendbooks lendLendbooksid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Lendinfos{" +
                "id=" + id +
                ", bookBookid=" + bookBookid +
                ", lendLendbooksid=" + lendLendbooksid +
                '}';
    }
}
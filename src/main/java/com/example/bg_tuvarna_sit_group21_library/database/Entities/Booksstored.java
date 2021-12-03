package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "booksstored")
public class Booksstored {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid", nullable = false)
    private Integer id;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "available", nullable = false)
    private Integer available;

    @Column(name = "readingroom", nullable = false)
    private Integer readingroom;

    public Integer getReadingroom() {
        return readingroom;
    }

    public void setReadingroom(Integer readingroom) {
        this.readingroom = readingroom;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
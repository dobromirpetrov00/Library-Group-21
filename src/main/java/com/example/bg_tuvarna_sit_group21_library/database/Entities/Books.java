package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Books implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid", nullable = false)
    private Integer id;

    @Column(name = "bookname", nullable = false, length = 60)
    private String bookname;

    @Column(name = "author", nullable = false, length = 60)
    private String author;

    @Column(name = "genre", nullable = false, length = 30)
    private String genre;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "isarchived", nullable = false, length = 30)
    private String isarchived;

    public String getIsarchived() {
        return isarchived;
    }

    public void setIsarchived(String isarchived) {
        this.isarchived = isarchived;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", isarchived='" + isarchived + '\'' +
                '}';
    }
}
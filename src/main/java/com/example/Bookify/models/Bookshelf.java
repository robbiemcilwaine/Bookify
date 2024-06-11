package com.example.Bookify.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookshelves")
public class Bookshelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "bookshelf_books",
            joinColumns = @JoinColumn(name = "bookshelf_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")    )
    private List<Book> books;

//    @OneToMany(mappedBy = "bookshelves")
//    @JoinColumn(name = "bookshelves_id")
//
//    @JsonIgnoreProperties("{bookshelves}")
//    private List<Book> books;


    public Bookshelf(long id, User user, String name) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public Bookshelf() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}

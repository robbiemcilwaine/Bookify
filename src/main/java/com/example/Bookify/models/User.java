package com.example.Bookify.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"users"})
    private List<UsersBooks> usersBooks;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<Bookshelf> bookshelves;

    public User(String username) {
        this.username = username;
        this.usersBooks = new ArrayList<>();
        this.bookshelves = new ArrayList<>();
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UsersBooks> getUsersBooks() {
        return usersBooks;
    }

    public void setUsersBooks(List<UsersBooks> usersBooks) {
        this.usersBooks = usersBooks;
    }

    public List<Bookshelf> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<Bookshelf> bookshelves) {
        this.bookshelves = bookshelves;
    }
}

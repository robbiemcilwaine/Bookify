package com.example.Bookify.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "users_books")
public class UsersBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"usersBooks"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties({"usersBooks"})
    private Book book;

    @Enumerated(EnumType.STRING)
    private ReadingStatus readingStatus;

    public UsersBooks(User user, Book book) {
        this.user = user;
        this.book = book;
        this.readingStatus = ReadingStatus.UNASSIGNED;
    }

    public UsersBooks() {

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReadingStatus getReadingStatus() {
        return readingStatus;
    }

    public void setReadingStatus(ReadingStatus readingStatus) {
        this.readingStatus = readingStatus;
    }
}

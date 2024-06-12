package com.example.Bookify.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String isbn;

    @Column(name = "publication_year")
    private LocalDate publicationYear;

    @Column
    private double rating;

    @Enumerated(EnumType.STRING)
    private Genre genre;


    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties({"books"})
    private List<UsersBooks> usersBooks;

    @ManyToMany
    @JoinTable(
            name = "bookshelf_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "bookshelf_id")    )
    @JsonIgnoreProperties({"books"})
    private List<Bookshelf> bookshelves;


    public Book(String title, String author, String isbn, LocalDate publicationYear, double rating, Genre genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.rating = rating;
        this.genre = genre;
        this.bookshelves = new ArrayList<>();
        this.usersBooks = new ArrayList<>();
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Bookshelf> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<Bookshelf> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public List<UsersBooks> getUsersBooks() {
        return usersBooks;
    }

    public void setUsersBooks(List<UsersBooks> usersBooks) {
        this.usersBooks = usersBooks;
    }
}

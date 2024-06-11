package com.example.Bookify.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

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

    @ManyToMany
    @JoinTable(name = "bookshelves_books",
            @JoinColumn(name = "bookshelf_id"),
            @JoinColumn(name = "book_id")
    )
//    @OneToMany(mappedBy = "bookshelves")
//    @JoinColumn(name = "bookshelves_id")
//
//    @JsonIgnoreProperties("{bookshelves}")
//    private List<Book> books;

}

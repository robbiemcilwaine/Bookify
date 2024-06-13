package com.example.Bookify.controllers;


import com.example.Bookify.models.Book;
import com.example.Bookify.models.User;
import com.example.Bookify.services.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

//    Retrieve all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

//    Get book by id
    @GetMapping(value = ("/{id}"))
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable long id){
        Optional<Book> book = bookService.getBookById(id);
        if(book.isPresent()){
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


//    Delete a specific book
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

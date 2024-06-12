package com.example.Bookify.controllers;

import com.example.Bookify.models.Bookshelf;
import com.example.Bookify.services.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookshelves")
public class BookshelfController {

    @Autowired
    BookshelfService bookshelfService;

//    Retrieve all bookshelves for a user

    @GetMapping(value = ("/user/{id}"))
    public ResponseEntity<List<Bookshelf>> getBookshelvesByUserId(@PathVariable long id){
    List<Bookshelf> bookshelves = bookshelfService.getBookshelvesByUserId(id);
    return new ResponseEntity<>(bookshelves, HttpStatus.OK);
    }


//    Retrieve a specific bookshelf
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Bookshelf>> getBookShelfById(@PathVariable long id){
        Optional<Bookshelf> bookshelf = bookshelfService.getBookshelfByID(id);
        if (bookshelf.isPresent()){
            return new ResponseEntity<>(bookshelf, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Create a new bookshelf
    @PostMapping
    public ResponseEntity<Bookshelf> createBookshelf(@RequestBody Bookshelf bookshelf){
        Bookshelf savedBookshelf = bookshelfService.createBookshelf(bookshelf);
        return new ResponseEntity<>(savedBookshelf, HttpStatus.CREATED);
    }

//   Add book to existing bookshelf
    @PatchMapping(value = "/{id}")


//    Update the name of a specific bookshelf



//    Delete bookshelf by bookshelf_id (this will be mapped by the value = “bookshelves_id”)


}

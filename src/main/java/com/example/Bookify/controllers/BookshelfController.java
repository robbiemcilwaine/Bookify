package com.example.Bookify.controllers;

import com.example.Bookify.models.Bookshelf;
import com.example.Bookify.services.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




//    Create a new bookshelf


//   Add book to existing bookshelf



//    Update the name of a specific bookshelf



//    Delete bookshelf by bookshelf_id (this will be mapped by the value = “bookshelves_id”)


}

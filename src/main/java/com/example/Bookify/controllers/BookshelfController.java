package com.example.Bookify.controllers;

import com.example.Bookify.services.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookshelves")
public class BookshelfController {

    @Autowired
    BookshelfService bookshelfService;

//    Retrieve all bookshelves for a user

    @GetMapping

}

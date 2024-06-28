package com.example.Bookify.controllers;


import com.example.Bookify.models.Book;
import com.example.Bookify.models.ReadingStatus;
import com.example.Bookify.models.User;
import com.example.Bookify.models.UsersBooks;
import com.example.Bookify.services.UsersBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users-books")
public class UsersBooksController {

    @Autowired
    UsersBooksService usersBooksService;

    @GetMapping
    public ResponseEntity<List<UsersBooks>> getAllUsersBooks(){
        List<UsersBooks> usersBooks = usersBooksService.getAllUsersBooks();
        return new ResponseEntity<>(usersBooks, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<List<UsersBooks>>> getSpecificUsersBooks(@PathVariable long id){
        Optional<List<UsersBooks>> specificUsersBooks = usersBooksService.getSpecificUsersBooks(id);
        return new ResponseEntity<>(specificUsersBooks, HttpStatus.OK);
    }

    @GetMapping("/{userId}/{bookId}")
    public ResponseEntity<UsersBooks> getUsersBooksByUserIdAndBookId(@PathVariable Long userId, @PathVariable Long bookId) {
        UsersBooks usersBook = usersBooksService.findByUserIdAndBookId(userId, bookId);
        if (usersBook != null) {
            return new ResponseEntity<>(usersBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Optional<UsersBooks>> updateReadingStatus(@PathVariable long id, @RequestParam ReadingStatus readingStatus){
        Optional<UsersBooks> usersBooks = usersBooksService.getUsersBooksById(id);
        if (usersBooks.isPresent()){
            usersBooksService.updateReadingStatus(id, readingStatus);

            return new ResponseEntity<>(usersBooks, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

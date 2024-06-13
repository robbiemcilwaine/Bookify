package com.example.Bookify.controllers;


import com.example.Bookify.models.ReadingStatus;
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

    //    Retrieve all users books
    @GetMapping
    public ResponseEntity<List<UsersBooks>> getAllUsersBooks(){
        List<UsersBooks> usersBooks = usersBooksService.getAllUsersBooks();
        return new ResponseEntity<>(usersBooks, HttpStatus.OK);
    }

//   Get a specific users book
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<UsersBooks>> getUsersBooksById(@PathVariable long id){
        Optional<UsersBooks> userbook = usersBooksService.getUsersBooksById(id);
        return new ResponseEntity<>(userbook, HttpStatus.OK);
    }

//    update reading status of specific book
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

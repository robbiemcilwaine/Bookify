package com.example.Bookify.controllers;


import com.example.Bookify.models.User;
import com.example.Bookify.models.UserDTO;
import com.example.Bookify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

//    Retrieve users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


//    Get users by id

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>>getUserById(@PathVariable long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


//Update the details of a specific user

    @PutMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> updateUser (@PathVariable long id, @RequestBody UserDTO userDTO){
        Optional<User> updatedUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }


//Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

// Delete a specific user
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package com.example.Bookify.components;

import com.example.Bookify.models.User;
import com.example.Bookify.repositories.UserRepository;
import com.example.Bookify.services.BookService;
import com.example.Bookify.services.BookshelfService;
import com.example.Bookify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserService userService;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        User robbie = new User("Zinizanzo");
        userService.createUser(robbie);

        User charisma = new User("CHRIMPY");
        userService.createUser(charisma);

        User sabah = new User("Flakeymeerkat");
        userService.createUser(sabah);


    }

}

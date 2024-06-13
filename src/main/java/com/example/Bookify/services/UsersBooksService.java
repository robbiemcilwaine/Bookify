package com.example.Bookify.services;


import com.example.Bookify.models.ReadingStatus;
import com.example.Bookify.models.User;
import com.example.Bookify.models.UsersBooks;
import com.example.Bookify.repositories.BookRepository;
import com.example.Bookify.repositories.UserRepository;
import com.example.Bookify.repositories.UsersBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersBooksService {


    @Autowired
    UsersBooksRepository usersBooksRepository;


    //    Updating reading status

//    public Optional <UsersBooks> updateReadingStatus (long id, ReadingStatus){
//        Optional<UsersBooks> optionalUsersBooks = UsersBooksRepository.findById(id);
//        if (optionalUsersBooks.isPresent()) {
//            UsersBooks usersBooks = optionalUsersBooks.get();
//            UsersBooks.set
//        }
//
//    }





    //    find by reading status






//    public UsersBooks getReadingStatus (long id, ReadingStatus readingStatus) {
//
//
//        List<UsersBooks>usersBooks = usersBooksRepository.findByReadingStatus();
//
//        usersBooks.setReadingStatus(readingStatus);
//        return
//
//    }






}

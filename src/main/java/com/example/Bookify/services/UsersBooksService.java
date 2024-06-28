package com.example.Bookify.services;


import com.example.Bookify.models.ReadingStatus;
import com.example.Bookify.models.User;
import com.example.Bookify.models.UsersBooks;
import com.example.Bookify.repositories.BookRepository;
import com.example.Bookify.repositories.UserRepository;
import com.example.Bookify.repositories.UsersBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UsersBooksService {


    @Autowired
    UsersBooksRepository usersBooksRepository;

    @Autowired
    UserRepository userRepository;

    public List<UsersBooks> getAllUsersBooks(){
        return usersBooksRepository.findAll();
    }

    public Optional<UsersBooks> getUsersBooksById(long id){
        return usersBooksRepository.findById(id);
    }

    public Optional<List<UsersBooks>> getSpecificUsersBooks(long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            List<UsersBooks> usersBooks = optionalUser.get().getUsersBooks();
            return Optional.of(usersBooks);
        }
        else return Optional.empty();
    }

    public UsersBooks findByUserIdAndBookId(Long userId, Long bookId) {
        Optional<UsersBooks> usersBooksOptional = usersBooksRepository.findByUserIdAndBookId(userId, bookId);
        return usersBooksOptional.orElse(null);
    }

    public Optional <UsersBooks> updateReadingStatus (long id, ReadingStatus readingStatus){
        Optional<UsersBooks> optionalUsersBooks = usersBooksRepository.findById(id);
        if (optionalUsersBooks.isPresent()) {
            UsersBooks usersBooks = optionalUsersBooks.get();
            usersBooks.setReadingStatus(readingStatus);
            usersBooksRepository.save(usersBooks);
            return Optional.of(usersBooks);}
         else {
            return Optional.empty();
        }
    }

    public void deleteUserBook(long id) {
        usersBooksRepository.deleteById(id);
    }


}

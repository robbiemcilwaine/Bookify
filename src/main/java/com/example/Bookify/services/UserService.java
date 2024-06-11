package com.example.Bookify.services;

import com.example.Bookify.models.User;
import com.example.Bookify.models.UserDTO;
import com.example.Bookify.repositories.UserRepository;
import com.example.Bookify.repositories.UsersBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersBooksRepository usersBooksRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, UserDTO userDTO){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setUsername(userDTO.getUsername());
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

//userRepository.findById(id) method to retrieve an Optional<User> object based on the provided user ID
//
//Optional<User> is present (i.e., a user with the given ID exists), it extracts the User object using userOptional.get().
//
//updates the user properties based on the values from the UserDTO object
//
//saves the updated User object using userRepository.save(user) and wraps the result in an Optional using Optional.of().
//
//If Optional<User> is empty (i.e., no user with the given ID exists), it returns an empty Optional using Optional.empty().


    public void deleteUser(long id){
        userRepository.deleteById(id);
    }


}

package com.ascent.Spring.Security.Services;

import com.ascent.Spring.Security.Models.User;
import com.ascent.Spring.Security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get Single User by UserName
    public User getUser(String username) {
        return userRepository.findById(username).orElse(null);
    }

    // Add a User
    public User addUser(User user) {
        return userRepository.save(user);
    }
}



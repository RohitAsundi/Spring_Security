package com.ascent.Spring.Security.Controller;

import com.ascent.Spring.Security.Models.User;
import com.ascent.Spring.Security.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Get all users
    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    //Get user by username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    //Add User
    @PostMapping
    public User add(@RequestBody User user){
        return this.userService.addUser(user);
    }
}

package com.retreat.copilot.controller;

import com.retreat.copilot.entity.User;
import com.retreat.copilot.exception.InvalidUserException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    //Create a POST mapping function that takes in a User object with status 200 as response
    @PostMapping("api/users")
    public User register(@RequestBody User user) throws InvalidUserException {
        //Check if  username, email, password are not null
        if(user.getUsername() == null || user.getEmail() == null || user.getPassword() == null) {
            //If any of them are null, return InvalidUser exception
            throw new InvalidUserException("Username, email, and password cannot be null");
        }
        //Check if username length is less than 6  or password length is less than 8
        if(user.getUsername().length() < 6 || user.getPassword().length() < 8) {
            //If any of them are less than the required length, return custom exception
            throw new InvalidUserException("Username must be at least 6 characters and password must be at least 8 characters");
        }
        return user;
    }

    //Create a POST mapping function that takes in a User object and creates a JWT token
    @PostMapping("api/users/login")
    public String login(@RequestBody User user) throws InvalidUserException {
        //Check if  username, email, password are not null
        if(user.getUsername() == null || user.getEmail() == null || user.getPassword() == null) {
            //If any of them are null, return InvalidUser exception
            throw new InvalidUserException("Username, email, and password cannot be null");
        }
        //Check if username length is less than 6  or password length is less than 8
        if(user.getUsername().length() < 6 || user.getPassword().length() < 8) {
            //If any of them are less than the required length, return custom exception
            throw new InvalidUserException("Username must be at least 6 characters and password must be at least 8 characters");
        }
        //Create a JWT token using username, email, password
        String token = User.createJWT(user.getUsername(), user.getEmail(), user.getPassword());
        return token;
    }

    // Create a PUT mapping function for User object
    @PutMapping("api/users")
    public User updateUser(@RequestBody User user) throws InvalidUserException {
        //Check if  username, email, password are not null
        if(user.getUsername() == null || user.getEmail() == null || user.getPassword() == null) {
            //If any of them are null, return InvalidUser exception
            throw new InvalidUserException("Username, email, and password cannot be null");
        }
        //Check if username length is less than 6  or password length is less than 8
        if(user.getUsername().length() < 6 || user.getPassword().length() < 8) {
            //If any of them are less than the required length, return custom exception
            throw new InvalidUserException("Username must be at least 6 characters and password must be at least 8 characters");
        }
        return user;
    }







}

package com.retreat.copilot.controller;

import com.retreat.copilot.entity.User;
import com.retreat.copilot.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAuthenticationController {

        //Create a test function that tests the register function in AuthenticationController
        @Test
        public void testRegisterValidUser() throws InvalidUserException{
                //Create a new User object with username, email, password
                User user = new User("username", "email", "password");

                //Send to register post endpoint and get the response
                User response = new AuthenticationController().register(user);

                //Assert that the username, email, password are equal to the user object's username, email, password
                assert(response.getUsername().equals("username"));
                assert(response.getEmail().equals("email"));
                assert(response.getPassword().equals("password"));

        }

        //Create a test function that tests the register function in AuthenticationController when username is null
        @Test
        public void testRegisterNullUsername() throws InvalidUserException{
                //Create a new User object with username, email, password
                User user = new User(null, "email", "password");

                //Assert that the invaliduserexception is thrown
                assertThrows(InvalidUserException.class, () -> {
                        new AuthenticationController().register(user);
                });
        }


}

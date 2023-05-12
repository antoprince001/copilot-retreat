package com.retreat.copilot.controller;

import com.retreat.copilot.entity.Article;
import com.retreat.copilot.entity.Profile;
import com.retreat.copilot.entity.User;
import com.retreat.copilot.exception.InvalidUserException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@CrossOrigin
public class AuthenticationController {

    ArrayList<Profile> profiles = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Article> articles = new ArrayList<>();

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
        users.add(user);
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
        //For each loop of arraylist of users with conditon to check username matches
        for(User u : users) {
            if(u.getUsername().equals(user.getUsername())) {
                //If username matches, update the user object
                u.setEmail(user.getEmail());
                return u;
            }
        }
        throw new InvalidUserException("User not found");
    }

    //Create a GET mapping to get the profile object
    @GetMapping("api/profiles/{username}")
    public Profile getProfile(@PathVariable("username") String username) throws InvalidUserException {
        //For each loop of arraylist of profiles with conditon to check username matches
        for(Profile p : profiles) {
            if(p.getUsername().equals(username)) {
                //If username matches, return the profile object
                return p;
            }
        }
        //If username does not match, return null
        throw new InvalidUserException("User not found");
    }

//    //Create a POST mapping /api/profiles/:username/follow to update following  by matching them in a for each of profiles arraylist
//    @PostMapping("api/profiles/{username}/follow")
//    public Profile follow(@PathVariable("username") String username, @RequestBody Profile) throws InvalidUserException {
//        //For each loop of arraylist of profiles with conditon to check username matches
//        for(Profile p : profiles) {
//            if(p.getUsername().equals(username)) {
//                //If username matches, add the profile object to the following arraylist
//                p.setFollowing(true);
//                return p;
//            }
//        }
//        //If username does not match, return null
//        throw new InvalidUserException("User not found");;
//    }

    //Create GET /api/articles to get all the articles
//    @GetMapping("api/articles")
//    public ArrayList<Article> getArticles() {
//        return articles;
//    }

    // Create a GET request /api/articles that returns most recent articles globally by default, provide tag, author or favorited query parameter to filter results
    @GetMapping("api/articles")
public ArrayList<Article> getArticles(@RequestParam(value = "tag", required = false) String tag,
                                          @RequestParam(value = "author", required = false) String author,
                                          @RequestParam(value = "favorited", required = false) String favorited,
                                          @RequestParam(value = "limit", required = false) Integer limit,
                                            @RequestParam(value = "offset", required = false) Integer offset
                                      ) {
        //If tag is not null or author is not null or favorited is not null or limit is not null or offset is not null, filter the articles by tag, author favorited, limit, offset
        if(tag != null || author != null || favorited != null || limit != null || offset != null) {
            ArrayList<Article> filteredArticles = new ArrayList<>();
            for(Article a : articles) {
                if(tag != null) {
                    if(Arrays.stream(a.getTagList()).toList().contains(tag)) {
                        filteredArticles.add(a);
                    }
                }
                if(author != null) {
                    if(a.getAuthor().equals(author)) {
                        filteredArticles.add(a);
                    }
                }
                //if favorited is not null, filter the articles by favorited and add them to the filteredArticles arraylist
                if(favorited != null) {
                    if(a.getFavorited().equals(favorited)) {
                        filteredArticles.add(a);
                    }
                }

                if(limit != null) {
                    if(filteredArticles.size() > limit) {
                        filteredArticles.subList(limit, filteredArticles.size()).clear();
                    }
                }
                if(offset != null) {
                    if(filteredArticles.size() > offset) {
                        filteredArticles.subList(0, offset).clear();
                    }
                }
            }
            return filteredArticles;
        }

        //If none of the above conditions are met, return all the articles
        return articles;
    }





}

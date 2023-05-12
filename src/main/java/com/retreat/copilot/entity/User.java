package com.retreat.copilot.entity;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

public class User {
    //Generate user fields username,email,password,image, bio with constructors, getters and setters
    private String username;
    private String email;
    private String password;
    private String image;
    private String bio;
    public User() {
    }

    // Create a constructor that takes username, email, password and sets the image and bio with default values
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.image = "";
        this.bio = "";
    }

    //Getters and setters for username,email,password,image,bio
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public static String createJWT(String username, String email, String password) {
        //create a sha 256 hash of username, email
        return username;

//        //The JWT signature algorithm we will be using to sign the token
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//        //Get current time
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//
//        //Create a new secret key with the secret key
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("secret");
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        //Create the JWT and add the claims
//        JwtBuilder builder = Jwts.builder().setId(username)
//                .setIssuedAt(now)
//                .setSubject(email)
//                .setIssuer("copilot")
//                .claim("username", username)
//                .claim("password", password)
//                .signWith(signatureAlgorithm, signingKey);
//
//        //Set the expiration date
//        long expMillis = nowMillis + 86400000;
//        Date exp = new Date(expMillis);
//        builder.setExpiration(exp);
//
//        //Build the JWT and serialize it to a compact, URL-safe string
//        return builder.compact();
    }

}

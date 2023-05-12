package com.retreat.copilot.entity;

public class Profile {
    // Create username, bio, image, following fields for Profile with constructor, getters and setters
    private String username;
    private String bio;
    private String image;
    private boolean following;

    public Profile() {
    }

    public Profile(String username, String bio, String image, boolean following) {
        this.username = username;
        this.bio = bio;
        this.image = image;
        this.following = following;
    }

    // Getters and setters for username, bio, image, following
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public boolean getFollowing() {
        return following;
    }
    public void setFollowing(boolean following) {
        this.following = following;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}

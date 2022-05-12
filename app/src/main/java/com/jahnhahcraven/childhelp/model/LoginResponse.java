package com.jahnhahcraven.childhelp.model;

public class LoginResponse {
    String authToken;
    User user;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginResponse(String authToken, User user) {
        this.authToken = authToken;
        this.user = user;
    }
}

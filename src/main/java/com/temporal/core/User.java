package com.temporal.core;
public class User {
    public String username;
    public String emailid;

    public User() {
        // Set default values for username and emailid if needed
        this.username = "";
        this.emailid = "";
    }
    public User(String username, String emailid) {
        this.username = username;
        this.emailid = emailid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid){
        this.emailid = emailid;
    }
}

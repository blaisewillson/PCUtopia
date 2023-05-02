package com.pcutopia.pcutopia;

public class User {
    private String username;
    private String email;
    private String password;
    private int userID;

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        setUserID();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    private void setUserID() {
        this.userID = Math.abs((this.username+ " " + this.email).hashCode());
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return this.userID;
    }

    @Override
    public String toString() {
        String userOutput = this.userID + "\n" + this.username+ "\n" + this.email + "\n" + this.password + "\n-------";
        return userOutput;
    }
}

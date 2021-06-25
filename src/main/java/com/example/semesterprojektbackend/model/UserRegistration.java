package com.example.semesterprojektbackend.model;

public class UserRegistration {

    private int userId;
    private String firstname;
    private String lastname;
    private String eMail;
    private String userName;
    private String password;

    public UserRegistration(int userId,String firstname, String lastname, String eMail, String userName, String password) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.eMail = eMail;
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

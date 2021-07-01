package com.example.semesterprojektbackend.model;

public class User {
private int userId;
    private String salutation;
    private String firstname;
    private String lastname;
    private int plz;
    private String city;
    private String street;
    private int houseNumber;
    private String eMail;
    private String userName;
    private String password;
    private boolean active;
    private String role;
    private Cart cart;

    public User(String salutation, String firstname, String lastname, int plz, String city, String street, int houseNumber, String eMail, String userName, String password, boolean active, String role) {
        this.salutation = salutation;
        this.firstname = firstname;
        this.lastname = lastname;
        this.plz = plz;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.eMail = eMail;
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

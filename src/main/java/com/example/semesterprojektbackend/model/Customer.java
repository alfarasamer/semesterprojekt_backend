package com.example.semesterprojektbackend.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
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
    //private Cart cart;

}

package com.example.semesterprojektbackend.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer{

    @SequenceGenerator(
            name = "customers_sequence",
            sequenceName = "customers_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customers_sequence"
    )
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

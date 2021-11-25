package com.example.semesterprojektbackend.model;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemNumber;
    private String productDescription;
    private String productLongDescription;
    private String size;
    @ManyToOne
    @JoinColumn(name = "categoryid",insertable = false,updatable = false)
    private Category category;
    private int categoryid;
    private enum status {A,NA}
    private double price;

}

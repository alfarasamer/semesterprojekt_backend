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
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    //private boolean status;
    private double price;
}

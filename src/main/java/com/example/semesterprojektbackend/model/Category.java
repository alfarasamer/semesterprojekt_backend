package com.example.semesterprojektbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Category {

    @SequenceGenerator(
            name = "categories_sequence",
            sequenceName = "categories_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "categories_sequence"
    )
    private int id;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String categoryName;
}
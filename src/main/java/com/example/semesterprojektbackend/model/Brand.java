package com.example.semesterprojektbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
    @SequenceGenerator(
            name = "brands_sequence",
            sequenceName = "brands_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brands_sequence"
    )
    private int id;
    @NotBlank @Column(nullable = false, unique = true)
    private String brandName;
}

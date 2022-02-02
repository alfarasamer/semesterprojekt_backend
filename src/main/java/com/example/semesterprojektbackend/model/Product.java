package com.example.semesterprojektbackend.model;

import com.example.semesterprojektbackend.model.enumuration.Size;
import com.example.semesterprojektbackend.model.enumuration.Status;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product",
        uniqueConstraints = {@UniqueConstraint(columnNames =
                {"name", "size", "description", "price"})})
public class Product {

    @SequenceGenerator(
            name = "products_sequence",
            sequenceName = "products_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_sequence"
    )
    private Long itemNumber;
    @NotBlank
    @Column(nullable = false)
    @Length(min = 4, message = "Product Name should be at least 4 Chars")
    private String name;
    @NotBlank
    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull

    //@ValueOfEnum(enumClass = Size.class)
    private Size size;

    @ManyToOne
    private Category category;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    @Positive
    @Column(nullable = false)
    private double price;


    @ManyToOne
    private Brand brand;

    private String imageUrl;


}

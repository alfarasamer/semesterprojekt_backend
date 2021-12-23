package com.example.semesterprojektbackend.model;
import com.example.semesterprojektbackend.model.enumuration.Size;
import com.example.semesterprojektbackend.model.enumuration.Status;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemNumber;

    @NotBlank
    @Column(nullable = false)
    private String productDescription;
    private String productLongDescription;

    @NotBlank
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Size size;

    @NotBlank
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @NotBlank
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotBlank
    @Column(nullable = false)
    private double price;
}

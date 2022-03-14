package com.example.semesterprojektbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart")
    //@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @JsonManagedReference
    private List<CartItem> cartItems;
    /*@OneToOne(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )*/
    @OneToOne(cascade = CascadeType.REMOVE)
    //@JoinColumn(name = "user_id")
    private User user;
}

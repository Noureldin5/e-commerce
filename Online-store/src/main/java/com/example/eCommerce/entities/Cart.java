package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String cartItem;

    @ManyToOne
    @JoinColumn(name = "user_id") // column name in the 'carts' table
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<Product> products;
    private LocalDateTime createdAt;
}

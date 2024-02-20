package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;
    private String description;
    private String created_date;
    private Boolean exist = true;

    @ManyToOne
    private Customer customer;

    @ManyToOne()
    private Type type;

    @ManyToOne()
    private Category category;

    public Product(Product productInfo, Integer quantity) {
    }

    public Product() {

    }

    public Object Product(Object productInfo, Integer quantity) {
        return null;
    }
}

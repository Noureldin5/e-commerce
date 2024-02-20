package com.example.eCommerce.entities;

import com.example.eCommerce.enums.Type;
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

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private Customer customer;

    public Product(Product productInfo, Integer quantity) {
    }

    public Product() {

    }

    public Object Product(Object productInfo, Integer quantity) {
        return null;
    }
}

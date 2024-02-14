package com.example.eCommerce.entities;

import com.example.eCommerce.enums.Type;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;
    private String description;
    private String created_date;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Object Product(Object productInfo, Integer quantity) {
        return null;
    }
}

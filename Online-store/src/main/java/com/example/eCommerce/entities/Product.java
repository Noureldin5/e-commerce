package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

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


    private String salesPackage;
    private String modelNumber;
    private String secondaryMaterial;
    private String configuration;
    private String upholsteryMaterial;
    private String upholsteryColor;
    private String fillingMaterial;
    private String finishType;
    private String adjustableHeadrest;
    private int maximumLoadCapacity;
    private String originOfManufacture;
    private double width;
    private double height;
    private double weight;
    private double seatHeight;
    private double legHeight;
    private String warrantySummary;
    private String warrantyServiceType;
    private String coveredInWarranty;
    private String notCoveredInWarranty;
    private String domesticWarranty;


    @ManyToOne
    private Customer customer;

    @ManyToOne()
    private Type type;

    @ManyToOne()
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    public Product(Product productInfo, Integer quantity) {
    }

    public Product() {

    }

    public Object Product(Object productInfo, Integer quantity) {
        return null;
    }
}

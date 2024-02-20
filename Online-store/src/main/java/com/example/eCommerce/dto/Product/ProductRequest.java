package com.example.eCommerce.dto.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {
    private Long id;
    private String name;
    private int price;
    private String description;
    private String created_date;
    private String type;
    private String category;

}

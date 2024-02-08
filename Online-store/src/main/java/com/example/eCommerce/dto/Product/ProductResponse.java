package com.example.eCommerce.dto.Product;

import com.example.eCommerce.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponse {
    private Long id;
    private int price;
    private String description;
    private String created_date;
    private Type type;
}

package com.example.eCommerce.entities;

import com.example.eCommerce.dto.Product.ProductResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {

    private Long id;
    private String serial_number;

    public List<ProductResponse> getProducts() {
        return null;
    }

    public String getBuyerEmail() {
        return null;
    }
}

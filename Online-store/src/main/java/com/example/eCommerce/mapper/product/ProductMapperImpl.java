package com.example.eCommerce.mapper.product;

import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper{
    @Override
    public ProductResponse toDto(Product product) {
        ProductResponse productResponse=new ProductResponse();
        product.setId(product.getId());
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        product.setDescription(product.getDescription());
        product.setCreated_date(product.getCreated_date());
        product.setCategory(product.getCategory());
        product.setType(product.getType());
        return productResponse;
    }

    @Override
    public List<ProductResponse> toDtoS(List<Product> all) {
        List<ProductResponse> productResponses=new ArrayList<>();
        for(Product product:all){
            productResponses.add(toDto(product));
        }
        return productResponses;
    }
}

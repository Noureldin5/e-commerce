package com.example.eCommerce.service.product;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.enums.Type;
import com.example.eCommerce.exception.BadRequestException;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    private boolean containsType(String type) {
        for (Type type1:Type.values()){
            if (type1.name().equalsIgnoreCase(type))
                return true;
        }
        return false;
    }
    @Override
    public void addProduct(ProductRequest productRequest, String token) {
        Product product = new Product();

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCreated_date(LocalDateTime.now().toString());
        if (!containsType(String.valueOf(productRequest.getType())))
            throw new BadRequestException("no type with name: "+productRequest.getType()+"!");
        product.setType(Type.valueOf(String.valueOf(productRequest.getType())));
        productRepository.save(product);
    }
}

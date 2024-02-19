package com.example.eCommerce.service.product.Impl;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.enums.Type;
import com.example.eCommerce.exception.BadRequestException;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.product.ProductMapper;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

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

    @Override
    public void deleteProduct(Long id) {
        if (productRepository.findById(id).isEmpty())
            throw new NotFoundException("the product with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponse getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new NotFoundException("the product with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        return productMapper.toDto(product.get());
    }

    @Override
    public void updateProduct(Long id, ProductRequest productRequest) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new NotFoundException("the product with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        product.get().setName(productRequest.getName());
        product.get().setDescription(productRequest.getDescription());
        product.get().setPrice(productRequest.getPrice());
        if (!containsType(String.valueOf(productRequest.getType())))
            throw new BadRequestException("no type with name: "+productRequest.getType()+"!");
        product.get().setType(Type.valueOf(String.valueOf(productRequest.getType())));
        productRepository.save(product.get());
    }

    @Override
    public List<ProductResponse> getAll() {
            return productMapper.toDtoS(productRepository.findAll());
    }

    @Override
    public void update(String itemId, Integer quantity, User user) {

    }

    @Override
    public Product findOne(String productId) {
        return null;
    }
}

package com.example.eCommerce.service.product.Impl;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Category;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.entities.Type;
import com.example.eCommerce.exception.BadRequestException;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.product.ProductMapper;
import com.example.eCommerce.repositories.CategoryRepository;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.repositories.TypeRepository;
import com.example.eCommerce.repositories.UserRepository;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import com.example.eCommerce.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private final AuthService authService;
    private UserRepository userRepository;
    private TypeRepository typeRepository;
    private CategoryRepository categoryRepository;

    @Override
    public void addProduct(ProductRequest productRequest, String token) {
        Product product = new Product();

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setCreated_date(LocalDateTime.now().toString());

        Optional<Type> type = typeRepository.findByName(productRequest.getType());
        if (type.isEmpty())
            throw new NotFoundException("no type with name: "+productRequest.getType(), HttpStatus.BAD_REQUEST);
        product.setType(type.get());

        Optional<Category> category = categoryRepository.findByName(productRequest.getCategory());
        if (category.isEmpty())
            throw new NotFoundException("no category with name: "+productRequest.getCategory(), HttpStatus.BAD_REQUEST);
        product.setCategory(category.get());

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
        Optional<Type> type = typeRepository.findByName(productRequest.getType());
        if (type.isEmpty())
            throw new NotFoundException("no type with name: "+productRequest.getType(), HttpStatus.BAD_REQUEST);
        product.get().setType(type.get());

        Optional<Category> category = categoryRepository.findByName(productRequest.getCategory());
        if (category.isEmpty())
            throw new NotFoundException("no category with name: "+productRequest.getCategory(), HttpStatus.BAD_REQUEST);
        product.get().setCategory(category.get());

        productRepository.save(product.get());
    }

    @Override
    public List<ProductResponse> getAll() {
            return productMapper.toDtoS(productRepository.findAll());
    }

    @Override
    public void update(String itemId, Integer quantity, org.springframework.security.core.userdetails.User user) {

    }

    @Override
    public Product findOne(String productId) {
        return null;
    }

    @Override
    public void buy(Long id, String token) {
        User user = authService.getUsernameFromToken(token);
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new NotFoundException("this book sold", HttpStatus.BAD_REQUEST);
        product.get().setExist(false);
        List<Product> products = new ArrayList<>();
        if (!user.getCustomer().getProducts().isEmpty())
            products = user.getCustomer().getProducts();
        products.add(product.get());
        user.getCustomer().setProducts(products);

        userRepository.save(user);
    }

    @Override
    public List<ProductResponse> compare(Long fId, Long sId) {
        Optional<Product> productF = productRepository.findById(fId);
        if(productF.isEmpty())
            throw new NotFoundException("the product with id: "+fId+" is empty!", HttpStatus.BAD_REQUEST);

        Optional<Product> productS = productRepository.findById(sId);
        if(productS.isEmpty())
            throw new NotFoundException("the product with id: "+sId+" is empty!", HttpStatus.BAD_REQUEST);

        List<ProductResponse> compareList=new ArrayList<>();
        compareList.add(productMapper.toDto(productF.get()));
        compareList.add(productMapper.toDto(productS.get()));

        return compareList;
    }
}

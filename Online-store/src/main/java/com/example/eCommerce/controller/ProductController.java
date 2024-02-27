package com.example.eCommerce.controller;

import com.example.eCommerce.dto.Product.ProductRequest;
import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductRequest productRequest, @RequestHeader("Authorization") String token){
        productService.addProduct(productRequest, token);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/find/{id}")
    public ProductResponse getById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping("/update")
    public void updateProduct(@PathVariable Long id,@RequestBody ProductRequest productRequest){
        productService.updateProduct(id,productRequest);
    }

    @GetMapping("/getAll")
    public List<ProductResponse> productResponses(){
        return productService.getAll();
    }

    @PostMapping("/buy/{productId}")
    public void buy(@PathVariable Long id, @RequestHeader("Authorization") String token){
        productService.buy(id,token);
    }

    @GetMapping("/compare/{id}/{id}")
    public List<ProductResponse> compare(@PathVariable Long fId, @PathVariable Long sId){
        return productService.compare(fId,sId);
    }
}

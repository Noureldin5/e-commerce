package com.example.eCommerce.service.comparison;

import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.comparison.ComparisonMapper;
import com.example.eCommerce.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComparisonServiceImpl implements ComparisonService{
    private ProductRepository productRepository;
    private ComparisonMapper comparisonMapper;

    @Override
    public List<ProductResponse> compare(Long fId, Long sId) {
        Optional<Product> productF = productRepository.findById(fId);
        if(productF.isEmpty())
            throw new NotFoundException("the product with id: "+fId+" is empty!", HttpStatus.BAD_REQUEST);

        Optional<Product> productS = productRepository.findById(sId);
        if(productS.isEmpty())
            throw new NotFoundException("the product with id: "+sId+" is empty!", HttpStatus.BAD_REQUEST);

        List<ProductResponse> compareList=new ArrayList<>();
        compareList.add(comparisonMapper.toDto(productF.get()));
        compareList.add(comparisonMapper.toDto(productS.get()));

        return compareList;
    }
}

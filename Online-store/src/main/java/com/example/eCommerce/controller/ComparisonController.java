package com.example.eCommerce.controller;

import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.service.comparison.ComparisonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/comparison")
public class ComparisonController {
    private ComparisonService comparisonService;

    @GetMapping("/compare/{id}/{id}")
    public List<ProductResponse> compare(@PathVariable Long fId, @PathVariable Long sId){
        return comparisonService.compare(fId,sId);
    }
}

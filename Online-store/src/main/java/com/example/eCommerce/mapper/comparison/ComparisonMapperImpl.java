package com.example.eCommerce.mapper.comparison;

import com.example.eCommerce.dto.Product.ProductResponse;
import com.example.eCommerce.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ComparisonMapperImpl implements ComparisonMapper{
    @Override
    public ProductResponse toDto(Product product) {
        ProductResponse productResponse=new ProductResponse();
        product.setSalesPackage(product.getSalesPackage());
        product.setModelNumber(product.getModelNumber());
        product.setSecondaryMaterial(product.getSecondaryMaterial());
        product.setConfiguration(product.getConfiguration());
        product.setUpholsteryMaterial(product.getUpholsteryMaterial());
        product.setUpholsteryColor(product.getUpholsteryColor());
        product.setFillingMaterial(product.getFillingMaterial());
        product.setFinishType(product.getFinishType());
        product.setAdjustableHeadrest(product.getAdjustableHeadrest());
        product.setMaximumLoadCapacity(product.getMaximumLoadCapacity());
        product.setOriginOfManufacture(product.getOriginOfManufacture());
        product.setWidth(product.getWidth());
        product.setHeight(product.getHeight());
        product.setWeight(product.getWeight());
        product.setSeatHeight(product.getSeatHeight());
        product.setLegHeight(product.getLegHeight());
        product.setWarrantyServiceType(product.getWarrantyServiceType());
        product.setWarrantySummary(product.getWarrantySummary());
        product.setCoveredInWarranty(product.getCoveredInWarranty());
        product.setNotCoveredInWarranty(product.getNotCoveredInWarranty());
        product.setDomesticWarranty(product.getDomesticWarranty());
        return productResponse;
    }
}

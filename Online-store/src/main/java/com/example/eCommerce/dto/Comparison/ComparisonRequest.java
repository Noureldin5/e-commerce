package com.example.eCommerce.dto.Comparison;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComparisonRequest {
    private String salesPackage;
    private String modelNumber;
    private String secondaryMaterial;
    private String configuration;
    private String upholsteryMaterial;
    private String upholsteryColor;
    private String fillingMaterial;
    private String finishType;
    private String adjustableHeadrest;
    private int maximumLoadCapacity;
    private String originOfManufacture;
    private double width;
    private double height;
    private double weight;
    private double seatHeight;
    private double legHeight;
    private String warrantySummary;
    private String warrantyServiceType;
    private String coveredInWarranty;
    private String notCoveredInWarranty;
    private String domesticWarranty;
}

package com.example.eCommerce.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponse {
    private Long id;
    private String comment;
    private Integer rating;
}

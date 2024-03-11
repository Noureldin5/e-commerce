package com.example.eCommerce.dto.Review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {
    private Long id;
    private String comment;
    private Integer rating;
}

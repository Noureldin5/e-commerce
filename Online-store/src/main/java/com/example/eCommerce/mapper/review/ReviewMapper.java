package com.example.eCommerce.mapper;

import com.example.eCommerce.dto.review.ReviewResponse;
import com.example.eCommerce.entities.Review;

import java.util.List;

public interface ReviewMapper {
    ReviewResponse toDto(Review review);

    List<ReviewResponse> toDtos(List<Review> reviews);
}

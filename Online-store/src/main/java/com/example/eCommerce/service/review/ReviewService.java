package com.example.eCommerce.service.review;

import com.example.eCommerce.dto.Review.ReviewRequest;
import com.example.eCommerce.entities.Review;
import com.example.eCommerce.repositories.ReviewRepository;

import java.util.List;

public interface ReviewService {



    List<Review> getReviewsByProductId(Long productId);

    void update(Long reviewId, com.example.eCommerce.dto.Review.ReviewRequest reviewRequest, String token);

    com.example.eCommerce.dto.review.ReviewResponse getReview(Long reviewId);

    List<com.example.eCommerce.dto.review.ReviewResponse> getProductReviews(Long productId);

    void deleteReview(Long reviewId, String token);


    void addReview(Long productId, com.example.eCommerce.dto.Review.ReviewRequest reviewRequest, String token);
}


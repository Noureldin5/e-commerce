package com.example.eCommerce.service.review;

import com.example.eCommerce.entities.Review;
import com.example.eCommerce.repositories.ReviewRepository;

import java.util.List;

public interface ReviewService {

    Review createReview(Review review);

    List<Review> getReviewsByProductId(Long productId);
}


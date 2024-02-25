package com.example.eCommerce.service.review.Impl;

import com.example.eCommerce.entities.Review;
import com.example.eCommerce.repositories.ReviewRepository;
import com.example.eCommerce.service.review.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(Review review) {
        // Validate if required fields are present
        if (review.getProductId() == null || review.getUserId() == null || review.getRating() <= 0) {
            throw new IllegalArgumentException("Invalid review data. Product ID, User ID, and Rating are required.");
        }

        // Perform additional validation if needed

        // Set created_at timestamp
        review.setCreatedAt(LocalDateTime.now());

        // Save the review
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByProductId(Long productId) {
        // Retrieve reviews by product ID
        return reviewRepository.findByProductId(productId);
    }
}

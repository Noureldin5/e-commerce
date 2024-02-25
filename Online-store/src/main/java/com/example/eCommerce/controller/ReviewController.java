package com.example.eCommerce.controller;

import com.example.eCommerce.entities.Review;
import com.example.eCommerce.service.review.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;


    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @GetMapping("/product/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }
}

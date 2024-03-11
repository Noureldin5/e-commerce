package com.example.eCommerce.controller;

import com.example.eCommerce.entities.Review;
import com.example.eCommerce.service.review.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;


    @PostMapping("/add/{productId}")
    public String addReview(@PathVariable Long productId, @RequestBody com.example.eCommerce.dto.Review.ReviewRequest reviewRequest , @RequestHeader("Authorization-Bearer") String token){
        reviewService.addReview(productId,reviewRequest  , token );
        return "Review was added successfully!";
    }

    @GetMapping("/product/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }
    @PutMapping("/update/{reviewId}")
    public String updateReview(@PathVariable Long reviewId, @RequestBody com.example.eCommerce.dto.Review.ReviewRequest reviewRequest ,
                               @RequestHeader("Authorization-Bearer") String token ){
        reviewService.update(reviewId, reviewRequest, token );
        return "Review was updated successfully!";
    }
    @GetMapping("/getAll/{productId}")
    public List<com.example.eCommerce.dto.review.ReviewResponse> getAllReviews(@PathVariable Long productId ){
        return reviewService.getProductReviews(productId);
    }

    @DeleteMapping("/delete/{reviewId}")

    public String deleteReview(@PathVariable Long reviewId, @RequestHeader("Authorization-Bearer") String token){
        reviewService.deleteReview(reviewId, token );
        return "Review was deleted successfully!";

    }
}

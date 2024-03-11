package com.example.eCommerce.mapper.review;

import com.example.eCommerce.dto.review.ReviewResponse;
import com.example.eCommerce.entities.Review;
import com.example.eCommerce.mapper.ReviewMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewMapperImpl implements ReviewMapper {
    @Override
    public ReviewResponse toDto(Review review) {
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setId(review.getReviewId());
        reviewResponse.setComment(review.getComment());
        reviewResponse.setRating(review.getRating());
        return reviewResponse;
    }

    @Override
    public List<ReviewResponse> toDtos(List<Review> reviews) {
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for(Review review : reviews){
            reviewResponses.add(toDto(review));
        }
        return reviewResponses;
    }
}

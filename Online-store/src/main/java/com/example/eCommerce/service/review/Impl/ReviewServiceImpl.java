package com.example.eCommerce.service.review.Impl;

import com.example.eCommerce.dto.Review.ReviewRequest;
import com.example.eCommerce.dto.Review.ReviewRequest;
import com.example.eCommerce.dto.review.ReviewResponse;
import com.example.eCommerce.entities.Product;
import com.example.eCommerce.entities.Review;
import com.example.eCommerce.entities.User;
import com.example.eCommerce.exception.BlockedException;
import com.example.eCommerce.exception.NotFoundException;
import com.example.eCommerce.mapper.ReviewMapper;
import com.example.eCommerce.repositories.ProductRepository;
import com.example.eCommerce.repositories.ReviewRepository;
import com.example.eCommerce.service.auth.AuthService;
import com.example.eCommerce.service.review.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final AuthService authService;
    private final ReviewMapper reviewMapper;
    @Override
    public void addReview(Long productId, ReviewRequest reviewRequest, String token) {
        Optional<Product> productOp = productRepository.findById(productId);
        if(productOp.isEmpty())
            throw new NotFoundException("This product doesn't exist!", HttpStatus.NOT_FOUND);
        Product product = productOp.get();
        User user = authService.getUsernameFromToken(token);

        Review review = new Review();
        review.setComment(reviewRequest.getComment());
        review.setRating(reviewRequest.getRating());
        review.setProduct(product);
        review.setUser(user);
        reviewRepository.save(review);

    }

    @Override
    public List<Review> getReviewsByProductId(Long productId) {
        return null;
    }



    @Override
    public void update(Long reviewId, ReviewRequest reviewRequest, String token) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if(review.isEmpty())
            throw new NotFoundException("review with this id doesn't exist :"+reviewId+"!", HttpStatus.BAD_REQUEST);

        User user = authService.getUsernameFromToken(token);
        Long userIdFromToken = user.getId();

        Long userIdFromReview = review.get().getUser().getId();

        if(!userIdFromToken.equals(userIdFromReview))
            throw new BlockedException("It's not your review");
        review.get().setRating(reviewRequest.getRating());
        review.get().setComment(reviewRequest.getComment());
        reviewRepository.save(review.get());
    }

    @Override
    public ReviewResponse getReview(Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if(review.isEmpty())
            throw new NotFoundException("review with this id doesn't exist:"+reviewId+"!", HttpStatus.BAD_REQUEST);
        return reviewMapper.toDto(review.get());
    }

    @Override
    public List<ReviewResponse> getProductReviews(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty())
            throw new NotFoundException("This product doesn't exist!", HttpStatus.NOT_FOUND);
        return reviewMapper.toDtos(product.get().getReviews());
    }

    @Override
    public void deleteReview(Long reviewId, String token) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if(review.isEmpty())
            throw new NotFoundException("review with this id doesn't exist :"+reviewId+"!", HttpStatus.BAD_REQUEST);
        User user = authService.getUsernameFromToken(token);
        Long userIdFromToken = user.getId();

        Long userIdFromReview = review.get().getUser().getId();

        if(!userIdFromToken.equals(userIdFromReview))
            throw new BlockedException("It's not your review");
        reviewRepository.deleteById(reviewId);

    }
}
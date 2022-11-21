package com.acme.urproviderwebservices.sales.service;

import com.acme.urproviderwebservices.sales.domain.model.entity.Review;
import com.acme.urproviderwebservices.sales.domain.persistence.ReviewRepository;
import com.acme.urproviderwebservices.sales.domain.service.ReviewService;
import com.acme.urproviderwebservices.shared.exception.ResourceNotFoundException;
import com.acme.urproviderwebservices.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final String ENTITY = "Review";

    private final ReviewRepository reviewRepository;

    private final Validator validator;

    public ReviewServiceImpl(ReviewRepository reviewRepository, Validator validator) {
        this.reviewRepository = reviewRepository;
        this.validator = validator;
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Page<Review> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Review getById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, reviewId));
    }

    @Override
    public Review create(Review review) {
        Set<ConstraintViolation<Review>> violations = validator.validate(review);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return reviewRepository.save(review);
    }

    @Override
    public Review update(Long reviewId, Review request) {
        Set<ConstraintViolation<Review>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return reviewRepository.findById(reviewId).map(review ->
                        reviewRepository.save(
                                review.withTitle(request.getTitle())
                                        .withDescription(request.getDescription())))

                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, reviewId));
    }

    @Override
    public ResponseEntity<?> delete(Long reviewId) {
        return reviewRepository.findById(reviewId).map(review -> {
            reviewRepository.delete(review);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY, reviewId));
    }
}

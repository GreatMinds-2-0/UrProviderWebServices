package com.acme.urproviderwebservices.sales.domain.service;

import com.acme.urproviderwebservices.sales.domain.model.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {

    List<Review> getAll();
    Page<Review> getAll(Pageable pageable);

    Review getById(Long reviewId);

    Review create(Review review);

    Review update(Long reviewId, Review request);

    ResponseEntity<?> delete(Long reviewId);


}

package com.acme.urproviderwebservices.sales.api;

import com.acme.urproviderwebservices.sales.domain.service.ReviewService;
import com.acme.urproviderwebservices.sales.mapping.ReviewMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/reviews", produces = "application/json")
public class ReviewsController {

    private final ReviewService reviewService;

    private final ReviewMapper mapper;


    public ReviewsController(ReviewService reviewService, ReviewMapper mapper) {
        this.reviewService = reviewService;
        this.mapper = mapper;
    }

}

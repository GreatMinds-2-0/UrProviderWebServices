package com.acme.urproviderwebservices.sales.domain.persistence;

import com.acme.urproviderwebservices.sales.domain.model.entity.Review;
import com.acme.urproviderwebservices.sales.domain.model.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByStoreId(Long storeId);

    Review findReviewById(Long reviewId);

}

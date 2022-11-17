package com.acme.urproviderwebservices.inventory.domain.service;

import com.acme.urproviderwebservices.inventory.domain.model.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long productId);
    Product getByNameAndSupplierId(Product name,Long id);

    ResponseEntity<?> delete(Long supplierId, Long productId);
}

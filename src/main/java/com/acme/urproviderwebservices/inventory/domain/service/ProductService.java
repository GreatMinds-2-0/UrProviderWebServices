package com.acme.urproviderwebservices.inventory.domain.service;

import com.acme.urproviderwebservices.inventory.domain.model.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductsBySupplierId(Long supplierId);

    Product getByNameAndSupplierId(String name, Long supplierId);

    ResponseEntity<?> delete(Long supplierId, Long productId);
}
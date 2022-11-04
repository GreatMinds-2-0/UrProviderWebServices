package com.acme.urproviderwebservices.users.store.domain.service;

import com.acme.urproviderwebservices.users.store.domain.model.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface  StoreService {
    List<Store> getAll();
    Page<Store> getAll(Pageable pageable);
    Store getById(Long storeId);
    Store create(Store store);
    Store update(Long storeId, Store request);
    ResponseEntity<?> delete(Long storeId);
}

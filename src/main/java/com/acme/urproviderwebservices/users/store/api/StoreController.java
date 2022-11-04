package com.acme.urproviderwebservices.users.store.api;

import com.acme.urproviderwebservices.users.store.domain.service.StoreService;
import com.acme.urproviderwebservices.users.store.mapping.StoreMapper;
import com.acme.urproviderwebservices.users.store.resource.CreateStoreResource;
import com.acme.urproviderwebservices.users.store.resource.StoreResource;
import com.acme.urproviderwebservices.users.store.resource.UpdateStoreResource;
import com.acme.urproviderwebservices.users.supplier.resource.CreateSupplierResource;
import com.acme.urproviderwebservices.users.supplier.resource.SupplierResource;
import com.acme.urproviderwebservices.users.supplier.resource.UpdateSupplierResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/store", produces = "application/json")
public class StoreController {

    private final StoreService storeService;
    private final StoreMapper mapper;
    public StoreController(StoreService storeService, StoreMapper mapper){
        this.storeService = storeService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<StoreResource> getAllStore(Pageable pageable){
        return mapper.modelListPage(storeService.getAll(), pageable);
    }
    @GetMapping("{storeId}")
    public StoreResource getStoreById(@PathVariable Long storeId){
        return mapper.toResource(storeService.getById(storeId));

    }
    @PostMapping
    public ResponseEntity<StoreResource> createStore(@Valid @RequestBody CreateStoreResource resource){
        return new ResponseEntity<>(mapper.toResource(storeService.create(mapper.toModel(resource)))),HttpStatus.CREATED;
    }
    @PutMapping("{storeId}")
    public StoreResource updateStore(@PathVariable Long storeId,
                                     @RequestBody UpdateStoreResource resource){
        return mapper.toResource(storeService.update(storeId,mapper.toModel(resource)))
    }
    @DeleteMapping("{storeId}")
    public ResponseEntity<?> deleteStore(@PathVariable Long storeId){
        return storeService.delete(storeId);
    }
}

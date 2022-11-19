package com.acme.urproviderwebservices.users.store.api;

import com.acme.urproviderwebservices.users.store.domain.service.StoreService;
import com.acme.urproviderwebservices.users.store.mapping.StoreMapper;
import com.acme.urproviderwebservices.users.store.resource.CreateStoreResource;
import com.acme.urproviderwebservices.users.store.resource.StoreResource;
import com.acme.urproviderwebservices.users.store.resource.UpdateStoreResource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/stores", produces = "application/json")
public class StoresController {

    private final StoreService storeService;
    private final StoreMapper mapper;
    public StoresController(StoreService storeService, StoreMapper mapper){
        this.storeService = storeService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<StoreResource> getAllStore(){
        return mapper.modelListPage(storeService.getAll());
    }
    @GetMapping("{storeId}")
    public StoreResource getStoreById(@PathVariable Long storeId){
        return mapper.toResource(storeService.getById(storeId));

    }
    @PostMapping
    public ResponseEntity<StoreResource> createStore(@Valid @RequestBody CreateStoreResource resource){
        return new ResponseEntity<>(mapper.toResource(storeService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @PutMapping("{storeId}")
    public StoreResource updateStore(@PathVariable Long storeId,
                                     @RequestBody UpdateStoreResource resource) {
        return mapper.toResource(storeService.update(storeId, mapper.toModel(resource)));
    }
    @DeleteMapping("{storeId}")
    public ResponseEntity<?> deleteStore(@PathVariable Long storeId) {
        return storeService.delete(storeId);
    }
}
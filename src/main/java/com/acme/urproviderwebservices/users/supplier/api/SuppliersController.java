package com.acme.urproviderwebservices.users.supplier.api;

import com.acme.urproviderwebservices.users.supplier.domain.service.SupplierService;
import com.acme.urproviderwebservices.users.supplier.mapping.SupplierMapper;
import com.acme.urproviderwebservices.users.supplier.resource.CreateSupplierResource;
import com.acme.urproviderwebservices.users.supplier.resource.SupplierResource;
import com.acme.urproviderwebservices.users.supplier.resource.UpdateSupplierResource;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/suppliers", produces = "application/json")
public class SuppliersController {
    private final SupplierService supplierService;
    private final SupplierMapper mapper;

    public SuppliersController( SupplierService supplierService, SupplierMapper mapper) {
        this.supplierService = supplierService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<SupplierResource> getAllMusicians(Pageable pageable){
        return mapper.modelListPage(supplierService.getAll(), pageable);
    }
    @GetMapping("{supplierId}")
    public SupplierResource getSupplierById(@PathVariable Long supplierId) {
        return mapper.toResource(supplierService.getById(supplierId));
    }

    @PostMapping
    public ResponseEntity<SupplierResource> createSupplier(@Valid @RequestBody CreateSupplierResource resource) {
        return new ResponseEntity<>(mapper.toResource(supplierService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @PutMapping("{supplierId}")
    public SupplierResource updateSupplier(@PathVariable Long supplierId,
                                         @RequestBody UpdateSupplierResource resource) {
        return mapper.toResource(supplierService.update(supplierId, mapper.toModel(resource)));
    }

    @DeleteMapping("{supplierId}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long supplierId) {
        return supplierService.delete(supplierId);
    }
}

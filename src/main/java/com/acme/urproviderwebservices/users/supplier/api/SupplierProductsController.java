package com.acme.urproviderwebservices.users.supplier.api;

import com.acme.urproviderwebservices.inventory.domain.service.ProductService;
import com.acme.urproviderwebservices.inventory.mapping.ProductMapper;
import com.acme.urproviderwebservices.inventory.resource.CreateProductResource;
import com.acme.urproviderwebservices.inventory.resource.ProductResource;
import com.acme.urproviderwebservices.users.supplier.domain.service.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/suppliers/{supplierId}/products", produces = "application/json")
public class SupplierProductsController {

    private final SupplierService supplierService;

    private final ProductService productService;

    private final ProductMapper mapper;

    public SupplierProductsController(SupplierService supplierService, ProductService productService, ProductMapper mapper) {
        this.supplierService = supplierService;
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ProductResource> getAllProductsBySupplierId(@PathVariable Long supplierId,
                                                         Pageable pageable) {
        return mapper.modelListPage(supplierService.getById(supplierId)
                .getProducts().stream().toList(), pageable);
    }

    @PostMapping
    public ProductResource createProduct(@PathVariable Long supplierId,
                                         @RequestBody CreateProductResource resource) {

        supplierService.addProductToSupplier(supplierId, resource.getName());
        return mapper.toResource(productService
                .getByNameAndSupplierId(resource.getName(), supplierId));
    }
}

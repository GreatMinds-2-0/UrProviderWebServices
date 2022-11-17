package com.acme.urproviderwebservices.inventory.api;

import com.acme.urproviderwebservices.inventory.domain.service.ProductService;
import com.acme.urproviderwebservices.inventory.mapping.ProductMapper;
import com.acme.urproviderwebservices.inventory.resource.CreateProductResource;
import com.acme.urproviderwebservices.inventory.resource.ProductResource;
import com.acme.urproviderwebservices.inventory.resource.UpdateProductResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/products", produces = "application/json")
public class ProductsController {

    private final ProductService productService;

    private final ProductMapper mapper;

    public ProductsController(ProductService productService, ProductMapper mapper){
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ProductResource> getAllProducts(Pageable pageable){
        return mapper.modelListPage(productService.getAll(), pageable);
    }

    @GetMapping("{productId}")
    public ProductResource getProductById(@PathVariable Long productId) {
        return mapper.toResource(productService.getById(productId));
    }

    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource resource) {
        return new ResponseEntity<>(mapper.toResource(productService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{productId}")
    public ProductResource updateProduct(@PathVariable Long productId,
                                         @RequestBody UpdateProductResource resource) {
        return mapper.toResource(productService.update(productId, mapper.toModel(resource)));
    }

    @GetMapping("{productId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long productId) {
        return productService.delete(productId);
    }
}

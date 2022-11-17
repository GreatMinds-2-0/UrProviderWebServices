package com.acme.urproviderwebservices.inventory.api;

import com.acme.urproviderwebservices.inventory.domain.service.ProductService;
import com.acme.urproviderwebservices.inventory.mapping.ProductMapper;
import com.acme.urproviderwebservices.inventory.resource.ProductResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<ProductResource> getAllProducts(){
        return mapper.modelListPage(productService.getAll());
    }
    @GetMapping("{id}")
    public ProductResource getProductById(@PathVariable Long id) {
        return mapper.toResource(productService.getById(id));
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

package com.acme.urproviderwebservices.inventory.api;

import com.acme.urproviderwebservices.inventory.domain.service.ProductService;
import com.acme.urproviderwebservices.inventory.mapping.ProductMapper;
import com.acme.urproviderwebservices.inventory.resource.ProductResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
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
    @GetMapping("{productId}")
    public ProductResource getProductById(@PathVariable Long productId) {
        return mapper.toResource(productService.getById(productId));
    }
}

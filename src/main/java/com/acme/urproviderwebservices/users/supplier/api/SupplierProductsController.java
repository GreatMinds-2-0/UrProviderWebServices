package com.acme.urproviderwebservices.users.supplier.api;

import com.acme.urproviderwebservices.inventory.domain.service.ProductService;
import com.acme.urproviderwebservices.users.supplier.domain.service.SupplierService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/suppliers/{supplierId}/products", produces = "application/json")
public class SupplierProductsController {

    private final SupplierService supplierService;

    private final ProductService productService;

    public SupplierProductsController(SupplierService supplierService, ProductService productService) {
        this.supplierService = supplierService;
        this.productService = productService;
    }
}

package com.acme.urproviderwebservices.users.supplier.mapping;

import com.acme.urproviderwebservices.shared.mapping.EnhancedModelMapper;
import com.acme.urproviderwebservices.users.supplier.domain.model.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class SupplierMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    //public SupplierResource
    //public Supplier toModel(CreateSupplierResource resource){  }
}

package com.acme.urproviderwebservices.users.supplier.mapping;

import com.acme.urproviderwebservices.shared.mapping.EnhancedModelMapper;
import com.acme.urproviderwebservices.users.supplier.domain.model.entity.Supplier;
import com.acme.urproviderwebservices.users.supplier.resource.CreateSupplierResource;
import com.acme.urproviderwebservices.users.supplier.resource.SupplierResource;

import com.acme.urproviderwebservices.users.supplier.resource.UpdateSupplierResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class SupplierMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public SupplierResource toResource(Supplier model) {
        return mapper.map(model, SupplierResource.class);
    }
    public Page<SupplierResource> modelListPage(List<Supplier> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SupplierResource.class), pageable, modelList.size());
    }

    public Supplier toModel(CreateSupplierResource resource) {
        return mapper.map(resource, Supplier.class);
    }

    public Supplier toModel(UpdateSupplierResource resource) {
        return mapper.map(resource, Supplier.class);
    }
}

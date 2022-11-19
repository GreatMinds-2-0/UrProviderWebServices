package com.acme.urproviderwebservices.users.store.mapping;

import com.acme.urproviderwebservices.shared.mapping.EnhancedModelMapper;
import com.acme.urproviderwebservices.users.store.domain.model.entity.Store;
import com.acme.urproviderwebservices.users.store.resource.CreateStoreResource;
import com.acme.urproviderwebservices.users.store.resource.StoreResource;
import com.acme.urproviderwebservices.users.store.resource.UpdateStoreResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.function.Supplier;

public class StoreMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public StoreResource toResource(Store model) {
        return mapper.map(model, StoreResource.class);
    }
    public List<StoreResource> modelListPage(List<Store> modelList) {
        return mapper.mapList(modelList, StoreResource.class);
    }

    public Store toModel(CreateStoreResource resource) {
        return mapper.map(resource, Store.class);
    }

    public Store toModel(UpdateStoreResource resource) {
        return mapper.map(resource, Store.class);
    }
}

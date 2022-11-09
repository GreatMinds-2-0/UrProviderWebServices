package com.acme.urproviderwebservices.sales.mapping;

import com.acme.urproviderwebservices.sales.domain.model.entity.SalesOrder;
import com.acme.urproviderwebservices.sales.resource.SalesOrderResource;
import com.acme.urproviderwebservices.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class SalesOrderMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public SalesOrderResource toResource(SalesOrder model) {
        return mapper.map(model, SalesOrderResource.class);
    }

    public Page<SalesOrderResource> modelListPage(List<SalesOrder> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, SalesOrderResource.class), pageable, modelList.size());
    }
}

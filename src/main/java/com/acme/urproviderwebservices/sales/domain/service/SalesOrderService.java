package com.acme.urproviderwebservices.sales.domain.service;

import com.acme.urproviderwebservices.sales.domain.model.entity.SalesOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SalesOrderService {
    List<SalesOrder> getAll();
    Page<SalesOrder> getAll(Pageable pageable);
    SalesOrder getById(Long salesOrderId);
}

package com.acme.urproviderwebservices.sales.domain.persistence;

import com.acme.urproviderwebservices.sales.domain.model.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
    List<SalesOrder> findAllByStatus(boolean status);
    SalesOrder findSalesOrderById(Long salesOrderId);
}
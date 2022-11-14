package com.acme.urproviderwebservices.users.supplier.domain.persistence;

import com.acme.urproviderwebservices.users.supplier.domain.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Supplier findByEmail(String email);

}

package com.acme.urproviderwebservices.users.supplier.service;

import com.acme.urproviderwebservices.shared.exception.ResourceNotFoundException;
import com.acme.urproviderwebservices.shared.exception.ResourceValidationException;
import com.acme.urproviderwebservices.users.supplier.domain.model.entity.Supplier;
import com.acme.urproviderwebservices.users.supplier.domain.persistence.SupplierRepository;
import com.acme.urproviderwebservices.users.supplier.domain.service.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
@Service
public class SupplierServiceImpl implements SupplierService {
    private static final String ENTITY = "Supplier";
    private final SupplierRepository supplierRepository;
    private final Validator validator;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Validator validator ) {
        this.supplierRepository = supplierRepository;
        this.validator = validator;
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Page<Supplier> getAll(Pageable pageable) {
        return supplierRepository.findAll(pageable);
    }

    @Override
    public Supplier getById(Long supplierId) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, supplierId));
    }

    @Override
    public Supplier create(Supplier supplier) {
        Set<ConstraintViolation<Supplier>> violations = validator.validate(supplier);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Email Uniqueness validation
        Supplier supplierWithEmail = supplierRepository.findByEmail(supplier.getEmail());
        if (supplierWithEmail != null)
            throw new ResourceValidationException(ENTITY,
                    "A supplier with the same email already exist.");

        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Long supplierId, Supplier request) {
        Set<ConstraintViolation<Supplier>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation
        Supplier supplierWithEmail = supplierRepository.findByEmail(request.getEmail());

        if(supplierWithEmail != null && !supplierWithEmail.getId().equals(supplierId))
            throw new ResourceValidationException(ENTITY,
                    "A supplier with the same email already exists.");

        return supplierRepository.findById(supplierId).map(existingSupplier ->
                        supplierRepository.save(
                                existingSupplier.withSupplierName(request.getName())
                                        .withName(request.getEmail())
                                        .withLastName(request.getLastName())
                                        .withImage(request.getImage())
                                        .withEmail(request.getEmail())
                                        .withAddress(request.getAddress())
                                        .withRuc(request.getRuc())
                                        .withCategory(request.getCategory())
                                        .withDescription(request.getDescription())
                                        .withPhone(request.getPhone())
                                        .withPassword(request.getPassword())
                                        ))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, supplierId));
    }

    @Override
    public ResponseEntity<?> delete(Long supplierId) {

        return supplierRepository.findById(supplierId).map(supplier -> {
            supplierRepository.delete(supplier);
            return ResponseEntity.ok().build(); })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, supplierId));

    }

    @Override
    public Supplier addProductToSupplier(Long supplierId, String productName) {
        return supplierRepository.findById(supplierId).map(supplier -> {
            return supplierRepository.save(supplier.addProduct(productName));
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, supplierId));
    }
}

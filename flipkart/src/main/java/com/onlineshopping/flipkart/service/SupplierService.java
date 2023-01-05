package com.onlineshopping.flipkart.service;

import com.onlineshopping.flipkart.entity.Suppliers;
import com.onlineshopping.flipkart.exceptions.ShipperNotFoundException;
import com.onlineshopping.flipkart.exceptions.SupplierAlreadyExistsException;
import com.onlineshopping.flipkart.exceptions.SupplierNotFoundException;
import com.onlineshopping.flipkart.repository.SupplierRepository;
import com.onlineshopping.flipkart.vo.Supplier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;
    public ResponseEntity<List<Suppliers>> getSuppliers() {
        return new ResponseEntity<>(supplierRepository.findAll(), HttpStatus.OK);
    }
    @Transactional(rollbackFor = {SupplierNotFoundException.class})
    public void saveSuppliers(List<Supplier> suppliers) throws SupplierNotFoundException {

        for (Supplier supplier : suppliers) {
            if (supplierRepository.findById(supplier.getSupplierID()).isPresent()) {
                throw new SupplierAlreadyExistsException(supplier.getSupplierID());
            }
            supplierRepository.save(getEntity(supplier));
        }
    }
    // add transactionmanager
    public com.onlineshopping.flipkart.entity.Suppliers getSupplierBySuppid(Integer suppid) throws SupplierNotFoundException{
        return supplierRepository.findById(suppid).orElseThrow(() -> new SupplierNotFoundException(suppid));
    }

    public void updateSuppliers(List<com.onlineshopping.flipkart.vo.Supplier> suppliers) throws SupplierNotFoundException {
        for (Supplier su : suppliers) {
            if (supplierRepository.findById(su.getSupplierID()).isEmpty()) {
                throw new ShipperNotFoundException(su.getSupplierID());
            }
            supplierRepository.save(getEntity(su));
        }
    }

    public Suppliers getEntity(Supplier suppliers) throws SupplierNotFoundException {
        return Suppliers.builder()
                .supplierName(suppliers.getSupplierName())
                .supplierID(suppliers.getSupplierID())
                .postalCode(suppliers.getPostalCode())
                .city(suppliers.getCity())
                .address(suppliers.getAddress()).build();
    }
    public void  deleteSupplierById(Integer suppid) {
        supplierRepository.delete(supplierRepository.findById(suppid).orElseThrow(() -> new SupplierNotFoundException(suppid)));

    }
}
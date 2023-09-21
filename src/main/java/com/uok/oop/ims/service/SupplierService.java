package com.uok.oop.ims.service;

import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.model.Supplier;
import com.uok.oop.ims.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public void addSupplier(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(String id) {
        Optional<Supplier> optional = supplierRepository.findById(id);
        Supplier supplier = null;
        if (optional.isPresent()) {
            supplier = optional.get();
        } else {
            throw new RuntimeException("Item not found by id:: " + id);
        }
        return supplier;
    }

    public void deleteSupplierById(String id) {
        this.supplierRepository.deleteById(id);
    }

    public long getTotalSuppliers() {
        return supplierRepository.count();
    }

}

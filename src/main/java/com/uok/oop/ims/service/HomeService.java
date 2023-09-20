package com.uok.oop.ims.service;

import com.uok.oop.ims.repository.ClientRepository;
import com.uok.oop.ims.repository.ItemRepository;
import com.uok.oop.ims.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    ClientRepository clientRepository;

    public long getTotalItems() {
        return itemRepository.count();
    }

    public long getTotalSuppliers() {
        return supplierRepository.count();
    }

    public long getTotalCustomers() {
        return clientRepository.count();
    }
}

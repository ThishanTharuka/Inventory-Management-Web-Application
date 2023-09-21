package com.uok.oop.ims.service;

import com.uok.oop.ims.model.Client;
import com.uok.oop.ims.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(String id) {
        Optional<Client> optional = clientRepository.findById(id);
        Client client = null;
        if (optional.isPresent()) {
            client = optional.get();
        } else {
            throw new RuntimeException("Item not found by id:: " + id);
        }
        return client;
    }

    public void deleteClientById(String id) {
        this.clientRepository.deleteById(id);
    }

    public long getTotalCustomers() {
        return clientRepository.count();
    }

}

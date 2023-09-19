package com.uok.oop.ims.service;

import com.uok.oop.ims.model.Client;
import com.uok.oop.ims.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {
    @Autowired
    ClientRepository clientrepository;

    public void addClient(Client client) {
        clientrepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientrepository.findAll();
    }

    public Client getClientById(String id) {
        Optional<Client> optional = clientrepository.findById(id);
        Client client = null;
        if (optional.isPresent()) {
            client = optional.get();
        } else {
            throw new RuntimeException("Item not found by id:: " + id);
        }
        return client;
    }

    public void deleteClientById(String id) {
        this.clientrepository.deleteById(id);
    }

}

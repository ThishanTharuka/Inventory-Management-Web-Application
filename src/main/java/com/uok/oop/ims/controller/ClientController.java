package com.uok.oop.ims.controller;

import com.uok.oop.ims.dto.ClientDto;
import com.uok.oop.ims.model.Client;
import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class ClientController {
    @Autowired
    ClientService clientservice;

    //Save Client
    @GetMapping("/add-client")
    public String addClientForm(Model model) {
        model.addAttribute("client", new ClientDto());
        model.addAttribute("success", true);
        return "add-client";
    }

    @RequestMapping("/submit-client")
    public String submitAddClient(@ModelAttribute ClientDto client) {
        Client newclient = new Client(client.getClient_id(), client.getClient_NIC(), client.getClient_name(), client.getClient_address(), client.getClient_contact(), client.getClient_email());
        clientservice.addClient(newclient);
        return "redirect:/client-list";
    }

    //Get All Clients
    @GetMapping("/client-list")
    public String getClients(Model model) {
        List<Client> clientList = clientservice.getAllClients();
        model.addAttribute("clientList", clientList);
        return "client-list";
    }

    //Update Client
    @GetMapping("/update-client/{id}")
    public String showClientForUpdate(@PathVariable(value = "id") String id, Model model){
        Client client = clientservice.getClientById(id);
        model.addAttribute("client", client);
        return "/add-client";
    }

    //Delete Client
    @GetMapping("/delete-client/{id}")
    public String deleteClient(@PathVariable(value = "id") String id) {
        clientservice.deleteClientById(id);
        return "redirect:/client-list";
    }


}

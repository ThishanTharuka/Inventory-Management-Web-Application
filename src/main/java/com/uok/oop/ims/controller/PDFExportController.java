package com.uok.oop.ims.controller;

import com.uok.oop.ims.model.Client;
import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.model.Supplier;
import com.uok.oop.ims.repository.ClientRepository;
import com.uok.oop.ims.repository.ItemRepository;
import com.uok.oop.ims.repository.SupplierRepository;
import com.uok.oop.ims.service.DatabasePDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class PDFExportController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    DatabasePDFService databasePDFService;

    @GetMapping(value = "/report/item-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> itemReport()  throws IOException {
        List<Item> items = (List<Item>) itemRepository.findAll();
        List<Client> clients = (List<Client>) clientRepository.findAll();


        ByteArrayInputStream itemPDFReport = DatabasePDFService.itemPDFReport(items);
        ByteArrayInputStream clientPDFReport = DatabasePDFService.clientPDFReport(clients);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = items.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(itemPDFReport));
    }

    @GetMapping(value = "/report/customer-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> customerReport()  throws IOException {
        List<Client> clients = (List<Client>) clientRepository.findAll();


        ByteArrayInputStream clientPDFReport = DatabasePDFService.clientPDFReport(clients);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = customer.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(clientPDFReport));
    }

    @GetMapping(value = "/report/supplier-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> supplierReport()  throws IOException {
        List<Supplier> suppliers = (List<Supplier>) supplierRepository.findAll();


        ByteArrayInputStream supplierPDFReport = DatabasePDFService.supplierPDFReport(suppliers);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = suppliers.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(supplierPDFReport));
    }

}

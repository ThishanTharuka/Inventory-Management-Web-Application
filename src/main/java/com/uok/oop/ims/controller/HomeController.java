package com.uok.oop.ims.controller;

import com.uok.oop.ims.service.ClientService;
import com.uok.oop.ims.service.ItemService;
import com.uok.oop.ims.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String home(Model model) {
        long totalItems = itemService.getTotalItems();
        long totalSuppliers = supplierService.getTotalSuppliers();
        long totalCustomers = clientService.getTotalCustomers();
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalSuppliers", totalSuppliers);
        model.addAttribute("totalCustomers", totalCustomers);
        model.addAttribute("totalQuantity", itemService.getTotalQuantityOfAllItems());
        model.addAttribute("totalExpenditure", itemService.getTotalExpenditureForAllItems());
        model.addAttribute("totalProjectedIncome", itemService.getTotalProjectedIncomeForAllItems());
        return "home";
    }
}

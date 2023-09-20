package com.uok.oop.ims.controller;

import com.uok.oop.ims.service.HomeService;
import com.uok.oop.ims.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private HomeService homeService;
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String home(Model model) {
        long totalItems = homeService.getTotalItems();
        long totalSuppliers = homeService.getTotalSuppliers();
        long totalCustomers = homeService.getTotalCustomers();
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalSuppliers", totalSuppliers);
        model.addAttribute("totalCustomers", totalCustomers);
        model.addAttribute("totalQuantity", itemService.getTotalQuantityOfAllItems());
        model.addAttribute("totalExpenditure", itemService.getTotalExpenditureForAllItems());
        model.addAttribute("totalProjectedIncome", itemService.getTotalProjectedIncomeForAllItems());
        return "home";
    }
}

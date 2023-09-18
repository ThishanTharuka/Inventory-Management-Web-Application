package com.uok.oop.ims.controller;

import com.uok.oop.ims.dto.SupplierDto;
import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.model.Supplier;
import com.uok.oop.ims.repository.SupplierRepository;
import com.uok.oop.ims.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/add-supplier")
    public String addSuppliersForm(Model model){
        model.addAttribute("supplier", new SupplierDto());
        model.addAttribute("success", true);
        return "add-supplier";
    }

    @RequestMapping("/submit-supplier")
    public String submitSupplierForm(@ModelAttribute Supplier supplier){
        Supplier newSupplier = new Supplier(supplier.getSupplierId(), supplier.getSupplierName(), supplier.getSupplierNIC(), supplier.getSupplierContactNumber(), supplier.getEmail(), supplier.getAddress());
        supplierService.addSupplier(newSupplier);
        return "redirect:/supplier-list";
    }

    @GetMapping("/supplier-list")
    public String showSupplierList(Model model){
        model.addAttribute("supplierList", supplierService.getAllSuppliers());
        return "supplier-list";
    }

    @GetMapping("/showSupplierForUpdate/{id}")
    public String showSupplierForUpdate(@PathVariable(value = "id") String id, Model model){
        Supplier supplier = supplierService.getSupplierById(id);
        model.addAttribute("supplier", supplier);
        return "/add-supplier";
    }

    @GetMapping("/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable(value = "id") String id){
        supplierService.deleteSupplierById(id);
        return "redirect:/supplier-list";
    }

}

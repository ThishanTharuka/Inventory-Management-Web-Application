package com.uok.oop.ims.service;

import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.model.Supplier;
import com.uok.oop.ims.repository.ItemRepository;
import com.uok.oop.ims.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    SupplierRepository supplierRepository;

    public void addItems(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(String id) {
        Optional<Item> optional = itemRepository.findById(id);
        Item item = null;
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException("Item not found by id:: " + id);
        }
        return item;
    }

    public void addNewItems(Item item) {
        // Check if the supplier exists in the database
        String supplierId = item.getSupplier().getSupplierId(); // Assuming you have a getter for supplierId in Supplier class
        if (supplierRepository.existsById(supplierId)) {
            // Supplier exists, save the item
            itemRepository.save(item);
        } else {
            // Supplier does not exist, handle the error or throw an exception
            // You can throw a custom exception or handle the error as per your application's requirements.
            throw new RuntimeException("Supplier does not exist");
        }
    }

    public void deleteItemById(String id) {
        this.itemRepository.deleteById(id);
    }

    public long getTotalItems() {
        return itemRepository.count();
    }

    public int getTotalQuantityOfAllItems() {
        // Sum up the quantity of all items using a custom query
        Integer totalQuantity = itemRepository.sumTotalQuantity();

        // Handle null case if there are no items in the database
        return totalQuantity != null ? totalQuantity : 0;
    }

    public double getTotalExpenditureForAllItems() {
        List<Item> items = itemRepository.findAll();
        double totalExpenditure = 0.0;

        for (Item item : items) {
            double itemExpenditure = item.getBuyPrice() * item.getQuantity();
            totalExpenditure += itemExpenditure;
        }

        return totalExpenditure;
    }

    public double getTotalProjectedIncomeForAllItems() {
        List<Item> items = itemRepository.findAll();
        double totalProjectedIncome = 0.0;

        for (Item item : items) {
            double itemIncome = item.getSellPrice() * item.getQuantity();
            totalProjectedIncome += itemIncome;
        }

        return totalProjectedIncome;
    }
}

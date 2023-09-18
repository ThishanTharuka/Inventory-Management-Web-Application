package com.uok.oop.ims.service;

import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void addItems(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(String id) {
        Optional<Item> optional = itemRepository.findById(id);
        Item item = null;
        if(optional.isPresent()){
            item = optional.get();
        }else {
            throw new RuntimeException("Item not found by id:: " + id);
        }
        return item;
    }

    public void deleteItemById(String id) {
        this.itemRepository.deleteById(id);
    }

}

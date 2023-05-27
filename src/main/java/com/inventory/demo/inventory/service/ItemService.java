package com.inventory.demo.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.demo.inventory.entity.Item;
import com.inventory.demo.inventory.exception.RecordNotFoungException;
import com.inventory.demo.inventory.repository.ItemRepository;

@Service
public class ItemService implements ItemServiceImp{


    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item saveItem(Item item) {
       return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
       return itemRepository.findAll();
    }

    @Override
    public Item getItemById(long id) throws RecordNotFoungException {
        Optional<Item> item =  itemRepository.findById(id);
        if (item.isPresent()) {
           return item.get();

        } else {
            throw new RecordNotFoungException("not fount");
        }
        
    }

    @Override
    public void deleteItemById(long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item updateItem(Item item, long id) throws RecordNotFoungException {
        Item item2 = itemRepository.findById(id).get();
        if (item2.getId() != 0) {
            item2.setName(item.getName());
            item2.setPrice(item.getPrice());
            item2.setDescription(item.getDescription());
        } else {
            throw new RecordNotFoungException("not found");
        }
        itemRepository.save(item2);
        return item2;
    }
    
}

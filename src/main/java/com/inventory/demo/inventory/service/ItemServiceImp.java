package com.inventory.demo.inventory.service;


import java.util.List;

import com.inventory.demo.inventory.entity.Item;
import com.inventory.demo.inventory.exception.RecordNotFoungException;

public interface ItemServiceImp {
    
    public Item saveItem(Item item);

    public List<Item> getAllItems();

    public Item getItemById(long id) throws RecordNotFoungException;

    public Item updateItem(Item item, long id) throws RecordNotFoungException;

    public void deleteItemById(long id);

}

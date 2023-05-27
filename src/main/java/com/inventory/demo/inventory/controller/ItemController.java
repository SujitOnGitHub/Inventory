package com.inventory.demo.inventory.controller;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.demo.inventory.entity.Item;
import com.inventory.demo.inventory.exception.RecordNotFoungException;
import com.inventory.demo.inventory.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item item){
        return new ResponseEntity<Item>(itemService.saveItem(item),HttpStatus.CREATED) ;

    }


    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems() ;
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") long id) throws RecordNotFoungException{
        return new ResponseEntity<Item>(itemService.getItemById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item, @PathVariable("id") long id) throws RecordNotFoungException{
        return new ResponseEntity<Item>(itemService.updateItem(item, id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable("id") long id){

        itemService.deleteItemById(id);
        return new ResponseEntity<String>("item deleted",HttpStatus.OK);
    }

}

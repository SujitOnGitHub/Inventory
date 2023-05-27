package com.inventory.demo.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.demo.inventory.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}

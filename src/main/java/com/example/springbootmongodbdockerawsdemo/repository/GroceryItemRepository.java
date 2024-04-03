package com.example.springbootmongodbdockerawsdemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;

public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {

    @Query("{name:'?0'}")
    GroceryItem findItemByName(String name);

    @Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
    List<GroceryItem> findAll(String category);

    public long count();

}

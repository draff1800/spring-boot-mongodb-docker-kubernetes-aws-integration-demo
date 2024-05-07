package com.example.springbootmongodbdockerawsdemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;

public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {

    @Query("{category:'?0'}")
    List<GroceryItem> findAll(String category);
    
    @Query("{name:'?0'}")
    GroceryItem findItemByName(String name);

    @Query(value = "{'name' : ?0}", delete = true)
    void deleteByName(String name);
}   

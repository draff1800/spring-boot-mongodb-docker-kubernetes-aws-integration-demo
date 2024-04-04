package com.example.springbootmongodbdockerawsdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;
import com.mongodb.client.result.UpdateResult;

@Component
public class CustomGroceryItemRepositoryImpl implements CustomGroceryItemRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    
    public void updateGroceryItemQuantity(String name, int newQuantity) {
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("quantity", newQuantity);
        
        UpdateResult result = mongoTemplate.updateFirst(query, update, GroceryItem.class);
        
        System.out.println(result.getModifiedCount() + " Grocery Items updated.");
    }
}

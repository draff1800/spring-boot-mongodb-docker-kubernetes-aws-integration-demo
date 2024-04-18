package com.example.springbootmongodbdockerawsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;
import com.example.springbootmongodbdockerawsdemo.service.GroceryItemService;

import java.util.List;

@RestController
public class GroceryItemController {

    @Autowired
    GroceryItemService groceryItemServiceImpl;

    @GetMapping
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemServiceImpl.getAllGroceryItems();
    }

    @GetMapping("/category/{category}")
    public List<GroceryItem> getGroceryItemsByCategory(@PathVariable String category) {
        return groceryItemServiceImpl.getGroceryItemsByCategory(category);
    }

    @GetMapping("/name/{name}")
    public GroceryItem getGroceryItemByName(@PathVariable String name) {
        return groceryItemServiceImpl.getGroceryItemByName(name);
    }
}

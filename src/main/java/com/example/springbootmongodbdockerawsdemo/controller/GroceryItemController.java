package com.example.springbootmongodbdockerawsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;
import com.example.springbootmongodbdockerawsdemo.service.GroceryItemService;

import java.util.List;

@RestController
public class GroceryItemController {

    @Autowired
    GroceryItemService groceryItemServiceImpl;

    @GetMapping("/")
    public List<GroceryItem> testEndpoint() {
        return groceryItemServiceImpl.getAllGroceryItems();
    }

}

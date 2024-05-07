package com.example.springbootmongodbdockerawsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;
import com.example.springbootmongodbdockerawsdemo.service.impl.GroceryItemServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/groceryitems")
public class GroceryItemController {

    @Autowired
    GroceryItemServiceImpl groceryItemServiceImpl;

    @GetMapping
    public List<GroceryItem> getGroceryItems(@RequestParam(required = false) String category) {
        return groceryItemServiceImpl.getGroceryItems(category);
    }

    @GetMapping("/name/{name}")
    public GroceryItem getGroceryItemByName(@PathVariable String name) {
        return groceryItemServiceImpl.getGroceryItemByName(name);
    }

    @PostMapping
    public GroceryItem createGroceryItem(@RequestBody GroceryItem groceryItem) {
        return groceryItemServiceImpl.createGroceryItem(groceryItem);
    }

    @PutMapping("/category/{oldCategory}")
    public List<GroceryItem> updateGroceryItemsCategory(
            @PathVariable String oldCategory,
            @RequestParam String newCategory) {
        return groceryItemServiceImpl.updateGroceryItemsCategory(oldCategory, newCategory);
    }

    @PutMapping("/name/{name}")
    public GroceryItem updateGroceryItemQuantity(
            @PathVariable String name,
            @RequestParam int newQuantity) {
        return groceryItemServiceImpl.updateGroceryItemQuantity(name, newQuantity);
    }

    @DeleteMapping
    public void deleteGroceryItem(@RequestParam String id) {
        groceryItemServiceImpl.deleteGroceryItem(id);
    }
}

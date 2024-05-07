package com.example.springbootmongodbdockerawsdemo.service;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;

import java.util.List;

public interface GroceryItemService {
    List<GroceryItem> getGroceryItems(String category);
    GroceryItem getGroceryItemByName(String name);
    GroceryItem createGroceryItem(GroceryItem groceryItem);
    List<GroceryItem> updateGroceryItemsCategory(String oldCategory, String newCategory);
    GroceryItem updateGroceryItemQuantity(String name, int newQuantity);
    void deleteGroceryItem(String id);
}

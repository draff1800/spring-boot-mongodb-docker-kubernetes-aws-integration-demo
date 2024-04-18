package com.example.springbootmongodbdockerawsdemo.repository;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;

public interface CustomGroceryItemRepository {
    GroceryItem updateGroceryItemQuantity(String name, int newQuantity);
}

package com.example.springbootmongodbdockerawsdemo.repository;

public interface CustomGroceryItemRepository {
    void updateGroceryItemQuantity(String name, int newQuantity);
}

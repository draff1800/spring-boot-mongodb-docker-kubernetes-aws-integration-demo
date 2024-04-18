package com.example.springbootmongodbdockerawsdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;
import com.example.springbootmongodbdockerawsdemo.repository.CustomGroceryItemRepository;
import com.example.springbootmongodbdockerawsdemo.repository.GroceryItemRepository;
import com.example.springbootmongodbdockerawsdemo.service.GroceryItemService;

import java.util.List;

@Service
@Transactional
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private CustomGroceryItemRepository customGroceryItemRepository;

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public List<GroceryItem> getGroceryItemsByCategory(String category) {
        return groceryItemRepository.findAll(category);
    }

    public GroceryItem getGroceryItemByName(String name) {
        return groceryItemRepository.findItemByName(name);
    }

    public GroceryItem createGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> updateGroceryItemsCategory(String oldCategory, String newCategory) {
        List<GroceryItem> list = groceryItemRepository.findAll(oldCategory);
        list.forEach(item -> item.setCategory(newCategory));

        return groceryItemRepository.saveAll(list);
    }

    public GroceryItem updateGroceryItemQuantity(String name, int newQuantity) {
        return customGroceryItemRepository.updateGroceryItemQuantity(name, newQuantity);
    }

    public void deleteGroceryItem(String id) {
        groceryItemRepository.deleteById(id);
    }
}

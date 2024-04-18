package com.example.springbootmongodbdockerawsdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("groceryitems")
public class GroceryItem {

    @Id
    private String id;
    @Getter
    private String name;
    @Getter
    private int quantity;
    @Getter
    @Setter
    private String category;

    public GroceryItem() {}

    public GroceryItem(String id, String name, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
}
package com.example.springbootmongodbdockerawsdemo.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("groceryitems")
@TypeAlias("groceryitem")
public class GroceryItem {

    @Indexed(unique = true)
    @Getter
    private String name;
    @Getter
    private int quantity;
    @Getter
    @Setter
    private String category;

    public GroceryItem() {
    }

    public GroceryItem(String name, int quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
}
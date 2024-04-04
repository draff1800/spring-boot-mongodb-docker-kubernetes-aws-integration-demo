package com.example.springbootmongodbdockerawsdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.springbootmongodbdockerawsdemo.model.GroceryItem;
import com.example.springbootmongodbdockerawsdemo.repository.CustomGroceryItemRepositoryImpl;
import com.example.springbootmongodbdockerawsdemo.repository.GroceryItemRepository;

@SpringBootApplication
@EnableMongoRepositories
public class SpringbootMongodbDockerAwsDemoApplication implements CommandLineRunner {

	@Autowired
	GroceryItemRepository groceryItemRepo;

	@Autowired
    CustomGroceryItemRepositoryImpl customGroceryItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbDockerAwsDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("\nCreating Grocery Items...");
		createGroceryItems();
		System.out.println("\nPrinting Grocery Items...");
		printGroceryItems();
		System.out.println("\nPrinting Grocery Items (millets Category)...");
		printGroceryItemsByCategory("millets");
		System.out.println("\nPrinting Grocery Item (Whole Wheat Biscuit)...");
		printGroceryItemByName("Whole Wheat Biscuit");
		System.out.println("\nUpdating Grocery Items' Category...");
		updateGroceryItemCategory("snacks", "munchies");
		System.out.println("\nUpdating a Grocery Item's Quantity...");
		updateGroceryItemQuantity("Bonny Cheese Crackers Plain", 10);
		System.out.println("\nDeleting a Grocery Item...");
		deleteGroceryItem("Kodo Millet");
		System.out.println("\nPrinting Grocery Items count...");
		printGroceryItemsCount();
	}

    void createGroceryItems() {
        groceryItemRepo.save(new GroceryItem(
			"Whole Wheat Biscuit1", "Whole Wheat Biscuit1", 5, "snacks"
		));
        groceryItemRepo.save(new GroceryItem(
			"Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"
		));
        groceryItemRepo.save(
			new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"
		));
        groceryItemRepo.save(new GroceryItem(
			"Pearl Millet", "Healthy Pearl Millet", 1, "millets"
		));
        groceryItemRepo.save(new GroceryItem(
			"Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"
		));
    }

	public void printGroceryItems() {
		groceryItemRepo.findAll().forEach(item -> printGroceryItemDetails(item));
	}

	public void printGroceryItemsByCategory(String category) {
		List<GroceryItem> list = groceryItemRepo.findAll(category);
		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
	}
     
	public void printGroceryItemByName(String name) {
		GroceryItem item = groceryItemRepo.findItemByName(name);
		printGroceryItemDetails(item);
	}

	public void updateGroceryItemCategory(String oldCategoryName, String newCategoryName) {         
		List<GroceryItem> list = groceryItemRepo.findAll(oldCategoryName);
		list.forEach(item -> {
			item.setCategory(newCategoryName);
		});
         
		List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(list);
         
		if(itemsUpdated != null) {
			System.out.println(
				"Updated Category of " + itemsUpdated.size() + " Items from \"" + 
				oldCategoryName + "\" to \"" + newCategoryName + "\"."
			);
		}
	}

	public void updateGroceryItemQuantity(String name, int newQuantity) {
		customGroceryItemRepo.updateGroceryItemQuantity(name, newQuantity);
		System.out.println("Updated Quantity of " + name + " to " + newQuantity + ".");
	}

	public void deleteGroceryItem(String id) {
		groceryItemRepo.deleteById(id);
		System.out.println("Grocery Item (ID: " + id + ") deleted.");
	}

	public void printGroceryItemsCount() {
		long count = groceryItemRepo.count();
		System.out.println("There are " + count + " Grocery Items in the Grocery List.");
	}

	public void printGroceryItemDetails(GroceryItem item) {
		System.out.println(
			"Name: " + item.getName() + " | " +
			"Quantity: " + item.getQuantity() + " | " +
			"Category: " + item.getCategory()
		);
	}
}

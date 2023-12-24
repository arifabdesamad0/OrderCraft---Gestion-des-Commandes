package com.artwood.Dao;

import com.artwood.model.Item;

import java.util.List;

public interface ItemDao {
    // Adds a new item to the database
    void addItem(Item item);

    // Retrieves an item by its ID
    Item getItem(int id);

    // Updates an existing item's information in the database
    void updateItem(Item item);

    // Deletes an item from the database by its ID
    void deleteItem(int id);

    // Retrieves a list of all items
    List<Item> getAllItems();

    // Additional methods can be added as needed, for example:
    // List<Item> getItemsByCategory(String category);
    // void updateItemQuantity(int id, int quantity);
}

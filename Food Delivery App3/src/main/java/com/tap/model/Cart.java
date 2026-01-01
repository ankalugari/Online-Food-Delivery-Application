package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    // Map<itemId, CartItem>
    private Map<Integer, CartItem> items;

    // Constructor
    public Cart() {
        items = new HashMap<>();
    }

    // Getter
    public Map<Integer, CartItem> getItems() {
        return items;
    }

    // 1️⃣ Add item to cart
    public void addItem(CartItem item) {
        int itemId = item.getId();

        if (items.containsKey(itemId)) {
            // If item already exists, increase quantity
            CartItem existingItem = items.get(itemId);
            existingItem.setQuantity(
                    existingItem.getQuantity() + item.getQuantity()
            );
        } else {
            // New item
            items.put(itemId, item);
        }
    }

    // 2️⃣ Update item quantity
    public void updateItem(int itemId, int quantity) {
        if (items.containsKey(itemId)) {
            if (quantity <= 0) {
                // If quantity is zero or less, remove item
                items.remove(itemId);
            } else {
                items.get(itemId).setQuantity(quantity);
            }
        }
    }

    // 3️⃣ Delete item from cart
    public void deleteItem(int itemId) {
        items.remove(itemId);
    }
    //4 get all items
    
}
package com.tap.model;

public class CartItem {

    private int id;
    private String itemName;
    private double price;
    private int quantity;

    // No-arg constructor
    public CartItem() {
    }

    // Parameterized constructor (ONLY ONE YOU NEED)
    public CartItem(int id, String itemName, double price, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
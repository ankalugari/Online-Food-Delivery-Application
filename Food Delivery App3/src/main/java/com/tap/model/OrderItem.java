package com.tap.model;

public class OrderItem {

    private int orderItemId;
    private int orderId;
    private int menuId;
    private String itemName;
    private int quantity;
    private double totalPrice;

    // No-arg constructor
    public OrderItem() {}

    // Parameterized constructor
    public OrderItem(int orderId, int menuId, String itemName,
                     int quantity, double totalPrice) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
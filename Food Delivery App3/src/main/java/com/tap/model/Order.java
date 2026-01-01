package com.tap.model;

import java.sql.Timestamp;

public class Order {

    private int orderId;
    private int userId;
    private int restaurantId;
    private double totalAmount;
    private String paymentMethod;
    private String status;
    private String address;
    private Timestamp orderDate;

    // No-arg constructor
    public Order() {}

    // Parameterized constructor
    public Order(int userId, int restaurantId, double totalAmount,
                 String paymentMethod, String status, String address) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.address = address;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}
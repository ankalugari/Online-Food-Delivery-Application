package com.tap.dao;

import java.util.List;

import com.tap.model.Order;
import com.tap.model.OrderItem;

public interface OrderDao {

    // Insert order and return generated orderId
    int saveOrder(Order order);

    // Insert all order items for an order
    void saveOrderItems(List<OrderItem> items);

    // (Later use) Fetch orders by user
    List<Order> getOrdersByUserId(int userId);
}
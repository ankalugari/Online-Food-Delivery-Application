package com.tap.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDao;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.util.DBConnection;

public class OrderDaoImpl implements OrderDao {

    // 1️⃣ Save order (parent table)
    @Override
    public int saveOrder(Order order) {

        int generatedOrderId = 0;

        String sql = "INSERT INTO orders "
                   + "(user_id, restaurant_id, total_amount, payment_method, status, address) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getRestaurantId());
            ps.setDouble(3, order.getTotalAmount());
            ps.setString(4, order.getPaymentMethod());
            ps.setString(5, order.getStatus());
            ps.setString(6, order.getAddress());

            ps.executeUpdate();

            // Get generated order_id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedOrderId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedOrderId;
    }

    // 2️⃣ Save order items (child table)
    @Override
    public void saveOrderItems(List<OrderItem> items) {

        String sql = "INSERT INTO order_items "
                   + "(order_id, menu_id, item_name, quantity, total_price) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (OrderItem item : items) {
                ps.setInt(1, item.getOrderId());
                ps.setInt(2, item.getMenuId());
                ps.setString(3, item.getItemName());
                ps.setInt(4, item.getQuantity());
                ps.setDouble(5, item.getTotalPrice());
                ps.addBatch();
            }

            ps.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3️⃣ Fetch orders for a user (used later)
    @Override
    public List<Order> getOrdersByUserId(int userId) {

        List<Order> list = new ArrayList<>();

        String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY order_date DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setOrderId(rs.getInt("order_id"));
                o.setUserId(rs.getInt("user_id"));
                o.setRestaurantId(rs.getInt("restaurant_id"));
                o.setTotalAmount(rs.getDouble("total_amount"));
                o.setPaymentMethod(rs.getString("payment_method"));
                o.setStatus(rs.getString("status"));
                o.setAddress(rs.getString("address"));
                o.setOrderDate(rs.getTimestamp("order_date"));

                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
package com.tap.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tap.daoImpl.OrderDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("loggedUser");
        Cart cart = (Cart) session.getAttribute("cart");
        Integer restaurantId = (Integer) session.getAttribute("restaurantId");

        // 🔒 Safety check
        if (user == null || cart == null || cart.getItems().isEmpty()) {
            resp.sendRedirect("HomeServlet");
            return;
        }

        // 1️⃣ Read form data
        String address = req.getParameter("address");
        String paymentMethod = req.getParameter("paymentMethod");

        // 2️⃣ Calculate total
        double totalAmount = 0;
        for (CartItem item : cart.getItems().values()) {
            totalAmount += item.getPrice() * item.getQuantity();
        }

        // 3️⃣ Save ORDER
        Order order = new Order(
                user.getId(),
                restaurantId,
                totalAmount,
                paymentMethod,
                "PLACED",
                address
        );

        OrderDaoImpl orderDao = new OrderDaoImpl();
        int orderId = orderDao.saveOrder(order);

        // 4️⃣ Save ORDER ITEMS
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem item : cart.getItems().values()) {
            OrderItem oi = new OrderItem(
                    orderId,
                    item.getId(), // menuId
                    item.getItemName(),
                    item.getQuantity(),
                    item.getPrice() * item.getQuantity()
            );
            orderItems.add(oi);
        }

        orderDao.saveOrderItems(orderItems);

        // 5️⃣ Clear cart
        session.removeAttribute("cart");

        // 6️⃣ Pass data to success page (IMPORTANT)
        req.setAttribute("orderId", orderId);
        req.setAttribute("orderAddress", address);
        req.setAttribute("paymentMethod", paymentMethod);
        req.setAttribute("orderTotal", totalAmount);

        // 7️⃣ Forward (NOT redirect)
        req.getRequestDispatcher("checkout-success.jsp")
           .forward(req, resp);
    }
}
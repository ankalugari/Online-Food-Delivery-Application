package com.tap.Servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.tap.dao.OrdersDAO;
import com.tap.dao.OrderItemDAO;
import com.tap.daoimpl.OrdersDAOImpl;
import com.tap.daoimpl.OrderItemDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Orders;
import com.tap.model.Orderitem;
import com.tap.model.User;
import com.tap.model.*;
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        // Get logged-in user
        User user = (User) session.getAttribute("currentUser");



        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }

        //  Get cart from session
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

        //  Get checkout form data
        String address = request.getParameter("address");
        String paymentMode = request.getParameter("paymentMode");

        if (paymentMode == null || paymentMode.isEmpty()) {
            paymentMode = "COD"; // Default to Cash on Delivery
        }

        // Optionally update user's address
        user.setAddress(address);

        // Initialize DAOs
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

        try {
            // Create and insert new order
            Orders order1 = new Orders();
            order1.setUserid(user.getUserid());
            order1.setRestaurantid(cart.getRestaurantId());
            order1.setOrderDate(new Timestamp(System.currentTimeMillis()));
            order1.setTotalAmount(cart.getTotalPrice());
            order1.setStatus("Pending");
            order1.setPaymentMode(paymentMode);

            // Insert order → returns generated orderId
            int orderId = ordersDAO.addOrder(order1);

            //  Add each cart item as order item
            if (orderId > 0) {
                Collection<CartItem> cartItems = cart.getItems();
                for (CartItem item : cartItems) {
                    Orderitem orderItem = new Orderitem();
                    orderItem.setOrderid(orderId);
                    orderItem.setMenuid(item.getId());
                    orderItem.setQuantity(item.getQuantity());
                    orderItem.setTotalPrice(item.getTotalPrice());
                    orderItemDAO.addOrderItem(orderItem);
                }

                //  Clear cart after successful order
                session.removeAttribute("cart");

                //  Redirect to success page
                request.setAttribute("message", "🎉 Order placed successfully! Order ID: " + orderId);
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "⚠️ Failed to place order. Please try again.");
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "⚠️ Something went wrong during checkout.");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }
    }
}
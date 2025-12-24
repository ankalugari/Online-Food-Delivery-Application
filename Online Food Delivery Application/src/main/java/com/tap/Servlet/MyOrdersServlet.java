package com.tap.Servlet;

import java.io.IOException;
import java.util.List;

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
import com.tap.model.Orders;
import com.tap.model.Orderitem;
import com.tap.model.User;

@WebServlet("/myorders")
public class MyOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }

        OrdersDAO ordersDAO = new OrdersDAOImpl();
        OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

        // Get all orders for this user
        List<Orders> orders = ordersDAO.getOrdersByUserId(user.getUserid());

        request.setAttribute("orders", orders);
        request.setAttribute("orderItemDAO", orderItemDAO); // pass DAO to fetch items in JSP
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
}
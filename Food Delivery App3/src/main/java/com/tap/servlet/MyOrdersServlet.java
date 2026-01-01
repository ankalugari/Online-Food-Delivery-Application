package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.daoImpl.OrderDaoImpl;
import com.tap.model.Order;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/my-orders")
public class MyOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        OrderDaoImpl dao = new OrderDaoImpl();
        List<Order> orders = dao.getOrdersByUserId(user.getId());

        req.setAttribute("orders", orders);
        req.getRequestDispatcher("my-orders.jsp").forward(req, resp);
    }
}
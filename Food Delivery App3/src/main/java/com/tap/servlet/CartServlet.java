package com.tap.servlet;

import java.io.IOException;

import com.tap.daoImpl.MenuDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        // Get restaurantId safely
        String restIdStr = req.getParameter("restaurantId");
        if (restIdStr == null) {
            resp.sendRedirect("cart.jsp");
            return;
        }

        int newRestaurantId = Integer.parseInt(restIdStr);
        Integer currentRestaurantId =
                (Integer) session.getAttribute("restaurantId");

        // Create new cart if first time OR restaurant changed
        if (cart == null || currentRestaurantId == null
                || currentRestaurantId != newRestaurantId) {

            cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("restaurantId", newRestaurantId);
        }

        String action = req.getParameter("action");

        if ("add".equals(action)) {
            addItemToCart(req, cart);
        } else if ("update".equals(action)) {
            updateItemInCart(req, cart);
        } else if ("remove".equals(action)) {
            removeItemFromCart(req, cart);
        }

        resp.sendRedirect("cart.jsp");
    }

    private void addItemToCart(HttpServletRequest req, Cart cart) {

        int itemId = Integer.parseInt(req.getParameter("itemId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        MenuDaoImpl menuDao = new MenuDaoImpl();
        Menu menuItem = menuDao.getMenuById(itemId);

        if (menuItem != null) {
            CartItem item = new CartItem(
                    menuItem.getId(),
                    menuItem.getItemName(),
                    menuItem.getPrice(),
                    quantity
            );
            cart.addItem(item);
        }
    }

    private void updateItemInCart(HttpServletRequest req, Cart cart) {

        int itemId = Integer.parseInt(req.getParameter("itemId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        cart.updateItem(itemId, quantity);
    }

    private void removeItemFromCart(HttpServletRequest req, Cart cart) {

        int itemId = Integer.parseInt(req.getParameter("itemId"));
        cart.deleteItem(itemId);
    }
}
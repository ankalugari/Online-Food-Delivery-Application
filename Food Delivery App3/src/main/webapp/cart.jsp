<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Cart,com.tap.model.CartItem"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>

<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    padding: 30px;
}

h1 {
    text-align: center;
    margin-bottom: 20px;
}

.cart-container {
    max-width: 700px;
    margin: auto;
}

.cart-item {
    background: #fff;
    border-radius: 8px;
    padding: 15px;
    margin-bottom: 15px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.cart-item-details h3 {
    margin-bottom: 8px;
    color: #333;
}

.cart-item-details p {
    margin: 5px 0;
    color: #555;
}

.quantity-section {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-top: 10px;
}

.quantity-btn {
    background: #ff7a00;
    color: #fff;
    border: none;
    padding: 6px 12px;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
}

.quantity-btn:disabled {
    background: #ccc;
    cursor: not-allowed;
}

.quantity {
    font-size: 16px;
    font-weight: bold;
    min-width: 20px;
    text-align: center;
}

.remove-btn {
    background: #dc3545;
    color: #fff;
    border: none;
    padding: 6px 12px;
    border-radius: 4px;
    cursor: pointer;
}

.cart-actions {
    display: flex;
    justify-content: space-between;
    max-width: 700px;
    margin: 30px auto;
}

.action-btn {
    padding: 12px 20px;
    border-radius: 6px;
    font-size: 16px;
    cursor: pointer;
    border: none;
}

.add-more-btn {
    background-color: #007bff;
    color: white;
}

.checkout-btn {
    background-color: #28a745;
    color: white;
}

.action-btn:hover {
    opacity: 0.9;
}

.empty {
    text-align: center;
    font-size: 18px;
    color: #666;
}
</style>
</head>

<body>

<!-- ✅ NAVBAR COMES FROM HERE -->
   <jsp:include page="header.jsp" />

<h1>Your Cart</h1>

<div class="cart-container">

<%
    Cart cart = (Cart) session.getAttribute("cart");
    Integer restaurantId = (Integer) session.getAttribute("restaurantId");
    double grandTotal = 0;

    if (cart != null && !cart.getItems().isEmpty()) {
        for (CartItem item : cart.getItems().values()) {
            double itemTotal = item.getPrice() * item.getQuantity();
            grandTotal += itemTotal;
%>

    <!-- CART ITEM -->
    <div class="cart-item">
        <div class="cart-item-details">
            <h3><%= item.getItemName() %></h3>
            <p>Price: ₹ <%= item.getPrice() %></p>
            <p>Total: ₹ <%= itemTotal %></p>

            <div class="quantity-section">

                <!-- Increase -->
                <form action="cart" method="post">
                    <input type="hidden" name="itemId" value="<%= item.getId() %>">
                    <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                    <button class="quantity-btn">+</button>
                </form>

                <div class="quantity"><%= item.getQuantity() %></div>

                <!-- Decrease -->
                <form action="cart" method="post">
                    <input type="hidden" name="itemId" value="<%= item.getId() %>">
                    <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                    <button class="quantity-btn"
                        <%= item.getQuantity() == 1 ? "disabled" : "" %>>
                        −
                    </button>
                </form>

                <!-- Remove -->
                <form action="cart" method="post">
                    <input type="hidden" name="itemId" value="<%= item.getId() %>">
                    <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                    <button class="remove-btn" name="action" value="remove">
                        Remove
                    </button>
                </form>

            </div>
        </div>
    </div>

<%
        }
%>

    <!-- CART ACTIONS (ONLY ONCE – SWIGGY STYLE) -->
    <div class="cart-actions">

        <!-- Add More Items -->
        <form action="menu" method="get">
            <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
            <button type="submit" class="action-btn add-more-btn">
                ➕ Add More Items
            </button>
        </form>

        <!-- Checkout -->
        <form action="checkout.jsp" method="post">
            <button type="submit" class="action-btn checkout-btn">
                ✅ Checkout (₹ <%= grandTotal %>)
            </button>
        </form>

    </div>

<%
    } else {
%>
    <p class="empty">Your cart is empty 🛒</p>
<%
    }
%>

</div>

</body>
</html>

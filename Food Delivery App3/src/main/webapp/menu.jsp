<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.tap.model.Menu" %>

<%
    // ✅ LOGIN CHECK (MUST BE AT TOP)
    if (session.getAttribute("loggedUser") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Restaurant Menu</title>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, Helvetica, sans-serif;
}

body {
    background-color: #f4f4f4;
    padding: 30px;
}

h1 {
    text-align: center;
    margin-bottom: 30px;
    color: #333;
}

.menu-container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
    gap: 20px;
}

.menu-card {
    background: #fff;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    transition: transform 0.3s;
}

.menu-card:hover {
    transform: scale(1.03);
}

.menu-card img {
    width: 100%;
    height: 170px;
    object-fit: cover;
}

.menu-content {
    padding: 15px;
}

.item-name {
    font-size: 18px;
    font-weight: bold;
    color: #222;
    margin-bottom: 5px;
}

.rating {
    background: #28a745;
    color: #fff;
    display: inline-block;
    padding: 3px 8px;
    border-radius: 5px;
    font-size: 14px;
    margin-bottom: 6px;
}

.description {
    font-size: 14px;
    color: #555;
    margin-bottom: 10px;
}

.price-cart {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.price {
    font-size: 16px;
    font-weight: bold;
    color: #e63946;
}

.add-btn {
    background: #ff7a00;
    color: #fff;
    border: none;
    padding: 8px 14px;
    border-radius: 6px;
    cursor: pointer;
    font-size: 14px;
}

.add-btn:hover {
    background: #e66a00;
}
</style>
</head>

<body>

<!-- ✅ NAVBAR -->
<jsp:include page="header.jsp" />

<h1>Menu</h1>

<div class="menu-container">
<%
    List<Menu> menuByRestaurantId =
        (List<Menu>) request.getAttribute("menuByRestaurantId");

    if (menuByRestaurantId != null) {
        for (Menu m : menuByRestaurantId) {
%>
    <div class="menu-card">
        <img src="${pageContext.request.contextPath}/Images/<%= m.getImageUrl() %>">
        <div class="menu-content">
            <div class="item-name"><%= m.getItemName() %></div>
            <div class="rating"><%= m.getRating() %></div>
            <div class="description"><%= m.getDescription() %></div>
            <div class="price-cart">
                <div class="price">₹ <%= m.getPrice() %></div>

                <form action="cart" method="post">
                    <input type="hidden" name="itemId" value="<%= m.getId() %>">
                    <input type="hidden" name="quantity" value="1">
                    <input type="hidden" name="restaurantId" value="<%= m.getRestaurantId() %>">
                    <input type="hidden" name="action" value="add">
                    <button type="submit" class="add-btn">Add to Cart</button>
                </form>
            </div>
        </div>
    </div>
<%
        }
    }
%>
</div>

</body>
</html>

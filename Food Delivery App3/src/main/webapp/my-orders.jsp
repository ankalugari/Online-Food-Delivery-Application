<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List,com.tap.model.Order" %>

<!DOCTYPE html>
<html>
<head>
<title>My Orders</title>
<style>
body {
    font-family: Arial;
    background: #f4f4f4;
    padding: 30px;
}
.order-box {
    background: white;
    padding: 15px;
    margin-bottom: 15px;
    border-radius: 8px;
}
</style>
</head>
<body>

<h2>My Orders</h2>

<%
List<Order> orders = (List<Order>) request.getAttribute("orders");
if (orders == null || orders.isEmpty()) {
%>
    <p>No orders found.</p>
<%
} else {
    for (Order o : orders) {
%>
    <div class="order-box">
        <p><b>Order ID:</b> <%= o.getOrderId() %></p>
        <p><b>Date:</b> <%= o.getOrderDate() %></p>
        <p><b>Total:</b> ₹ <%= o.getTotalAmount() %></p>
        <p><b>Status:</b> <%= o.getStatus() %></p>
    </div>
<%
    }
}
%>

<a href="HomeServlet">⬅ Back to Home</a>

</body>
</html>

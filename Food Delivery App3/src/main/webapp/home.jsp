<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.tap.model.Restaurant,com.tap.model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Restaurants</title>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "Segoe UI", Arial, Helvetica, sans-serif;
}

body {
    background: linear-gradient(135deg, #fff5eb, #ffffff);
    padding: 20px 30px;
}

/* ================= NAVBAR ================= */
.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background: linear-gradient(90deg, #ff7a00, #ff9f1c);
    padding: 15px 30px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.15);
    margin-bottom: 30px;
    border-radius: 12px;
}

.logo {
    font-size: 24px;
    font-weight: bold;
    color: #ffffff;
}

.nav-right a,
.nav-right button {
    margin-left: 15px;
    text-decoration: none;
    padding: 9px 18px;
    border-radius: 25px;
    font-size: 14px;
    cursor: pointer;
    transition: all 0.3s ease;
}

.login-btn {
    background: #ffffff;
    color: #ff7a00;
}

.login-btn:hover {
    background: #ffe1c7;
}

.register-btn {
    background: #2ecc71;
    color: #ffffff;
}

.register-btn:hover {
    background: #27ae60;
}

.logout-btn {
    background: #e63946;
    color: #ffffff;
    border: none;
}

.logout-btn:hover {
    background: #c1121f;
}

.profile-btn {
    background: #ffffff;
    color: #ff7a00;
}

.profile-btn:hover {
    background: #ffe1c7;
}

.user-name {
    font-weight: bold;
    margin-right: 10px;
    color: #ffffff;
}

/* ================= PAGE ================= */
h1 {
    text-align: center;
    margin-bottom: 35px;
    color: #ff7a00;
    font-size: 34px;
    letter-spacing: 1px;
}

.restaurant-container {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
    gap: 25px;
}

/* ================= CARD ================= */
.restaurant-card {
    background: #ffffff;
    border-radius: 16px;
    overflow: hidden;
    box-shadow: 0 8px 20px rgba(0,0,0,0.12);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.restaurant-card:hover {
    transform: translateY(-8px);
    box-shadow: 0 14px 30px rgba(0,0,0,0.18);
}

.restaurant-card img {
    width: 100%;
    height: 180px;
    object-fit: cover;
}

.card-content {
    padding: 18px;
}

.restaurant-name {
    font-size: 19px;
    font-weight: bold;
    color: #222;
    margin-bottom: 6px;
}

.rating {
    color: #ffffff;
    background: linear-gradient(135deg, #2ecc71, #27ae60);
    display: inline-block;
    padding: 4px 12px;
    border-radius: 20px;
    font-size: 13px;
    margin-bottom: 10px;
}

.address {
    font-size: 14px;
    color: #777;
    margin-bottom: 6px;
}

.description {
    font-size: 14px;
    color: #555;
    margin-bottom: 12px;
    line-height: 1.5;
}

.eta {
    font-size: 14px;
    font-weight: bold;
    color: #e63946;
}
</style>
</head>

<body>

<%
    User loggedUser = (User) session.getAttribute("loggedUser");
%>

<!-- ================= NAVBAR ================= -->
<jsp:include page="header.jsp" />

<!-- ================= CONTENT ================= -->
<h1>Top Restaurants</h1>

<div class="restaurant-container">
<%
    List<Restaurant> listofrestaurants =
        (List<Restaurant>) request.getAttribute("listofrestaurants");

    if (listofrestaurants != null) {
        for (Restaurant res : listofrestaurants) {
%>
    <a href="menu?restaurantId=<%= res.getId() %>" style="text-decoration:none;">
        <div class="restaurant-card">
            <img src="${pageContext.request.contextPath}/Images/<%= res.getImageUrl() %>"
                 alt="Restaurant Image">
            <div class="card-content">
                <div class="restaurant-name"><%= res.getName() %></div>
                <div class="rating"><%= res.getRating() %></div>
                <div class="address"><%= res.getAddress() %></div>
                <div class="description"><%= res.getDescription() %></div>
                <div class="eta"><%= res.getEta() %></div>
            </div>
        </div>
    </a>
<%
        }
    }
%>
</div>

</body>
</html>

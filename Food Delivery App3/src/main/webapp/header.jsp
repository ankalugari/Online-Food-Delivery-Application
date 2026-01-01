<%@ page import="com.tap.model.User" %>

<style>
/* ================= NAVBAR ================= */
.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background: linear-gradient(90deg, #ff7a00, #ff9f1c);
    padding: 16px 32px;
    box-shadow: 0 6px 16px rgba(0,0,0,0.18);
    margin-bottom: 30px;
    border-radius: 14px;
}

/* ================= LOGO ================= */
.logo {
    font-size: 24px;
    font-weight: bold;
    color: #ffffff;
    text-decoration: none;
    letter-spacing: 0.5px;
}

/* ================= NAV RIGHT ================= */
.nav-right {
    display: flex;
    align-items: center;
}

/* ================= BUTTONS ================= */
.nav-right a,
.nav-right button {
    margin-left: 14px;
    text-decoration: none;
    padding: 9px 18px;
    border-radius: 22px;
    font-size: 14px;
    cursor: pointer;
    border: none;
    font-weight: 600;
    transition: all 0.3s ease;
}

/* Login */
.login-btn {
    background: #ffffff;
    color: #ff7a00;
}
.login-btn:hover {
    background: #ffe1c7;
}

/* Register */
.register-btn {
    background: #2ecc71;
    color: #ffffff;
}
.register-btn:hover {
    background: #27ae60;
}

/* Cart */
.cart-btn {
    background: #222;
    color: #ffffff;
}
.cart-btn:hover {
    background: #000;
}

/* Profile */
.profile-btn {
    background: #ffffff;
    color: #ff7a00;
}
.profile-btn:hover {
    background: #ffe1c7;
}

/* Logout */
.logout-btn {
    background: #e63946;
    color: #ffffff;
}
.logout-btn:hover {
    background: #c1121f;
}

/* ================= USER NAME ================= */
.user-name {
    font-weight: bold;
    color: #ff7a00;
}
</style>

<%
    User loggedUser = (User) session.getAttribute("loggedUser");
%>

<div class="navbar">

    <!-- HOME / RESTAURANTS -->
    <a href="HomeServlet" class="logo">Food Express </a>

    <div class="nav-right">

        <% if (loggedUser == null) { %>

            <!-- BEFORE LOGIN -->
            <a href="login.jsp" class="login-btn">Login</a>
            <a href="register.jsp" class="register-btn">Register</a>

        <% } else { %>

            <!-- CART -->
            <a href="cart.jsp" class="cart-btn">Cart</a>

            <!-- PROFILE -->
            <a href="profile.jsp" class="profile-btn">
                Hi, <span class="user-name"><%= loggedUser.getName() %></span>
            </a>

            <!-- LOGOUT -->
            <form action="logout" method="post" style="display:inline;">
                <button class="logout-btn">Logout</button>
            </form>

        <% } %>

    </div>
</div>

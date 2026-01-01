<%@ page import="com.tap.model.User" %>

<%
    User user = (User) session.getAttribute("loggedUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: "Segoe UI", Arial, sans-serif;
    background: linear-gradient(135deg, #ff7a00, #ffb347);
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

/* ================= PROFILE CARD ================= */
.box {
    width: 420px;
    background: #ffffff;
    padding: 30px;
    border-radius: 16px;
    box-shadow: 0 12px 30px rgba(0,0,0,0.25);
    animation: fadeIn 0.6s ease;
}

@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(20px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

h2 {
    text-align: center;
    margin-bottom: 25px;
    color: #ff7a00;
    font-size: 26px;
}

/* ================= PROFILE DETAILS ================= */
p {
    margin: 14px 0;
    font-size: 15px;
    color: #444;
}

p b {
    color: #222;
}

/* ================= BACK BUTTON ================= */
.back-btn {
    margin-top: 22px;
    padding: 12px 24px;
    background: linear-gradient(90deg, #007bff, #00b4ff);
    color: #ffffff;
    text-decoration: none;
    border-radius: 25px;
    font-weight: bold;
    transition: all 0.3s ease;
}

.back-btn:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(0,123,255,0.45);
}
</style>
</head>

<body>

<div class="box">
    <h2>My Profile</h2>

    <p><b>Name:</b> <%= user.getName() %></p>
    <p><b>Email:</b> <%= user.getEmail() %></p>
    <p><b>Phone:</b> <%= user.getPhone() %></p>

    <!-- Later you can add EDIT PROFILE -->
</div>

<a href="HomeServlet" class="back-btn">Back to Home</a>

</body>
</html>

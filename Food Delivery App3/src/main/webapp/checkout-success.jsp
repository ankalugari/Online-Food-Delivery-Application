<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>

<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background: #f4f4f4;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

/* Success Card */
.box {
    max-width: 480px;
    width: 100%;
    background: #ffffff;
    padding: 30px;
    border-radius: 10px;
    text-align: center;
    box-shadow: 0 6px 18px rgba(0,0,0,0.12);
}

.box h2 {
    color: #28a745;
    margin-bottom: 18px;
}

.box p {
    margin: 8px 0;
    color: #555;
    font-size: 15px;
}

.box b {
    color: #333;
}

/* Bottom Button Section */
.bottom-actions {
    margin-top: 25px;
}

.home-btn {
    display: inline-block;
    padding: 12px 22px;
    background: #ff7a00;
    color: #fff;
    text-decoration: none;
    border-radius: 6px;
    font-size: 15px;
    font-weight: bold;
    transition: background 0.3s, transform 0.2s;
}

.home-btn:hover {
    background: #e66a00;
    transform: translateY(-2px);
}
</style>
</head>

<body>

    <!-- SUCCESS CARD -->
    <div class="box">
        <h2>🎉 Order Placed Successfully!</h2>

        <p><b>Order ID:</b> <%= request.getAttribute("orderId") %></p>

        <p><b>Delivery Address:</b></p>
        <p><%= request.getAttribute("orderAddress") %></p>

        <p><b>Payment Method:</b>
           <%= request.getAttribute("paymentMethod") %></p>

        <p><b>Total Amount:</b> ₹
           <%= request.getAttribute("orderTotal") %></p>
    </div>

    <!-- BACK TO HOME BUTTON -->
    <div class="bottom-actions">
        <a href="HomeServlet" class="home-btn">⬅ Back to Home</a>
    </div>

</body>
</html>

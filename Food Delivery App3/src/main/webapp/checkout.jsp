<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: #f4f4f4;
    padding: 40px;
}

.container {
    max-width: 500px;
    margin: auto;
    background: #ffffff;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}

h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
}

label {
    display: block;
    margin-top: 15px;
    font-weight: bold;
    color: #444;
}

textarea, select {
    width: 100%;
    padding: 10px;
    margin-top: 6px;
    border-radius: 5px;
    border: 1px solid #ccc;
    font-size: 14px;
}

textarea {
    resize: none;
}

input[type="submit"] {
    width: 100%;
    margin-top: 25px;
    padding: 12px;
    background-color: #28a745;
    color: #fff;
    font-size: 16px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #218838;
}
</style>
</head>

<body>
<!-- ✅ NAVBAR COMES FROM HERE -->
   <jsp:include page="header.jsp" />
<br>
<div class="container">
    <h2>Checkout</h2>

    <form action="checkout" method="post">

        <!-- Delivery Address -->
        <label for="address">Delivery Address</label>
        <textarea id="address"
                  name="address"
                  rows="4"
                  required></textarea>

        <!-- Payment Method -->
        <label for="paymentMethod">Payment Method</label>
        <select id="paymentMethod"
                name="paymentMethod"
                required>
            <option value="">-- Select Payment Method --</option>
            <option value="Credit Card">Credit Card</option>
            <option value="Debit Card">Debit Card</option>
            <option value="Cash on Delivery">Cash on Delivery</option>
        </select>

        <!-- Place Order -->
        <input type="submit" value="Place Order">

    </form>
</div>

</body>
</html>

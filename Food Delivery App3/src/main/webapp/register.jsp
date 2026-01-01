<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: "Segoe UI", Arial, Helvetica, sans-serif;
    background: linear-gradient(135deg, #ff7a00, #ffb347);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* ================= REGISTER BOX ================= */
.register-box {
    background: #ffffff;
    width: 400px;
    padding: 35px;
    border-radius: 14px;
    box-shadow: 0 12px 30px rgba(0,0,0,0.25);
    animation: fadeIn 0.6s ease-in-out;
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

.register-box h2 {
    text-align: center;
    margin-bottom: 25px;
    color: #ff7a00;
    font-size: 26px;
    font-weight: bold;
}

/* ================= LABELS ================= */
.register-box label {
    display: block;
    margin-top: 14px;
    font-weight: 600;
    color: #555;
    font-size: 14px;
}

/* ================= INPUTS ================= */
.register-box input {
    width: 100%;
    padding: 11px 12px;
    margin-top: 6px;
    border-radius: 8px;
    border: 1px solid #ddd;
    font-size: 14px;
    transition: all 0.3s ease;
}

.register-box input:focus {
    outline: none;
    border-color: #ff7a00;
    box-shadow: 0 0 0 3px rgba(255,122,0,0.15);
}

/* ================= BUTTON ================= */
.register-box button {
    width: 100%;
    margin-top: 25px;
    padding: 13px;
    background: linear-gradient(90deg, #ff7a00, #ff9f1c);
    border: none;
    color: #ffffff;
    font-size: 16px;
    font-weight: bold;
    border-radius: 25px;
    cursor: pointer;
    transition: all 0.3s ease;
}

.register-box button:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 15px rgba(255,122,0,0.4);
}

/* ================= LOGIN LINK ================= */
.login-link {
    text-align: center;
    margin-top: 18px;
    font-size: 14px;
    color: #555;
}

.login-link a {
    color: #ff7a00;
    font-weight: bold;
    text-decoration: none;
}

.login-link a:hover {
    text-decoration: underline;
}
</style>
</head>

<body>

<div class="register-box">
    <h2>Create Account</h2>

    <form action="register" method="post">

        <label>Name</label>
        <input type="text" name="name" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <label>Phone</label>
        <input type="text" name="phone" required>

        <button type="submit">Register</button>
    </form>

    <div class="login-link">
        Already have an account?
        <a href="login.jsp">Login</a>
    </div>
</div>

</body>
</html>

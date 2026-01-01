<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Segoe UI", Arial, Helvetica, sans-serif;
}

body {
	background: linear-gradient(135deg, #ff7a00, #ffb347);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

/* ================= LOGIN BOX ================= */
.login-box {
	background: #ffffff;
	width: 380px;
	padding: 35px;
	border-radius: 14px;
	box-shadow: 0 12px 30px rgba(0, 0, 0, 0.25);
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

.login-box h2 {
	text-align: center;
	margin-bottom: 22px;
	color: #ff7a00;
	font-size: 28px;
	letter-spacing: 1px;
}

/* ================= FORM ================= */
.login-box label {
	display: block;
	margin-top: 14px;
	font-weight: bold;
	color: #555;
	font-size: 14px;
}

.login-box input {
	width: 100%;
	padding: 12px;
	margin-top: 8px;
	border-radius: 8px;
	border: 1px solid #ddd;
	font-size: 14px;
	transition: border-color 0.3s, box-shadow 0.3s;
}

.login-box input:focus {
	outline: none;
	border-color: #ff7a00;
	box-shadow: 0 0 8px rgba(255, 122, 0, 0.4);
}

/* ================= BUTTON ================= */
.login-box button {
	width: 100%;
	margin-top: 25px;
	padding: 14px;
	background: linear-gradient(135deg, #ff7a00, #ff9f1c);
	border: none;
	color: #ffffff;
	font-size: 16px;
	font-weight: bold;
	border-radius: 30px;
	cursor: pointer;
	transition: transform 0.3s, box-shadow 0.3s;
}

.login-box button:hover {
	transform: translateY(-2px);
	box-shadow: 0 8px 20px rgba(255, 122, 0, 0.5);
}

/* ================= LINKS ================= */
.register-link {
	text-align: center;
	margin-top: 20px;
	font-size: 14px;
	color: #555;
}

.register-link a {
	color: #ff7a00;
	font-weight: bold;
	text-decoration: none;
}

.register-link a:hover {
	text-decoration: underline;
}

/* ================= MESSAGES ================= */
.error {
	color: #e63946;
	text-align: center;
	margin-bottom: 12px;
	font-weight: bold;
}

.success {
	color: #2ecc71;
	text-align: center;
	margin-bottom: 12px;
	font-weight: bold;
}
</style>
</head>

<body>

	<div class="login-box">
		<h2>Login</h2>

		<%-- Optional error message --%>
		<%
        String error = request.getParameter("error");
        if ("true".equals(error)) {
    %>
		<div class="error">Invalid email or password</div>
		<%
        }
    %>

		<%
    String registered = request.getParameter("registered");
    if ("true".equals(registered)) {
%>
		<h2 style="color: #2ecc71; text-align: center;">Registration Successfully...</h2>
		<%
    }
%>

		<form action="login" method="post">

			<label>Email</label>
			<input type="email" name="email" required>

			<label>Password</label>
			<input type="password" name="password" required>

			<button type="submit">Login</button>
		</form>

		<div class="register-link">
			New user? <a href="register.jsp">Create account</a>
		</div>
	</div>

</body>
</html>

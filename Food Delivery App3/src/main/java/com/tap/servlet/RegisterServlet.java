package com.tap.servlet;

import java.io.IOException;

import com.tap.dao.UserDao;
import com.tap.daoImpl.UserDaoImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1️⃣ Read form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        // 2️⃣ Create User object
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        // 3️⃣ Call DAO
        UserDao userDao = new UserDaoImpl();
        boolean isRegistered = userDao.registerUser(user);

        // 4️⃣ Redirect based on result
        if (isRegistered) {
        	// After successful registration
        	resp.sendRedirect("login.jsp?registered=true");
        } else {
            resp.sendRedirect("register.jsp");
        }
    }
}
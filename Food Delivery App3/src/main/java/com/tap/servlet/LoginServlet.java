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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1️⃣ Read login credentials
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // 2️⃣ Call DAO
        UserDao userDao = new UserDaoImpl();
        User user = userDao.loginUser(email, password);

        // 3️⃣ Validate login
        if (user != null) {

            // Login success → store user in session
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user);

            // Redirect to home / restaurants page
            resp.sendRedirect("HomeServlet");

        } else {
            // Login failed
            resp.sendRedirect("login.jsp?error=true");
        }
    }
}
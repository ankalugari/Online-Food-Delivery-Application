package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.daoImpl.MenuDaoImpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest r, HttpServletResponse resp) throws ServletException, IOException {
		MenuDaoImpl listofmenu = new MenuDaoImpl();
		int restaurantId = Integer.parseInt(r.getParameter("restaurantId"));
		List<Menu> menuByRestaurantId = listofmenu.getMenuByRestaurantId(restaurantId);
		
		r.setAttribute("menuByRestaurantId", menuByRestaurantId);
		RequestDispatcher rd=r.getRequestDispatcher("menu.jsp");
		rd.forward(r, resp);
	
	}

}
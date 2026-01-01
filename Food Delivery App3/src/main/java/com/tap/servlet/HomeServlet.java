package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.daoImpl.RestaurantDaoImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDaoImpl impl=new RestaurantDaoImpl();
		List<Restaurant> listofrestaurants = impl.getAllRestaurants();
		req.setAttribute("listofrestaurants", listofrestaurants);
		RequestDispatcher rq = req.getRequestDispatcher("home.jsp");
		rq.forward(req, resp);
	}
	
	

}
package com.controller;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDao;

@WebServlet("/CheckOutController")
public class CheckOutController extends HttpServlet {

protected void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{
	
   HttpSession session =request.getSession();
   int userId=(Integer) session.getAttribute("userid");
   OrderDao orderDao =new OrderDao();
 orderDao.placeOrder(userId);
response.sendRedirect("OrderPlace.jsp");

}
}

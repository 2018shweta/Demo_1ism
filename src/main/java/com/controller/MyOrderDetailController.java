package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.OrderDetailProductBean;
import com.dao.OrderDetailDao;
@WebServlet("/MyOrderDetailController")
public class MyOrderDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderDetailDao dao = new OrderDetailDao();
		ArrayList<OrderDetailProductBean> details = dao.getOrderDetails(orderId);
		request.setAttribute("details",details);
		
		request.getRequestDispatcher("MyOrderDetails.jsp").forward(request, response);
	}
}
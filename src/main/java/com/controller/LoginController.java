package com.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet  {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		UserDao userDao = new UserDao();
		UserBean user = userDao.login(email, password);
		RequestDispatcher rd = null;
		if (user == null) {
			request.setAttribute("errorMsg", "Invalid credentials");
			rd = request.getRequestDispatcher("Login.jsp");

		} else {
			HttpSession session =request.getSession();
			session.setAttribute("userid", user.getUserId());
			//int userId=(Integer)session.getAttribute("userid");
			
			if (user.getUsertype().equals("customer")) {
				rd = request.getRequestDispatcher("Home.jsp");
			} else if (user.getUsertype().equals("admin")) {
				rd = request.getRequestDispatcher("Dashboard.jsp");
			} else {
				rd = request.getRequestDispatcher("404.jsp");
			}

		}

		//ArrayList<UserBean> users = userDao.getAllUsers();
		//request.setAttribute("usertable", users);
//
		//RequestDispatcher rd = request.getRequestDispatcher("ListUser.jsp");
		rd.forward(request, response);
	}
}

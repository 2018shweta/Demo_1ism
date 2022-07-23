package com.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet  {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String usertype = request.getParameter("usertype");
		
		System.out.println(firstName);
		System.out.println(email);
		boolean isError = false;

		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "<font color='red'>Please Enter FirstName</font>");
		} else {
			request.setAttribute("firstNameValue", firstName);
		}

		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		} else {
			request.setAttribute("emailValue", email);
		}
		
		
		
		if (password == null) {
			isError = true;
			request.setAttribute("passwordError", "Please Select Gender");
		} else {
			request.setAttribute("passwordValue", gender);
		}
		

		if (gender == null) {
			isError = true;
			request.setAttribute("genderError", "Please Select Gender");
		} else {
			request.setAttribute("genderValue", gender);
		}
		RequestDispatcher rd = null;
		if (isError == true) {
			// goback
			rd = request.getRequestDispatcher("SignUp.jsp");

		} else {
			// goahead
			// goto home.jsp
UserDao userDao = new UserDao();
			
			UserBean userBean = new UserBean();
			
			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);
			userBean.setUsertype("customer");
			
			
			userDao.insertUser(userBean);
			
			// goahead
			// goto home.jsp
			request.setAttribute("msg", "Signup done...");
			rd = request.getRequestDispatcher("Login.jsp");

		}
		rd.forward(request, response);
	
		//set your data for accessing in next resource 
		//request.setAttribute("firstName", firstName);
		//request.setAttribute("email", email);
		//request.setAttribute("gender", gender);
 
		//goto home.jsp
		//RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		////rd.forward(request, response);
		
		
		//System.out.println("hellow from SignupController.............");
	}
}

package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CartDao;
import com.dao.UserDao;
@WebServlet("/DeleteCartController")
public class DeleteCartController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
				int cartid=Integer.parseInt(request.getParameter("cartId"));
				System.out.println(cartid);
				CartDao cartDao=new CartDao();
				if(cartDao.deleteCart(cartid))
				{
					request.setAttribute("message", "user deleted successfully" );
				}
				else
				{
					request.setAttribute("message", "some error in dao ");
				}
				request.getRequestDispatcher("ViewCartController").forward(request, response);
			}
}

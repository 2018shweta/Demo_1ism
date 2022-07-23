package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dao.UserDao;

public class SignupFilter implements Filter{
	
     @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    		throws IOException, ServletException {
    	// TODO Auto-generated method stub
    	System.out.println("doFilter of servlet called...........");
    	 
//    	 String firstName = request.getParameter("firstName");
// 		String lastName = request.getParameter("lastName");
 		String gmail = request.getParameter("gmail");
 		String queans = request.getParameter("queans");
		/*
		 * String password = request.getParameter("password"); String gender =
		 * request.getParameter("gender"); String usertype =
		 * request.getParameter("usertype");
		 */
boolean isError=false;
if (gmail == null || gmail.trim().length() == 0) {
	isError = true;
	request.setAttribute("gmailError", "Please Enter FirstName filter");
}	
if (queans == null || queans.trim().length() == 0) {
	isError = true;
	request.setAttribute("queansError", "Please Enter FirstName filter");
}
UserDao userDao = new UserDao();

if(userDao.duplicate(gmail,queans)==false)
{   isError=true;
	request.setAttribute("duplicatError", "not duplicate accepted");
	}

	if (isError) 
     {
			request.getRequestDispatcher("Forgetpassword.jsp").forward(request, response);
		} else {

			
			
			// go ahead
			chain.doFilter(request, response);
			}//servlet -- second filter 
		}
     

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}

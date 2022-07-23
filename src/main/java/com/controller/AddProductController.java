package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

public class AddProductController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));

		ProductBean product = new ProductBean();
		product.setProductName(name);
		product.setProductPrice(price);
		product.setProductQty(qty);
		product.setProductImgUrl(
				"https://www.freepnglogos.com/uploads/notebook-png/download-laptop-notebook-png-image-png-image-pngimg-2.png");
	
		ProductDao productDao  = new ProductDao();
		 productDao.addProduct(product);
		
		response.sendRedirect("GetProductController");
		
	}
}
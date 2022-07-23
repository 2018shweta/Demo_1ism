package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.OrderDetailBean;
import com.bean.OrderDetailProductBean;
import com.util.DbConnection;

public class OrderDetailDao {

	public void addOrderDetail(OrderDetailBean orderDetailBean) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("insert into orderdetails (orderid,productid,price) values (?,?,?)");
			pstmt.setInt(1, orderDetailBean.getOrderId());
			pstmt.setInt(2, orderDetailBean.getProductId());
			pstmt.setInt(3, orderDetailBean.getPrice());

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW OrderDetailDao :: addOrderDetail()");
			e.printStackTrace();
		}
	}

	public ArrayList<OrderDetailProductBean> getOrderDetails(int orderId) {
		ArrayList<OrderDetailProductBean> details = new ArrayList<OrderDetailProductBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select p.productimgurl,p.productname,od.orderdetalid,od.orderid,od.price,p.productid from orderdetails od , products p where p.productid = od.productid and od.orderid = ? ");
			pstmt.setInt(1, orderId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDetailProductBean bean = new OrderDetailProductBean();
				bean.setImgUrl(rs.getString("productimgurl"));
				bean.setName(rs.getString("productname"));
				bean.setOrderDetailId(rs.getInt("orderdetalid"));
				bean.setOrderId(rs.getInt("orderid"));
				bean.setPrice(rs.getInt("price"));
				bean.setProductId(rs.getInt("productid"));
					System.out.println(bean);
				details.add(bean);
			}
		} catch (Exception e) {
			System.out.println("SMW OrderDetailDao :: getOrderDetails()");
			e.printStackTrace();
		}
		return details;
	}
}
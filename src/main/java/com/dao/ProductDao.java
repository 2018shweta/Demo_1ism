
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.ProductBean;
import com.util.DbConnection;

public class ProductDao {

		public ArrayList<ProductBean> getAllProduct()
		{
			ArrayList<ProductBean> products= new ArrayList<>();
		
		try{
			Connection con=DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from products");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ProductBean p =new ProductBean();
				p.setProductId(rs.getInt("productid"));
				p.setProductPrice(rs.getInt("productprice"));
				p.setProductName(rs.getString("productname"));
				p.setProductQty(rs.getInt("productqty"));
				p.setProductImgUrl(rs.getString("productimgurl"));
				products.add(p);
				System.out.println(p);
			}
		}
		catch(Exception e)
		{
			System.out.println("Smw in ProductDao::getAllProduct()");
			e.printStackTrace();
		}
		return products;
		}
		public void addProduct(ProductBean product) {
			try {
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into products (productname,productprice,productqty) values (?,?,?) ");
				pstmt.setString(1, product.getProductName());
				pstmt.setInt(2, product.getProductPrice());
				pstmt.setInt(3, product.getProductQty());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

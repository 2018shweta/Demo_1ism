package com.dao;


import com.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
public class UserDao {
	
	public UserBean getUserByUserID(int userId) {
		UserBean user = null;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement psmt = con.prepareStatement("select * from usertable where userid=?");
				){
			psmt.setInt(1, userId);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				user= new UserBean();
				user.setEmail(rs.getString("email"));
					user.setFirstName(rs.getString("firstname"));
					user.setLastName(rs.getString("lastname"));
					user.setGender(rs.getString("gender"));
					user.setPassword(rs.getString("password"));
					user.setUserId(userId);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean updateUser(UserBean user) {
		boolean flag = false;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement psmt = con.prepareStatement("update usertable set firstname = ?, lastname=?,gender=?,password=? where userid=?");
			)
		{
			psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getGender());
			psmt.setString(4, user.getPassword());
			psmt.setInt(5, user.getUserId());
			int updateCount = psmt.executeUpdate();
			if(updateCount == 1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean deleteUser(int userid)
	{
		boolean flag=false;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement psmt = con.prepareStatement("delete from usertable where userid = ?");
		   ){
			psmt.setInt(1,userid);
			int deleteRows=psmt.executeUpdate();
			if(deleteRows==1) {
				flag=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public UserBean login(String email, String password) {
		UserBean user = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from usertable where email = ? and password = ? ");
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			// read select
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setUsertype(rs.getString("usertype"));
				//

			}

		} catch (Exception e) {
			System.out.println("SMW in login Dao ");
			e.printStackTrace();
		}

		return user;
	}
	public Boolean duplicate(String gmail,String  queans){
		
		try {
			Connection con =DbConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from usertable where gmail=? and password=?");
			pstmt.setString(1, gmail);
			pstmt.setString(2, queans);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("SMW in duplicate method Dao ");
			e.printStackTrace();
		}
		
		
		return false;
		
	}

	public void insertUser(UserBean userBean) {

		try {
			Connection con = DbConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into usertable (firstname,lastname,email,password,gender,usertype) values (?,?,?,?,?,'customer')");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
		

			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			System.out.println("SMW in insertUser() ");
			e.printStackTrace();
		}

	}
	
	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from usertable");

			ResultSet rs = pstmt.executeQuery();// select readonly ==>query

			while (rs.next() == true) { // 1st row 2nd row
				int userId = rs.getInt("userid");// db column name
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");

				UserBean user = new UserBean();
				user.setUserId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);
				users.add(user);
			}
			// go to line num -> 63

			// user1
			// user2

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
			e.printStackTrace();
		}

		return users;
	}
}
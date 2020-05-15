/*ClassName:- DBUtil.java
 *This is util class for establishing mysql database connection */
package com.jcg.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jcg.dao.DBConnection;
import com.jcg.model.User;

	public class DBUtil {
		DBConnection mysqldb=new DBConnection();
/*		public Connection getDBConnection()
		{
			Connection conn = null;
			   try{
			      Class.forName("com.mysql.jdbc.Driver");
			      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_mvc", "root", "root");
			      System.out.println("Connected database successfully...");
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }
			   return conn;
			}*/
		
		 public String getUserRole(String user) {
			 String role=null;
			 Connection conn=null;
			 Statement stmt=null;
			 try {
			 conn=mysqldb.getDBConnection();
			 stmt = conn.createStatement();
			 String sql = "SELECT role from users where username="+'"'+user+'"';
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	 role = rs.getString("role");
		      }
			 }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }finally{
			      
			      try{
			         if(conn!=null || stmt!=null)
			        	 stmt.close();
			         		conn.close();
			         
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			
		   return role;
		}
		 
		 
		 public int insertuser(User user)
		 {
			 int res=0;
			 Connection conn=null;
			 PreparedStatement ps=null;
			 try {
				 conn=mysqldb.getDBConnection();
			 String query = "insert into users(username,password,firstname,lastname,email,address,phone,role) values(?,?,?,?,?,?,?,?)";
			 ps = conn.prepareStatement(query);
			 
			 ps.setString(1, user.getUsername());
			 ps.setString(2, user.getPassword());
			 ps.setString(3, user.getFirstname());
			 ps.setString(4, user.getLastname());
			 ps.setString(5, user.getEmail());
			 ps.setString(6, user.getAddress());
			 ps.setInt(7, user.getPhone());
			 ps.setString(8, user.getRole());
			 
			res=ps.executeUpdate();
			 }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }finally{
			      
			      try{
			         if(conn!=null || ps!=null)
			        	 ps.close();
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			
		   System.out.println("Returning role from DB:-"+res);
		   return res; 
		 }
		 
		public  List<User> fetchUserList() 
		{
			Connection conn=null;
			Statement stm=null;
			ResultSet rs=null;
			List<User> userlist=new ArrayList<User>();
				 try{
				      Class.forName("com.mysql.cj.jdbc.Driver");
				      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_mvc", "root", "root");
				      System.out.println("Connected database successfully...");
				     stm=conn.createStatement();
	         rs = stm.executeQuery("SELECT username,email,address,phone FROM users");
	        while (rs.next()) {
	            User user = new User();
	            user.setUsername(rs.getString(1));
	            user.setEmail(rs.getString(2));
	            user.setAddress(rs.getString(3));
	            user.setPhone(rs.getInt(4));
	            userlist.add(user);
	        }
				 }catch(SQLException se){
				      se.printStackTrace();
				   }catch(Exception e){
				      e.printStackTrace();
				   }
			finally{
			      
			      try{
			         if(conn!=null || stm!=null )
			        	// rs.close();
			        	 //stm.close();
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
	        System.out.println("list size"+userlist.size());
	            return userlist;
	        }
		}


	

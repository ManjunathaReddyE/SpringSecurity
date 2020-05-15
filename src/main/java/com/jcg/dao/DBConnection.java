/*ClassName:- DBUtil.java
 *This is util class for establishing mysql database connection */
package com.jcg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jcg.model.User;

	public class DBConnection {
		
		
		public Connection getDBConnection()
		{
			Connection conn = null;
			   try{
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_mvc", "root", "root");
			      System.out.println("Connected database successfully...");
			   }catch(SQLException se){
			      se.printStackTrace();
			   }catch(Exception e){
			      e.printStackTrace();
			   }
			   return conn;
			}
		
		
		}


	

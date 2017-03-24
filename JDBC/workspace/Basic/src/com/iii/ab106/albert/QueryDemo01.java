package com.iii.ab106.albert;

import java.sql.*;

public class QueryDemo01 {

	public static void main(String[] args) {
		String urlString = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		
		try(Connection conn= DriverManager.getConnection(urlString,"root","qwert");) {
			String qs1= "select * from employee";
			PreparedStatement pst = conn.prepareStatement(qs1);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
			
				System.out.println("empno "+ rs.getString(1)
									+" ename: " +rs.getString(2)
									+" hirtedate: "+rs.getString(3));
				
			}
			while(rs.next()){
				System.out.println("name="+rs.getString("ename")+",");
				System.out.println("salary"+rs.getDouble("salary"));
			}
			
			
			
		} catch (Exception e) {
		}
		
		

	}

}

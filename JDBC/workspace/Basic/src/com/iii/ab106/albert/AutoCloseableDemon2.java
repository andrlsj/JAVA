package com.iii.ab106.albert;

import java.sql.*;



public class AutoCloseableDemon2 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		try(Connection conn = DriverManager.getConnection(url, "root", "qwert");) {
			String qryStmt = "Select ename, salary from employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println("name:"+rs.getString(1)+",");
				System.out.println("salary:"+rs.getDouble(2));
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	}

}

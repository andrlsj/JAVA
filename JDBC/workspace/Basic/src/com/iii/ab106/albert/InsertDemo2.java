package com.iii.ab106.albert;

import java.sql.*;

public class InsertDemo2 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		try(Connection conn = DriverManager.getConnection(url,"root","qwert");) {
//			String stmt = "insert into employee values(?,?,?,?,?,?)";
//			PreparedStatement pstmt = conn.prepareStatement(stmt);
//			pstmt.setInt(1,	1010);
//			pstmt.setString(2, "monkey");
//			pstmt.setString(3, "2015/10/15");
//			pstmt.setDouble(4, 55222);
//			pstmt.setInt(5, 100);
//			pstmt.setString(6, "staff");			
//			int num = pstmt.executeUpdate();
			
			
			String qs1 = "select * from employee";
			PreparedStatement pstmt = conn.prepareStatement(qs1);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("name="+rs.getString("ename")+",");
				System.out.println("salary"+rs.getDouble("salary"));
			}
			
			System.out.println("=================");
			
			String qs2 = "select * from employee where salary>5000";
			pstmt = conn.prepareStatement(qs2);
			
			ResultSet rs1 = pstmt.executeQuery();
			
			while(rs1.next()){
				System.out.println("ename "+rs1.getString(2)+" salary: "+rs1.getDouble(5));
				
			}
			System.out.println("================= ");
			
			
			
			
		} catch (Exception e) {
			e.getMessage();
		
		
		
		}
		
		
		
		
		
	}

}

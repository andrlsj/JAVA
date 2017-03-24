package com.iii.ab106.albert;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Insert one employee
public class InsertDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		 Calendar rightNow = Calendar.getInstance();
		 java.util.Date nowday = new java.util.Date();
		 java.sql.Date sqlday = new java.sql.Date(System.currentTimeMillis());//@@
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");		 
		
		 
		 
		try {     
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "qwert");
			
//			#0
//			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
//			PreparedStatement pstmt = conn.prepareStatement(insStmt);
//			pstmt.setInt(1, 1009);
//			pstmt.setString(2, "Jean Tsao");         			
//			pstmt.setDouble(4, 55000);
//			pstmt.setInt(5, 100);
//			pstmt.setString(6, "senior engineer");
			//#1
//			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
//			PreparedStatement pstmt = conn.prepareStatement(insStmt);
//			pstmt.setInt(1, 1009);
//			pstmt.setString(2, "Jean Tsao");
//			pstmt.setString(3, sdf.format(nowday)); //使用SimpleDateFormat (類)
//			pstmt.setDouble(4, 55000);
//			pstmt.setInt(5, 100);
//			pstmt.setString(6, "senior engineer");
//			//#2
//			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
//			PreparedStatement pstmt = conn.prepareStatement(insStmt);
//			pstmt.setInt(1, 1009);
//			pstmt.setString(2, "Jean Tsao");
//			pstmt.setDate(3, sqlday); //使用System.currentTimeMillis (Long) ->java.sql.Date() (類)
//			pstmt.setDouble(4, 55000);
//			pstmt.setInt(5, 100);
//			pstmt.setString(6, "senior engineer");
			//#3
//			int year = rightNow.get(Calendar.YEAR); //Calendar (界面) getInstance()
//			int mm = rightNow.get(Calendar.MONTH)+1;
//			int dd = rightNow.get(Calendar.DATE);
//				
//			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
//			PreparedStatement pstmt = conn.prepareStatement(insStmt);
//			pstmt.setInt(1, 1009);
//			pstmt.setString(2, "Jean Tsao");
//			pstmt.setString(3, year+"//"+mm+"//"+dd);
//			pstmt.setDouble(4, 55000);
//			pstmt.setInt(5, 100);
//			pstmt.setString(6, "senior engineer");
			
			//#4
			//使用  java.time.LocalDate的靜態(類方法)now()
//			java.time.LocalDate jday = java.time.LocalDate.now();
//			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			
//			PreparedStatement pstmt = conn.prepareStatement(insStmt);
//			pstmt.setInt(1, 1009);
//			pstmt.setString(2, "Jean Tsao");
//			pstmt.setString(3, jday.toString());
//			pstmt.setDouble(4, 55000);
//			pstmt.setInt(5, 100);
//			pstmt.setString(6, "senior engineer");
			
			//#5
			String insStmt = "INSERT INTO employee VALUES (?, ?, curdate(), ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setInt(1, 1009);
			pstmt.setString(2, "Jean Tsao");

			pstmt.setDouble(3, 55000);
			pstmt.setInt(4, 100);
			pstmt.setString(5, "senior engineer");
			
			int num = pstmt.executeUpdate();
			System.out.println("insert count = " + num);
			
			pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("time= "+rs.getString(3)+ ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class InsertDemo

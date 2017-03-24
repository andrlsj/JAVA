package iii.ab106;

import java.io.*;
import java.sql.*;

public class ResultSetMetaDataDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "qwert");
			
			String qryStmt = "SELECT * FROM department";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			System.out.println(count);
			for(int i = 1; i <= count; i++) {
				System.out.print(rsmd.getColumnLabel(i) + "(" + rsmd.getColumnType(i) + ", "
					+ rsmd.getColumnTypeName(i)+"), ");
			}
			System.out.print("\n");
			
			
				
			//FileOutputStream fos = new FileOutputStream("E:\\JDBC\\workspace\\Advance\\res\\data.txt");
				
			FileWriter fw = new FileWriter("E:\\JDBC\\workspace\\Advance\\res\\data1.txt");
			
			while(rs.next()) {
				
	     		for(int i = 1; i <= count; i++)
	     		{
	         		//System.out.print(rs.getString(i) + ", ");
	     			
	         		fw.write(rs.getString(i));
	     		}
	     		System.out.print("\n");
	     		
			}
			
			
			fw.close();
			
		} catch (Exception e) {
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
}// end of class ResultSetMetaDataDemo 

package iii.ab106;

import java.sql.*;

import com.sun.glass.ui.CommonDialogs.Type;

public class StoredProcessSelect {
	public static void main(String[] args) {
		String urlString = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		
		try(Connection conn = DriverManager.getConnection(urlString,"root","qwert")) {
														//select empno from employee where deptno = 100 
			CallableStatement cstmt = conn.prepareCall("{call qry_test(?,?)}");
			cstmt.setInt(1, 100);
			
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			
			int empno = cstmt.getInt(2); 
			System.out.println("===");
			System.out.println(empno);
			
		
			
			
			
			
		} catch (Exception e) {
			
			
		}
		
		
		
		
	}
}

package iii.ab106;

import java.sql.*;

import com.sun.glass.ui.CommonDialogs.Type;

public class StoreTest01 {

	public static void main(String[] args) {
		String urlString = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		try (Connection conn = DriverManager.getConnection(urlString,"root","qwert");){
			
			String qrs = "select ename ,sal from employee";
			CallableStatement cstmt = conn.prepareCall("{call upd_emp_salary(?,?)}");
			
			cstmt.setDouble(1, 44000);
			cstmt.setInt(2, 1002);
			cstmt.executeQuery();
			
			cstmt = conn.prepareCall("{call qry_emp(?,?,?)}");
			cstmt.setInt(1, 1002);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.DOUBLE);
			cstmt.execute();
			String ename = cstmt.getString(2);
			double salary = cstmt.getDouble(3);
			System.out.print("name = " + ename + ", ");
			System.out.println("salary = " + salary);
			
		} catch (Exception e) {
		}
		
		
	}

}

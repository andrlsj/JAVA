package iii.ab106;

import java.sql.*;

public class JDBC_Hw01 {

	public static void main(String[] args) {
		//1.	設定一個整數batch size，用以分批處理批次作業。
		String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		try (Connection conn = DriverManager.getConnection(url,"root","qwert")){
			
			
			String qrs = "select empno,salary from employee";
			PreparedStatement pstmt = conn.prepareStatement(qrs);
			ResultSet rs = pstmt.executeQuery();
			
			String qus = "update employee set salary = ? where empno =?";
			pstmt = conn.prepareStatement(qus);
			int count = 0;
			
				while(rs.next()){
											 
						pstmt.setDouble(1, rs.getDouble(2) * 1.1);
						pstmt.setInt(2, rs.getInt(1));						
						pstmt.addBatch();//加入批次執行集合中count
						count +=1;
						
						if(count==3){
						pstmt.executeBatch();
						System.out.println("======");
						count =0;
						}
								
				}
					
		} catch (Exception e) {
			System.err.println(e.getMessage());
		
		}
		
		
		
	}

}

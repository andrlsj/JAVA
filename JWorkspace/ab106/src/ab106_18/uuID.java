package ab106_18;

import java.sql.*;
import java.util.UUID;

public class uuID {

	public static void main(String[] args) {
		
		Connection conn = null;
		try { 
		String connUrl = "jdbc:mysql://10.120.28.52:3306/ab106";
		conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
		
		for(int i=1; i<2000000; i++){
			for(int j=1; j<((int)(Math.random()*5)+1); j++){
				
				UUID uuid  =  UUID.randomUUID();
				String randomUUIDString = uuid.toString();
				
				String insStmt = "INSERT INTO original(col, row, uuid, date) VALUES(?, ?, ?, now())";
				PreparedStatement pstmt = conn.prepareStatement(insStmt);
				
					pstmt.setInt(1, i);
					pstmt.setInt(2, j);
					pstmt.setString(3, randomUUIDString);
					pstmt.executeUpdate();
					
					System.out.println(i +" "+j+" "+randomUUIDString);
			}
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}



package iii.ab106;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;

public class BlobTest01 {

	public static void main(String[] args) {
		
		String inFile = args[0];
		String outFile = args[1];
		
		
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		try (Connection conn = DriverManager.getConnection(connUrl,"root","qwert");){
			
			String qryStmt = "SELECT photo FROM blobtest WHERE name = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			pstmt.setString(1, inFile);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				String deleteStmt = "DELETE FROM blobtest WHERE name = ?"; 
				pstmt = conn.prepareStatement(deleteStmt);
				pstmt.setString(1, inFile);
				pstmt.executeUpdate();
				System.out.println("Delete blob is successful!");
				
			}
			
			File f = new File(inFile);
			FileInputStream fis = new FileInputStream(f);
			String insertStmt = "INSERT INTO blobtest VALUES(?,?)";	
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setString(1, inFile);
			pstmt.setBinaryStream(2, fis,f.length());
			pstmt.executeUpdate();
			System.out.println("Insert blob is successful!");
			
			pstmt = conn.prepareStatement(qryStmt);
			pstmt.setString(1, args[0]);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Blob b = rs.getBlob("photo");
				byte[] data = b.getBytes(1,(int)b.length());
				FileOutputStream fos = new FileOutputStream(outFile);
				fos.write(data,0,(int)b.length());
				fos.close();
				
				
				
				
				
			}
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}

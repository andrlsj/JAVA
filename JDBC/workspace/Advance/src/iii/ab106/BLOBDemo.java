package iii.ab106;

import java.sql.*;
import java.io.*;

public class BLOBDemo {
	public static void main(String[] args) {
		Connection conn = null;
		String inFile = args[0];//from //file path //res//Tomcat.gif
		String outFile = args[1];//where //
		try {     
			String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
			conn = DriverManager.getConnection(connUrl, "root", "qwert");
			
			String qryStmt = "SELECT photo FROM blobtest WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, inFile);
			ResultSet rs = stmt.executeQuery();
			
			//check the file existed or not
			if (rs.next()) {//single time just take the result of rs.next()
				String deleteStmt = "DELETE FROM blobtest WHERE name = ?"; 
				stmt = conn.prepareStatement(deleteStmt);
				stmt.setString(1, inFile);
				stmt.executeUpdate();
				System.out.println("Delete blob is successful!");
			}
			
			//save file to DB
			File f = new File(inFile);
			FileInputStream fis = new FileInputStream(f);
			String insertStmt = "INSERT INTO blobtest VALUES(?,?)";		
			stmt = conn.prepareStatement(insertStmt);
			
			stmt.setString(1, inFile);//file object 
			stmt.setBinaryStream(2, fis, f.length());//second label column, file object,file size
			//file size must fit the target file
			stmt.executeUpdate();
			System.out.println("Insert blob is successful!");
	
			stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, args[0]);
			rs = stmt.executeQuery();
			
			//get file from DB and change file name
			if (rs.next()) {
				FileOutputStream fos = new FileOutputStream(outFile);//setup the output path
				Blob b = rs.getBlob("photo"); //use getBlob with the column name
				//java could not use blob so we use byte[]
				byte[] data = b.getBytes(1, (int)b.length()); //use getBytes //get from 1 to the end (file.size)
				fos.write(data, 0, (int)b.length());//write with byte[] from date[] 0 to end 
				fos.close(); //note close must be done or the result only in buffer
				System.out.println("File output is successful!");
			} // end of if (rs.next()) 
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
}// end of class BLOBDemo 

package iii.ab106;


import java.io.*;
import java.sql.*;


public class JDBC_HW03 {

	public static void main(String[] args) {
		//3.使用課堂的employee表格加以改寫，新增一個欄位可以存放員工的照片。
		//利用BlobDemo.java範例將所有圖檔以批次方式新增至資料庫中。
		//註：所有照片置於res資料夾中，為了方便撰寫程式，建議所有照片的副檔名要一致，圖檔名稱以員工編號命名
		
		String urlString = "jdbc:mysql://localhost:3306/jdbc?useSSL=false"; 
		try (Connection conn = DriverManager.getConnection(urlString,"root","qwert") ){
			
			//save pic file to DB (E:\JDBC\workspace\Advance\res\1001.GIF)
			String filePath = "E:\\JDBC\\workspace\\Advance\\res\\"; //
			String gif = ".gif";
			String uqs = "update employee set pic = ? where empno =?"; //
			
	//		FileInputStream fis = new FileInputStream(filePath);
			PreparedStatement st = conn.prepareStatement(uqs);
			
			
			//讀出圖片並存入DB
			int count = 0;
			for(int i =1001;i<=1006;i++){
				
				String path = filePath+i+gif; 
				System.out.println(path);
				count +=1;  
//				
				File f = new File(path.toString());
				FileInputStream fis = new FileInputStream(f);
//				
//				conn.prepareStatement(uqs);
//				st.setInt(1, i);
//				st.setBinaryStream(2,fis,f.length());
//				
//				st.executeUpdate();
				
				
			}
			
			System.out.println(count);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		

	}

}

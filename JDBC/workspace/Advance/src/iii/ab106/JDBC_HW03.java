package iii.ab106;


import java.io.*;
import java.sql.*;


public class JDBC_HW03 {

	public static void main(String[] args) {
		//3.�ϥνҰ�employee���[�H��g�A�s�W�@�����i�H�s����u���Ӥ��C
		//�Q��BlobDemo.java�d�ұN�Ҧ����ɥH�妸�覡�s�W�ܸ�Ʈw���C
		//���G�Ҧ��Ӥ��m��res��Ƨ����A���F��K���g�{���A��ĳ�Ҧ��Ӥ������ɦW�n�@�P�A���ɦW�٥H���u�s���R�W
		
		String urlString = "jdbc:mysql://localhost:3306/jdbc?useSSL=false"; 
		try (Connection conn = DriverManager.getConnection(urlString,"root","qwert") ){
			
			//save pic file to DB (E:\JDBC\workspace\Advance\res\1001.GIF)
			String filePath = "E:\\JDBC\\workspace\\Advance\\res\\"; //
			String gif = ".gif";
			String uqs = "update employee set pic = ? where empno =?"; //
			
	//		FileInputStream fis = new FileInputStream(filePath);
			PreparedStatement st = conn.prepareStatement(uqs);
			
			
			//Ū�X�Ϥ��æs�JDB
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

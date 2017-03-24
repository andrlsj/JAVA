package iii.ab106;

import java.io.*;
import java.sql.*;

public class JDBC_HW02 {

	public static void main(String[] args) {
		//2.在res/emp.txt文字檔中設定五筆employee的資料，將之批次新增至資料庫中。
		//註：一筆資料一列，每個資料欄的資料以逗號(,)隔開
		File f = new File("E:\\JDBC\\workspace\\Advance\\res\\newbie.txt");
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		
		try(Connection conn = DriverManager.getConnection(connUrl,"root","qwert")) {
			
			//抓CSV檔進java
			FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String strLine = null;
            
            //將CSV檔字串一列一列讀入並存起來直到沒有列為止
            while((strLine = br.readLine())!=null)
            {
            	//用split "," 切開存入字串陣列
				String[] array=strLine.split(",");
				//System.out.println(strLine);
			
				//偷看陣列沒有切對 OK
				for(int i=0;i<array.length;i++)
				{
					System.out.println(array[i]);
				}
				//動態SQL指令 	
				String qryInsert="insert into employee values(?,?,curdate(),?,?,?)";
						
				PreparedStatement pstmt= conn.prepareStatement(qryInsert);
				
				pstmt.setInt(1,Integer.valueOf(array[0]));
				pstmt.setString(2,array[1]);			
				//pstmt.setString(3,array[2]);			
				pstmt.setInt(3,Integer.valueOf(array[3]));
				pstmt.setString(4, array[4]);
				pstmt.setString(5, array[5]);
				
				pstmt.executeUpdate();
			}
			
			
			
		} catch (Exception e) {
			
			
		}
		
       
	
		
		

		
		
	}

}

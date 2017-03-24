package iii.ab106;

import java.io.*;
import java.sql.*;

public class JDBC_HW02 {

	public static void main(String[] args) {
		//2.�bres/emp.txt��r�ɤ��]�w����employee����ơA�N���妸�s�W�ܸ�Ʈw���C
		//���G�@����Ƥ@�C�A�C�Ӹ���檺��ƥH�r��(,)�j�}
		File f = new File("E:\\JDBC\\workspace\\Advance\\res\\newbie.txt");
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		
		try(Connection conn = DriverManager.getConnection(connUrl,"root","qwert")) {
			
			//��CSV�ɶijava
			FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String strLine = null;
            
            //�NCSV�ɦr��@�C�@�CŪ�J�æs�_�Ӫ���S���C����
            while((strLine = br.readLine())!=null)
            {
            	//��split "," ���}�s�J�r��}�C
				String[] array=strLine.split(",");
				//System.out.println(strLine);
			
				//���ݰ}�C�S������ OK
				for(int i=0;i<array.length;i++)
				{
					System.out.println(array[i]);
				}
				//�ʺASQL���O 	
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

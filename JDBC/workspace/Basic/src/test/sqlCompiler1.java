package test;

import java.util.ArrayList;
import java.util.*;

public class sqlCompiler1 {

	public static void main(String[] args) {
		
		String str =" select eMpnO ,     SaL fRom Emp "; //select emp empno sal
		System.out.println("��r��: "+str);
		//��e�� �ťեh�� ��
		String strTrim = str.trim();
		//�����p�g
		//String strL= strTrim.toLowerCase();
		//�h��,		
		String strNoComm = strTrim.replace(",", " "); 
		//System.out.println(strNoComm);
		
		//�H �ťդ� �Φ��r��}�C/�զX
		
		ArrayList<String> al = new ArrayList<>();
		
		 StringTokenizer stk = new StringTokenizer(strNoComm," ");
	        while (stk.hasMoreTokens()){
	            //System.out.print(stk.nextToken()+" ");  	            
	            al.add(stk.nextToken());        
	    }
			        
		//��Xfrom�Ǹ�X ��x+1 �æL�X �A���ۦL�X �Ĥ@�ӡA�ĤG�� ����X-1; 
		
		//1 check array
	   int fromIndex=0;
	        
	   for(int i=0;i<al.size();i++){
		   if((al.get(i).toLowerCase().equals("select"))){
			   System.out.println(al.get(i));
		   }
		   		   
		   if((al.get(i).toLowerCase().equals("from"))){
			   fromIndex=i;//3
			   System.out.println(al.get(fromIndex+1));  
			
			   for(int j=1;j<fromIndex;j++){
				   System.out.println(al.get(j));
			   }		   
			   
		   }
		   
	   }
		//#1 �L����ڮV��ť���U�h
//	   System.out.println("���G:"+"\n"+ al.get(0));
//	   System.out.println(al.get(fromIndex+1));
//	   System.out.println(al.get(1));
//	   System.out.println(al.get(2));
//	   

		   
		   
		   
		   
		   
	   }
	   
	   
		
	}



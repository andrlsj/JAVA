package test;

import java.util.*;

public class sqlCompiler {

	public static void main(String[] args) {
		
		String str =" select eMpnO ,  aa,   SaL fRom Emp where sal>300 "; 
		//
		System.out.println("��r�� : "+str);
		System.out.println("�p�e : "+"select emp empno sal sal>300");
		//��e�� �ťեh�� �i��
		//String strTrim = str.trim();
		//�����p�g �i��
		//String strL= strTrim.toLowerCase();
		//�h��,		
		String strNoComm = str.replace(",", " "); 
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
	   int fromIndex=0; //�аO�I
	   int whereIndex=0;     
	   for(int i=0;i<al.size();i++){
		   if(al.get(i).equals("from")){
			   fromIndex=i;
		   }
		   if(al.get(i).equals("where")){
			   whereIndex=i;
		   }
		   
	   }

	   //#2 �@���k
	   System.out.println("================================");
	   
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
		   
		   if(al.get(i).toLowerCase().equals("where")){
			   for(int j=whereIndex+1;j<al.size();j++){
				   
				   System.out.println(al.get(j));
			   }	
			   
		   }
		   
		   
		   
		   
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
		
	
	}
}

package test;

import java.util.*;

public class sqlCompiler {

	public static void main(String[] args) {
		
		String str =" select eMpnO ,  aa,   SaL fRom Emp where sal>300 "; 
		//
		System.out.println("原字串 : "+str);
		System.out.println("計畫 : "+"select emp empno sal sal>300");
		//把前後 空白去掉 可略
		//String strTrim = str.trim();
		//全部小寫 可略
		//String strL= strTrim.toLowerCase();
		//去掉,		
		String strNoComm = str.replace(",", " "); 
		//System.out.println(strNoComm);
		
		//以 空白切 割成字串陣列/組合		
		ArrayList<String> al = new ArrayList<>();
		
		 StringTokenizer stk = new StringTokenizer(strNoComm," ");
	        while (stk.hasMoreTokens()){
	            //System.out.print(stk.nextToken()+" ");  	            
	            al.add(stk.nextToken());        
	    }
			        
		//找出from序號X 並x+1 並印出 ，接著印出 第一個，第二個 直到X-1; 
		
		//1 check array
	   int fromIndex=0; //標記點
	   int whereIndex=0;     
	   for(int i=0;i<al.size();i++){
		   if(al.get(i).equals("from")){
			   fromIndex=i;
		   }
		   if(al.get(i).equals("where")){
			   whereIndex=i;
		   }
		   
	   }

	   //#2 一般方法
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

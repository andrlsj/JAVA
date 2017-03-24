package test;

import java.util.ArrayList;
import java.util.*;

public class sqlCompiler1 {

	public static void main(String[] args) {
		
		String str =" select eMpnO ,     SaL fRom Emp "; //select emp empno sal
		System.out.println("原字串: "+str);
		//把前後 空白去掉 略
		String strTrim = str.trim();
		//全部小寫
		//String strL= strTrim.toLowerCase();
		//去掉,		
		String strNoComm = strTrim.replace(",", " "); 
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
		//#1 無恥到芳姬都聽不下去
//	   System.out.println("結果:"+"\n"+ al.get(0));
//	   System.out.println(al.get(fromIndex+1));
//	   System.out.println(al.get(1));
//	   System.out.println(al.get(2));
//	   

		   
		   
		   
		   
		   
	   }
	   
	   
		
	}



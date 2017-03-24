package com.cymmetrik.webservices.hr;





import java.util.Calendar;
import java.util.Date;
import java.text.*;

public class test2 {
	public static void main(String[] args)
	{
		String str= "0123456789";
		String[] strs = str.split(",");
		System.out.println(strs[0]);
		System.out.println(str.substring(3,str.length()));
		System.out.println(Calendar.getInstance().get(Calendar.MONTH));
	
		System.out.println(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()));
		
		Date now = new Date();
		long a= Math.abs(now.getTime() - now.getTime())/1000;
		System.out.println(a);
	}

}

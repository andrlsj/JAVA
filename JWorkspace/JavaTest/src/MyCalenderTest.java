import java.util.Calendar;
import java.util.Date;

public class MyCalenderTest {


	public static void main(String[] args) {
		  
		Date d1 = new Date();
		Date d2 = new Date(123456);
		System.out.println("now"+ d1 + " // 123456 :" + d2);
		
		Calendar c1 = Calendar.getInstance();//抽象類 不能用構造器創建類的對象 改用getInstance =>c
		Date d3 = c1.getTime();
		System.out.println(d3);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d3);
		System.out.print(c2);
		
		//Date date1 = c.get(YEAR); 
		
		c1.set(2018, 10, 5, 12, 25);//注意:月份從"0"起始
		
		System.out.println("\n" + c1.getTime());
		
		//c.add(YEAR,-1);
		
		
		
	}
	
	
}

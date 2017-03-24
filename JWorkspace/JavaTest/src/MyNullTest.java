import java.util.Date;

public class MyNullTest {

	public static void main(String[] args){
		
		Date d = null;
		
		try{
			
		System.out.println(d.after(new Date()));	
			
		}catch(NullPointerException ne){
			
		System.out.println("空指針異常");
			
		}catch(Exception e){
			
			System.out.println("something wrong");
		}
		
	}
	
	
}

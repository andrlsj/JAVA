
public class MyMultiExceptionTest {
	
	public static void main(String[] args){
		
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			
			int c = a/b;
			System.out.println("c:" + c);
					
		}catch(IndexOutOfBoundsException|NumberFormatException|ArithmeticException ie){
			
			System.out.println("數組越界、數字格式異常、算數異常");
			//ie = new ArithmeticException("test"); //ie 有final 修飾
			
		}catch(Exception e){
			
			System.out.println("未知異常");
			e = new RuntimeException("test");
		}		
	}
}

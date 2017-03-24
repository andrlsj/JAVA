
public class MyNullAccessStatic {

	private static void test(){
		System.out.println("靜態方法");
	}
	
	public static void main(String[] args) {
		MyNullAccessStatic myNullAccessStatic = null;
		MyNullAccessStatic.test();//空物件也能調整類方法
	}
	
	
	
}

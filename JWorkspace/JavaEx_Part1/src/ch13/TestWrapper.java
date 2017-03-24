package ch13;

public class TestWrapper {

	public static void main(String[] args) {
		Integer wInt = new Integer(1);
		// JDK 1.4以前，一定要像這樣先做轉型的動作，轉型回int才能運算
		int x = wInt.intValue();
		int y = Integer.parseInt("1");
		System.out.println(x + y);

		String str = "123";
		Integer i1 = new Integer(str);
		System.out.println(str+100); //123100
		System.out.println(i1+100);  //223
		
		System.out.println(Integer.parseInt(str)+100);
		
		
	}

}

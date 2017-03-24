
public class MyInteger {
	
	public static void main(String[] args) {
		int data1 = 10;
		int data2 = 20;
		
		Integer wrap1 = new Integer(data1);
		Integer wrap2 = new Integer(data2);
		
		System.out.println(data1/3);
		System.out.println(wrap1.doubleValue());
		System.out.println(wrap2.compareTo(wrap2));
		
	}
	
}

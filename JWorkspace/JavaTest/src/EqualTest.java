
public class EqualTest {

	public static void main(String[] args) {
		
		int it = 65;
		float fl = 65.0f;		
		System.out.println(it==fl); //true
		
		char ch = 'A';
		System.out.println(it ==ch); //true
		
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1==str2); //false
		
		System.out.println(str1.equals(str2)); //true
		
		
		
		
		

	}

}

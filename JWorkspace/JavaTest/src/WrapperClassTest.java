
public class WrapperClassTest {

	public static void main(String[] args) {

		int i1 = 1;
		int i2 = 1;
		Integer i3 = new Integer(1);
		Integer i4 = new Integer(1);
		
		System.out.println(i1==i2); //1=1
		System.out.println(i1==i3); //1=1
		System.out.println(i1==i4);
		System.out.println(i3==i4);//obj i3 != obj i4
		System.out.println(i3.equals(i4));
		System.out.println(i3.equals(i1));
		
		
	}

}

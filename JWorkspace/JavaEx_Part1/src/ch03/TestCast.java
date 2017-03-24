package ch03;
/*
 * 此範例為測為型別晉升與型別轉換
 */
public class TestCast {

	public static void main(String[] args) {
		int i = 1;
		double d = 11.1;
		double sum1 = i + d;
		int sum2 = (int)(i + d);
		System.out.println(sum1);
		System.out.println(sum2);
		
		int i1 = 1;
		double d2 = 11.1;
		double sum3 = i + d;
		int sum4 = (int)(i + d );
		System.out.println(sum3);
		System.out.println(sum4);
		
		
		
	}

}

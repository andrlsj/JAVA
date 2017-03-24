
import java.util.Arrays;

public class MyArraysTest {

	public static void main(String[] args) {
		int[] a = new int[] { 3, 4, 5, 6 };

		int[] a2 = new int[] { 3, 4, 5, 6 };

		System.out.println(Arrays.equals(a,a2));
		
		int[] b = Arrays.copyOf(a, 6);
	
		System.out.println(Arrays.toString(b));
		
		System.out.println(Arrays.toString(a));
		
		System.out.println(Arrays.binarySearch(a, 5));//a 中 5為序次2 即第三值
		
		
	}

	// 

}

package idv.david.additional.recursive;
import java.util.Scanner;

public class TestRecursive {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("輸入兩數：");
		System.out.print("m = ");
		int m = sc.nextInt();
		System.out.print("n = ");
		int n = sc.nextInt();
		System.out.println("最大公因數： " + gcd(m, n));
		System.out.println("最小公倍數： " + lcm(m, n));
	}

	private static int gcd(int m, int n) {
		if (n == 0)
			return m;
		else
			return gcd(n, m % n);
		// 用以下一行即搞定
//		return n == 0 ? m : gcd(n, m % n);

	}
	
	private static int lcm(int m, int n) {
		return m * n / gcd(m, n);
	}
}

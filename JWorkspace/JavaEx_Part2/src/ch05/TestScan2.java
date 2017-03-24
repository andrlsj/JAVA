package ch05;

import java.util.*;

public class TestScan2 {
	public static void main(String[] args) {
		// 也可以從字串輸入

		Scanner sc = new Scanner("Add 1 2 3");
		String str = sc.next();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		System.out.println(str);
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		sc.close();

	}
}

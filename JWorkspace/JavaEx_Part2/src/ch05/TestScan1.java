package ch05;

import java.util.*;

public class TestScan1 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("請輸入字串: ");
		String param = s.next();
		System.out.println("the param 1: " + param);

		System.out.println();

		System.out.println("請輸入整數: ");
		int value = s.nextInt();
		System.out.println("the param 2: " + value);
		s.close();
	}
}

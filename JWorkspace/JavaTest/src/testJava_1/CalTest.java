package testJava_1;

import java.util.Scanner;

public class CalTest {
	// 請設計兩個類別CalException.java與CalTest.java,在CalTest.java裡有個自
	// 訂方法為powerXY(int x, int y),功能是會計算x的y次方並回傳結果。使用者
	// 可以輸入x與y的值,請加入例外處理機制,讓程式能解決以下狀況:
	// 1. x與y同時為0,(產生CalException的例外物件)
	// 2. y為負值,而導致x的y次方結果不為整數
	// 3. x與y皆正確情況下,會顯示運算後結果

	public static void main(String[] args) {

		System.out.println("請輸入x,y的值, 若不想繼續 請輸入 file exit");

		Scanner sc = new Scanner(System.in);

		String[] inputString = new String[2];

		while (sc.hasNext()) {

			int[] ok = new int[2];
			inputString[0] = sc.next();
			inputString[1] = sc.next();

			Cal ct = new Cal();

			try {
				ok = ct.checkInput(inputString);// 調用方法檢查輸入string[] 並送回要求int[];
				ct.power(ok[0], ok[1]);
			} catch (CalException ce) {
				System.out.println(ce.getMessage());
			}
		}

		sc.close();
	
	
	}
}

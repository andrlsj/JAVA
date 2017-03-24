import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class HomeWork4_4_AB106_18 {

	public static void main(String[] args) {

		// 請設計一個程式,可以讓小華輸入欲借的金額後,便會顯示哪些員工編號的同事有錢可借他;
		// 並且統計有錢可借的總人數:例如輸入 1000 就顯示「有錢可借的員工編號: 25 19 27 共 3 人!」
		// (提示:Scanner,二維陣列)
				
		int[] num = { 25, 32, 8, 19, 27 };
		int[] money = { 2500, 800, 500, 1000, 1200 };
		System.out.println("請輸入小華輸入欲借的金額:");
		Scanner sc = new Scanner(System.in);		
		
		int keyinValue = sc.nextInt();
		//檢驗輸入數字非負
		if (keyinValue < 0) {
			System.out.println("小明是要借錢的吧?！");
			keyinValue = sc.nextInt();
		}
		
		// 群訪並比對合於借錢標準 並計算合條件總人數
		int count = 0;
		for (int a : money) {
			if (keyinValue <= a) {
				count += 1;
			}
		}
		// 依序比較 大於計算金額的序次 轉換為員工編號序次並對應取出員工編號
		System.out.println("可借錢同事的員工編號為:");
		for (int i = 0; i < money.length; i++) {
			if (keyinValue <= money[i]) {
				System.out.print(num[i] + " ");
			}
		}
		System.out.println("共: " + count + "人");

	}
}

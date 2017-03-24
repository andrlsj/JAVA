import java.util.Scanner;

public class HomeWork4_5_AB106_18 {

	public static void main(String[] args) {
		// 請設計一隻程式由鍵盤輸入三個整數,分別代表西元yyyy年,mm月,dd日,它會顯示是該年的第幾天

		int[] a = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 非潤年
		int[] b = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 潤年
		System.out.println("請輸入三個整數,分別代表西元yyyy年,mm月,dd日");

		Scanner scanner = new Scanner(System.in);

		int yy = scanner.nextInt();
		int mm = scanner.nextInt();
		int dd = scanner.nextInt();
		
		// 年份檢定後 再潤年判斷後 並對y給值  (西元年分是400的倍數)或(西元年分是4的倍數但不是100的倍數))
		boolean y = false;
		if(yy< 0){
			System.out.println("年份錯誤 請重新輸入年份");
			yy = scanner.nextInt();
		}
		if (yy % 400 == 0 || ((yy % 4 == 0) && (yy % 100 != 0))) {
			y = true;
			System.out.println("年份為潤年");
		} else {
			y = false;
			System.out.println("年份非潤年");
		}
		// 月份不得大於12 且不得小於等於0
		if (mm > 12 || mm <= 0) {
			System.out.println("月份錯誤 請重新輸入月份");
			mm = scanner.nextInt();
		}

		// 依(潤年b 2月29天 非潤年a 2月28天) 對月份來對應天數大小確認
		if (y == true) {
			if (dd > b[mm - 1] || dd <= 0) {
				System.out.println("日期錯誤 請重新輸入日號");
				dd = scanner.nextInt();
			}
		} else {
			if (dd > a[mm - 1] || dd <= 0) {
				System.out.println("請重新輸入日號");
				dd = scanner.nextInt();
			}
		}
		// 將月份依潤年與否 依序次取值加總 即為所求總日數
		int sumMonDay = 0;
		if (y) {
			for (int i = 0; i < mm - 1; i++) {
				sumMonDay += b[i];
			}

		} else {
			for (int i = 0; i < mm - 1; i++) {
				sumMonDay += a[i];
			}
		}
		int totalDays = sumMonDay + dd;
		System.out.println("結果: 西元  " + yy + "第" + totalDays + "天");
	}
}

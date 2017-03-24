
import java.util.*;

public class HomeWork3_3_AB106_18 {

	public static void main(String[] args) {

		/* 阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4, 但這次他想要依心情決定討厭哪個數字,
		 * 請您設計一隻程式,讓阿文可以輸入他不想要的數字,畫面會顯示他可以選擇的號碼與總數*/

		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入討厭數字: ");
		int hate = sc.nextInt();

		// 作出bigNum陣列依序放置1~49 (未用到) 
//		int[] bigNum = new int[49];		
//		for (int i = 0; i < 49; i++) {
//			bigNum[i] = i + 1;
//		}

		// 檢驗輸入值
		if (hate <= 0 || hate > 9) {
			System.out.println("錯誤，請重新輸入阿文討厭數值");
			hate = sc.nextInt();
		}

		// 計算符合阿文喜好數值的總數
		int count = 0;
		for (int i = 1; i <= 49; i++) {
			if (i % 10 != hate && (i / 10) != hate) {
				System.out.print(i + " ");
				count += 1;
			}
		}

		System.out.println("\n" + "可選數字的數量:" + count);

		// (進階挑戰:輸入不要的數字後,直接亂數印出6個號碼且不得重覆)
		// 把所有滿足阿文喜好數值 全放於ok列 () 不符合喜好以零值填充
		int[] ok = new int[49];
		
		for (int i = 1; i <= 49; i++) {
			if ((i % 10) != hate && (i / 10) != hate) {
				ok[i - 1] = i;
			}
		}
		 //檢驗ok陣列所有值
		 for (int i : ok) {
		 System.out.print(i + " ");
		 }

		int[] z = new int[6];
		HashSet<Integer> zSet = new HashSet();
		
		// 利用Set組合不得重覆特性 來反覆刷選合於組數為6的組合
		while (zSet.size() < 6) {
			zSet.clear();
			for (int i = 1; i <= 6; i++) {
				// 在喜愛中的組合中 以亂數作為序次，以序次取出
				int random = (int) (Math.random() * (count));
				if (ok[random] != 0) {
					zSet.add(ok[random]);
				}
			}
		}

		System.out.println("\n" + "電腦建議阿文可填寫選項為: " + zSet);

	}
}

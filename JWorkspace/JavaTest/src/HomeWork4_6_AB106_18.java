import java.util.Arrays;

public class HomeWork4_6_AB106_18 {

	public static void main(String[] args) {
		int[] s = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[][] scores = { 
				{ 10, 35, 40, 100, 90, 85, 75, 70 }, 
				{ 37, 75, 77, 89, 64, 75, 70, 98 },
				{ 100, 70, 79, 90, 75, 70, 79, 90 }, 
				{ 77, 95, 70, 89, 60, 75, 85, 89 },
				{ 98, 70, 89, 90, 75, 90, 89, 90 }, 
				{ 90, 80, 100, 75, 50, 20, 99, 75 } };

		int[][] sortScore = new int[6][];

		for (int i = 0; i < scores.length; i++) {

			sortScore[i] = Arrays.copyOf(scores[i], scores[i].length);
		}
		
		// 復制一份 進行排序 取最後值 即為各試最大值 並以新一維陣列放置 各試最大值
		int[] hightScore = new int[6];
		for (int i = 0; i < sortScore.length; i++) {
			Arrays.sort(sortScore[i]);
			hightScore[i] = sortScore[i][7];
		}
		System.out.println("各次考試的最高份: ");
		for (int a : hightScore) {
			System.out.print(a + " ");
		}
		System.out.println("\n" + "驗証原列正確");
		for (int b : scores[1]) {
			System.out.print(b + " ");
		}

		// 各試最大值中依序取值，與舊試比較相等，以其回傳為新列序值 +1
		// {10,35,40,100,90,85,75,70},
		int[] goodCont = new int[8];
		for (int i = 0; i < scores.length; i++) {
			// 拿第一次最高份組 與第一試成員比較
			for (int j = 0; j < scores[i].length; j++) {

				if (scores[i][j] == hightScore[i]) {
					goodCont[j] += 1;
				}
			}
		}

		System.out.println("\n" + "各學生得到過各試最高分的次數如下:");
		for (int c : goodCont) {
			System.out.print(c + " ");
		}

	}

}

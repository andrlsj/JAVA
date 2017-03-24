import java.util.Arrays;
import java.util.Scanner;

public class HomeWork3_1_AB106_18 {
	// 請設計一隻程式,使用者輸入三個數字後,輸出結果會為正三角形、等腰三角形、其它三角形或不是三角形

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入三角形三邊長:");

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int[] tri = { a, b, c };
		Arrays.sort(tri);

		System.out.println("請輸入三角形的三邊長:");

		// 三角形基本 存在條件:A+B>C,ABC!=0
		if ((tri[0] + tri[1]) < tri[2] || (tri[0] * tri[1] * tri[2] == 0)) {

			System.out.println("無法構成三角形");
		}
		// 正三角形
		else if (tri[0] == tri[1] && tri[1] == tri[2]) {

			System.out.println("正三角形");
		}
		// 等腰直角三角形:A^2+B^2=C^2,A=B
		else if ((Math.pow(tri[0], 2) + Math.pow(tri[1], 2)) == Math.pow(tri[2], 2) && tri[0] == tri[1]) {
			System.out.println("等腰直角三角形");
		}

		// 等腰三角形:A+B>C , A=B
		else if (tri[0] + tri[1] > tri[1] && tri[0] == tri[1]) {
			System.out.println("等腰三角形");
		}

		// 直角三角形:若任一邊具有 A^2+ B^2=C^2
		else if ((Math.pow(tri[0], 2) + Math.pow(tri[1], 2)) == Math.pow(tri[2], 2)) {
			System.out.println("直角三角形");
		}

		// 鈍角三角形:若任一邊具有A^2+B^2<C^2
		else if ((Math.pow(tri[0], 2) + Math.pow(tri[1], 2)) <= Math.pow(tri[2], 2)) {
			System.out.println("鈍角三角形");
		}

		// 銳角三角形:若任 一邊具有A^2+B^2>C^2
		else if ((Math.pow(tri[0], 2) + Math.pow(tri[1], 2)) >= Math.pow(tri[2], 2)) {
			System.out.println("銳角三角形");
		} else 
		{
			System.out.println("無法判斷");
		}
	}
}

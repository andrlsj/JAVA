import java.security.GuardedObject;
import java.util.Scanner;

public class HomeWork3_2_1_AB106_18 {

	public static void main(String[] args) {

		int pcNum = (int) (Math.random() * 100) + 1;
		Scanner scanner = new Scanner(System.in);

		System.out.println("請輸入數字 " + "偷瞄答案" + pcNum);
		while (scanner.hasNext()) {

			int guess = scanner.nextInt();

			System.out.println(guess > pcNum ? "較答案大" : guess < pcNum ? "較答案小" : "正確");

		}

	}

}

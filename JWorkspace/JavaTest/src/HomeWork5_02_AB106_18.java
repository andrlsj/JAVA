import java.util.Arrays;

public class HomeWork5_02_AB106_18 {
	// 請設計方法為randAvg(),從10個 0~100(含100)的整數亂數中取平均值，並印出這10個亂數與平均值

	public static void main(String[] args) {

		HomeWork5_02_AB106_18 hw = new HomeWork5_02_AB106_18();
		hw.randAvg();

	}

	public void randAvg() {

		int sum = 0;
		int[] rand = new int[10];
		for (int i = 0; i < 10; i++) {

			int randNum = (int) (Math.random() * 101);
			rand[i] = randNum;
			sum += randNum;
		}
		System.out.println(Arrays.toString(rand) + " 平均:" + (sum / 10));
	}
}

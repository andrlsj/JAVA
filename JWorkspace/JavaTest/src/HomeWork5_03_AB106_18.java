import java.util.Arrays;

public class HomeWork5_03_AB106_18 {
	// 利用Overloading,設計兩個方法double maxElement(int x[][])與double
	// maxElement(double x[][]),可以找出二維陣列的最大值並回傳,如圖:

	int[][] intArray = { { 1, 6, 3 }, { 9, 5, 2 } };
	double[][] doubleArray = { { 1.2, 3.5, 2.2 }, { 7.4, 2.1, 8.2 } };

	public static void main(String[] args) {

		HomeWork5_03_AB106_18 hw = new HomeWork5_03_AB106_18();

		hw.maxElement(hw.intArray);
		hw.maxElement(hw.doubleArray);

	}

	double maxElement(int x[][]) {

		Arrays.sort(intArray[0]);
		Arrays.sort(intArray[1]);

		int a = intArray[0][intArray[0].length - 1];
		int b = intArray[1][intArray[1].length - 1];
		// guess > pcNum ? "較答案大" : guess < pcNum ? "較答案小" : "正確"
		System.out.println(a > b ? a : b);
		return a > b ? a : b;
	}

	double maxElement(double x[][]) {

		Arrays.sort(doubleArray[0]);
		Arrays.sort(doubleArray[1]);

		double a = doubleArray[0][doubleArray[0].length - 1];
		double b = doubleArray[1][doubleArray[1].length - 1];
		// guess > pcNum ? "較答案大" : guess < pcNum ? "較答案小" : "正確"
		System.out.println(a > b ? a : b);
		return a > b ? a : b;
	}

}

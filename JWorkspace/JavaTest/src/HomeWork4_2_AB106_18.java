import java.util.Scanner;

public class HomeWork4_2_AB106_18 {

	public static void main(String[] args) {
		// * 請建立一個字串,經過程式執行後,輸入結果是反過來的
		// * 例如String s = “Hello World”,執行結果即為dlroW olleH(提示:String方法,陣列)
		System.out.println("請輸入字串:");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		
		try {
			HomeWork4_2_AB106_18 hw = new HomeWork4_2_AB106_18();
			System.out.println(hw.reverseString(s));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String reverseString(String str) {

		String reStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reStr += str.charAt(i);
		}
		return reStr;
	}
}

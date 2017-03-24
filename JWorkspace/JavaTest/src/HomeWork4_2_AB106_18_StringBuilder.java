import java.util.Scanner;

public class HomeWork4_2_AB106_18_StringBuilder {

	public static void main(String[] args) {
		// * 請建立一個字串,經過程式執行後,輸入結果是反過來的
		// * 例如String s = “Hello World”,執行結果即為dlroW olleH(提示:String方法,陣列)
		
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入文字");
		
		while(sc.hasNext()){	
			String str = sc.next();
			StringBuilder sb = new StringBuilder(str);
			System.out.println(sb.reverse());
		}
		
		sc.close();
			
	}

	
}

package testJava_1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatternMatcher {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Pattern p1 = Pattern.compile("[0-9]");
		Pattern p2 = Pattern.compile("[a-z]");
		Matcher m2 = p1.matcher(sc.next());
		
		

		while (sc.hasNext()) {
			String str = sc.nextLine();
			Matcher m1 = p1.matcher(str);
			
			while (m1.find()) {
				System.out.print(m1.group());
			}
		}
		
		// Pattern 條件 = Pattern.compile("[0-9]"); //"只允許"數字
		// Pattern 條件 = Pattern.compile("[a-z]"); //"只允許"英文小寫字母
		// Pattern 條件 = Pattern.compile("[\\p{InCJKUnifiedIdeographs}]"); //只允許中文
		// Pattern 條件 = Pattern.compile("[^\\x00-\\x40\\x5B-\\x60\\x7B-\\x7F]");//只允許英文字母以及中文
		// Pattern 條件 = Pattern.compile("[\\p{InCJKUnifiedIdeographs}\\[a-zA-Z]");//只允許英文字母以及中文
		// Matcher 匹配 = 條件.matcher(字串內容);
		
		
		
		
		
		
		

	}
}

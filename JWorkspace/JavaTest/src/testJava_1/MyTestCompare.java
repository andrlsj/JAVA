package testJava_1;

import java.util.Scanner;

public class MyTestCompare {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			String str = sc.next();
			
//			if(str.matches("[a-f]"))//第一個 單個 "字元"進行比較
//				System.out.println("有英文");
			
//			if(str.matches(".*[a-f]+.*"))
//				System.out.println("含有英文");
			
			if(str.matches("...[a-f]"))
			System.out.println("第四個為英文字元");
			
			if(str.matches("\\d"))
				System.out.println("有數字");
			
			if(str.matches("\\d\\d-\\d\\d\\d\\d\\d\\d\\d"))
				System.out.println("符合電話格式");
			
			if(str.matches(".*\\p{InCJKUnifiedIdeographs}+‧*")){
				System.out.println("有中文");
			}
			
			
			
		}
		

	}

}

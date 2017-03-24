import java.util.Scanner;

public class MyThreeTest {

	public static void main(String[] args) {
		
		String str = 5>3 ? "5>3" : "5<3";
		System.out.println(str);
		
		int a = 5;
		int b = 3;
		
		String str1 = a>b ? "a big" : "b big";
		System.out.println(str1);
		
		int c = (int)(Math.random()*10)+1;
		int c1 = c>5? 1:c; 
		System.out.println(c1);
		
		
		int d = (int)(Math.random()*10)+1;
		Scanner sc = new Scanner(System.in);
		System.out.println("ans:"+d);
		
		while(sc.hasNext()){
		int pcNum = sc.nextInt();
		
		//對 與 錯
		//System.out.println(d != pcNum ? "wrong":"right");
		
		//提示大小
		System.out.println(d>pcNum? "小於答案":d<pcNum? "大於答案":"正確" );
		
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}

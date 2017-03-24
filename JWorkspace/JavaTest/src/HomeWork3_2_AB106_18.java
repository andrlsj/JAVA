import java.util.Scanner;

public class HomeWork3_2_AB106_18 {
	//請設計一隻程式,會亂數產生一個0~9的數字,然後可以玩猜數字遊戲,猜
	//錯會顯示錯誤訊息,猜對則顯示正確訊息,如圖示結果:
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int number = (int)(Math.random()*10);
		int guess;
		
		System.out.println("開始猜數字吧！"+"   偷瞄答案:" + number);
		
		do{
			guess = sc.nextInt();
			 
			 if (guess > number) {
				 
				System.out.println("錯，你猜的數字，較答案大");	
				
			}else{
				
				System.out.println("錯，你猜的數字，較答案小");
			}
			 			
			}while(guess != number);
		
		System.out.println("猜中！"+"正確答案為"+number);
	
	
	}
}


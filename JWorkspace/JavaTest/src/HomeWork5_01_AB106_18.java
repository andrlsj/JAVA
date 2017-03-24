import java.util.Scanner;

public class HomeWork5_01_AB106_18 {

	//請設方法:starSquare(int width, int height),當使用者鍵盤輸入寬與高時,即會印出對應的*長方形:

	public static void main(String[] args) {
		
		int width,height;		
		System.out.println("請輸 寬及 高長度");
		
		Scanner sc = new Scanner(System.in);
		width = sc.nextInt();
		height = sc.nextInt();
		
		HomeWork5_01_AB106_18 hw = new HomeWork5_01_AB106_18();		
		hw.starSquare(width, height);
		
	}

	public void starSquare(int width, int height){//同意被子類借用 但不同意被改寫
		
		for(int i =1;i <= height;i++){
			
			for(int j=1;j <= width;j++){
				
				System.out.print("*");
			}		
			System.out.println();
		}
	}
	
	
	
	
	
}

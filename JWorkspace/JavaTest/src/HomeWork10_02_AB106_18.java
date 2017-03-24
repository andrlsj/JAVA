import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Scanner;

public class HomeWork10_02_AB106_18 {

	public static void main(String[] args) {
		
	//請設計一隻程式,讓使用者可以輸入一個任意數後,可以選擇要以下列何種表示方法
	//顯示(1)千分位(2)百分比(3)科學記號,而輸入非任意數會顯示提示訊息如圖
	//(提示:TestFormatter.java, Java API文件, 判斷數字可用正規表示法)
		String inputNum=null;
		
		//鍵盤輸入，判斷數字與否
		System.out.println("請輸入數字");
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			
			inputNum = sc.nextLine();
			
			if(!(inputNum.matches(".*[0-9.]")))
			{
				System.out.println("輸入不正確");
				continue;
			}
			
			System.out.println("選擇(1)千分位(2)百分比(3)科學記號");
			
			while(sc.hasNext()){
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				Format dfm1 = new DecimalFormat("###,###");
				System.out.println("千位數"+dfm1.format(Float.parseFloat(inputNum)));
				break;
			
			case 2:
				Format dfm2 = new DecimalFormat("###,###00.00%");
				System.out.println("百分比"+dfm2.format(Float.parseFloat(inputNum)));
				//System.out.println(String.format("%d%%", Float.parseFloat(inputNum) ));
				break;
				
			case 3:
				Format dfm3 = new DecimalFormat("###,###00.00E0");
				//System.out.println("科學記號"+dfm3.format(Integer.parseInt(inputNum)));
				System.out.printf("科學符號: %e", new BigDecimal(inputNum));
				break;
		
			default:
				System.out.println("不要開玩笑啦，請重來");
				continue;
			}
			
			}
			
			
			
			
			
			
		}
		
		
		
		
		
		//印出選項 使用者鍵盤輸入
		
		
		sc.close();
	}

}

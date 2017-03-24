import static java.lang.System.out;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;


public class HomeWork10_03_AB106_18 {

	public static void main(String[] args) {
		
		//請設計一隻程式,讓使用者輸入日期(年月日,例如:20110131)後,可以轉成想
		//要的輸出格式化成(1)年/月/日(2)月/日/年(3)日/月/年三選一,而輸入非指定日期
		//數字格式會顯示出提示訊息如圖
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("輸入日期(年月日,例如:20110131)");
		String inputDate = null;
		
		//out1:
		while(sc.hasNext()){
			
			inputDate=sc.next();
			
			if (!(inputDate.matches(".*[0-9]{8}"))) {
				System.out.println("格式數目不正確 請重新輸入");
				continue;
			}
			
			
			
			//4 2 2
			int yy = Integer.parseInt(inputDate.substring(0,4));
			int mm = Integer.parseInt(inputDate.substring(4,6))-1;
			int dd = Integer.parseInt(inputDate.substring(6,8));
			
			System.out.println(yy+" " +mm+1 +" "+dd);
			
			Calendar ca = GregorianCalendar.getInstance();
			ca.set(yy, mm, dd);
			
			
			System.out.println("(1)年/月/日(2)月/日/年(3)日/月/年");
			while(sc.hasNext()){
			
				int choice = sc.nextInt();

			
			switch (choice) {
			case 1:
				Format sfm1 = new SimpleDateFormat("yyyy/MM/dd");
				System.out.println(sfm1.format(ca.getTime()));
				
				break;
				
			case 2:
				Format sfm2 = new SimpleDateFormat("MM/dd/yyyy");
				System.out.println(sfm2.format(ca.getTime()));				
				break;
				
			case 3:
				Format sfm3 = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println(sfm3.format(ca.getTime()));
				break;	

			default:
				
				System.out.println("別鬧");
				break;
			}
			
			}
			
			
			
			
		}
		
		
		
		
		
		

	}

}

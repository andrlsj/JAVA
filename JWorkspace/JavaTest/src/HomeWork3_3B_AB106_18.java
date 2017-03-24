import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class HomeWork3_3B_AB106_18 {

	public static void main(String[] args) {
		
		/*
		 * 阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4, 但這次他想要依心情決定討厭哪個數字,請您設計一隻程式,讓阿文
		 * 可以輸入他不想要的數字,畫面會顯示他可以選擇的號碼與總數,如
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入討厭數字: ");
		int hate = sc.nextInt();
		int[] bigNum = new int[49];
		for (int i = 0; i < 49; i++) {
			bigNum[i] = i;
		}

		int count = 0;
		for (int i = 1; i <= 49; i++) {

			if (i % 10 != hate && (i / 10) != hate && (int) (i / 10) != 0) {
				System.out.print(i + " ");
				count += 1;
			}
		}

		System.out.println("\n" + "count:" + count);
		// (進階挑戰:輸入不要的數字後,直接亂數印出6個號碼且不得重覆)
		System.out.println("亂數");

		int num = 0;
		int[] y = new int[50];

		//把所有滿足條件 全放y列
		for (int i = 0; i <= 48; i++) {

			if ((i % 10) != hate && (i / 10) != hate && (int) (i / 10) != 0 && i!=0) {

				y[num += 1] = i;
			}
		}
		//列印全部y陣列		
		for(int a:y){
			System.out.print(" "+ a);
		}
		System.out.println("\n"+"==================");
		int[] z = new int[6];
		//生成1~count 的一個隨機亂數一維陣列 z[6] = {3 25 12 48 49 1}
		
		ArrayList ar = new ArrayList();
		
		for(int i=1;i<=count;i++){
			ar.add(new Integer(i));
		}
		
		for(Object a:ar){
			System.out.print(a + " ");
			
		}
		
		
		//依次取z陣列各值，作序次 ，分別取出滿足值列y
			for (int i = 1; i <= 6; i++) {
				// 在喜愛中的組合中 以亂數作為序次， 將序次入值取出
				int ran = (int) ((Math.random() * count+1));

				//System.out.print(y[ran]+" ");
				//z[i - 1] = y[ran];			
			}			
		
		
			
			
			
			
			
//		for(int b:z){
//			System.out.println(b);
//		}
		
		System.out.println("\n" + "=====================");
		
		
		
		
		
		

	}
	
	
	
	
	
	
	
	

}

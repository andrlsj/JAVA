
public class HomeWork1221_01 {

	public static void main(String[] args) {
		
		//請設計一隻Java程式,計算12,6這兩個數值的和與積
		
		int a = 12;
		int b = 6;
		int sum = a+b;
		int product = a*b;
		
		System.out.println("Question 1");
		System.out.println("12與6的總和為 : " + sum);
		System.out.println("12與6的乘積為 : " + product );
		System.out.println("===========================");
		
		//請設計一隻Java程式,計算200顆蛋共是幾打幾顆? (一打為12顆)
		
		int eggNumber = 200;
		int dozenValue = 12;
		int dozen = eggNumber / dozenValue;
		int remainder = eggNumber % dozenValue;
		
		System.out.println("Question 2");
		System.out.println("共" + dozen + "打" + "餘" + remainder + "顆");
		System.out.println("===========================");
		
		//請由程式算出256559秒為多少天、多少小時、多少分與多少秒
		//一天24小時 /一小時60分/一分60秒
		//2 天 23 小时 15 分 59 秒
	
		int totalSec =  256559;		
	    int ss = totalSec % 60; //sec 
        int mm = (totalSec / 60) % 60;//min
        int hh = (totalSec %(24*60*60))/3600; //hour
		int dd = totalSec /(24*60*60);//day 2
		
		System.out.println("Question 3");
		System.out.println("256559秒為 " + dd + " 天 " + hh + " 時 " + mm +" 分 " + ss + " 秒" );		
		System.out.println("===========================");
		
		//請定義一個常數為3.1415(圓周率),並計算半徑為5的圓面積與圓周長
		
		final float PI = 3.1415f;
		int radius = 5;
		float perimeter = radius * 2 * PI;
		float area = (float) Math.pow(radius,2) * PI;
		
		System.out.println("Question 4");
		System.out.println("圓週長: " + perimeter);
		System.out.println("圓面積: " +area);
		System.out.println("===========================");
		
		//某人在銀行存入150萬,銀行利率為2%,如果每年利息都繼續存入銀行,
		//請用程式計算10年後,本金加利息共有多少錢 (if by month)
		//複利：本利和＝本金 × ( 1 + 年利率 (略÷ 12*) )期數 *略
		
		int saveMoney = 1_500_000;
		double ratio = 0.02;
		double totalSum;
		totalSum = saveMoney * Math.pow((1 + ratio), 10);
		int debriefTotalSum = (int) totalSum;
		System.out.println("Question 5");
		System.out.println("本利和: " + debriefTotalSum + " 元");
		System.out.println("===========================");
		
		/*請寫一隻程式,利用System.out.println()印出以下三個運算式結果:
		5 + 5
		5 + "5"
		5 + “5”
		並請用註解各別說明答案的產生原因*/
		System.out.println("Question 6");
		System.out.println(5+5); //5+5=10
		System.out.println(" 整數相加");
		System.out.println(5 + '5');//'5'->53 ; 5+53=58
		
		System.out.println(" \'5\' :型別為char 其unicode十進位號次為53，相加結果為58");
		System.out.println(5 + "5");//"5"->String =>55
		System.out.println(" \"5\" 為字串，+僅為連綴之用，結果為55");
		
	}

}

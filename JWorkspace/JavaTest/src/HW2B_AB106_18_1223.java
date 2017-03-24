
public class HW2B_AB106_18_1223 {

	public static void main(String[] args) {
		System.out.println("=Q1=");
		//1.請設計一隻Java程式,計算1~1000的偶數和 (2+4+6+8+...+1000)
		int sum = 0;
		for(int i=1;i<=500;i++){
			sum +=i*2;
		}
		System.out.println(sum);
		System.out.println("==============");
		
		System.out.println("=Q2=");
		//請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		int mult = 1;
		for(int i = 1;i<=10;i++){ 
		mult *= i;	
		}
		System.out.println(mult);
		System.out.println("==============");
		
		System.out.println("=Q3=");
		//請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		int whileMulti = 1;
		int j = 1;
		while(j<=10){
			whileMulti *= j;
			j++;
		}
		System.out.println(whileMulti);
		System.out.println("==============");
		
		System.out.println("=Q4=");
		//請設計一隻Java程式,輸出結果為以下:
		//1 4 9 16 25 36 49 64 81 100
		
		int k;
		double l;
		for(k=1;k<=10;k++){
			l = Math.pow(k, 2);	
			int m = (int)l;
			System.out.print(m +" ");
		}
		System.out.println("\n" + "=============");
		
		System.out.println("=Q5=");
		//阿文很熱衷大樂透 (1 ~ 49),但他不喜歡有4的數字,不論是個位數或是十位數。
		//請設計一隻程式,輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
		int big = 1;
		int bigNum = 49;
		int count = 0;
		System.out.println("可選擇數字: ");
		for(big=1;big<=bigNum;big++){
			
			if(big % 10 != 4 && (big / 10)!=4){
				System.out.print(big + " ");
				count++;
			}			
		}
		System.out.println("共計" + count +"個");
				
		System.out.println("==============");
		System.out.println("=Q6=");
		//請設計一隻Java程式,輸出結果為以下:
		//1 2 3 4 5 6 7 8 9 10
		//1 2 3 4 5 6 7 8 9
		//1 2 3 4 5 6 7 8
		//1 2 3 4 5 6 7
		//1 2 3 4 5 6
		//1 2 3 4 5
		//1 2 3 4
		//1 2 3
		//1 2
		//1
		
		int o,p;
	
		for(p=10;p>=1;p--){
			
			for(o=1; o<=p;o++){
			
			System.out.print(o + " ");			
			}
			System.out.println();
		}
				
		System.out.println("\n" + "==============");
		
		/*
		 * 請設計一隻Java程式,輸出結果為以下:
		A 41 65
		BB 42 66
		CCC 43 67
		DDDD 44 68
		EEEEE 45 69
		FFFFFF 46 70
		 */
		
		int a = 'A'; //65
		char c = 0x41;
		System.out.println("\u0041");//65 JAVA x		
		System.out.println("we want " + "0x41 = " + c + ";" + "\n" + "(char)65 =" +(char)65 + " " + c);
		
		String example = "ABCDEF";
		byte[] codeNum = example.getBytes();
		for(Object r:codeNum){
			System.out.print(r + " ");
		}
		
		System.out.println("\n" +"==================");
		System.out.println("=Q7=");
		char ch=65;
		int t;
    	for(t=0;t<6;t++){
    		
    		for(int u=0;u<t+1;u++){
    		
    			System.out.print((char)(ch+t));
    		}
    		System.out.println();
    	}
		
	System.out.println("==============================");
	
		int r,s;
		
		for(r=1;r<=5;r++){
			
			for(s=1;s<=r;s++){
				
				System.out.print("*");
			}			
			System.out.println();
		}
		
		System.out.println("==============");
		
	}

}

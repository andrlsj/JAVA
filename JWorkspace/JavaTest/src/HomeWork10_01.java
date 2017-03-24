import java.util.*;

public class HomeWork10_01 {

	public static void main(String[] args) {
	//請設計一隻程式,用亂數產生5個介於1~100之間的整數,而輸出結果可以判斷出這5個整數為是否為質數 (提示:Math類別)	
		
		List<Integer> randSet = new ArrayList<>();	
		
		for(int i= 1;i<=5;i++){
			
			int random = (int)(Math.random()*100)+1;
			randSet.add(random);
		}
		
		PrimeNumberJudge pnj = new PrimeNumberJudge();
		//check
		for(int i :randSet){
			//System.out.println(i);
			pnj.judgePrimeNumber(i);
		}
		
		
		
		
		
		
	}

}

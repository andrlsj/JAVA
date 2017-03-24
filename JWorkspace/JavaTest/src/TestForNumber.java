
public class TestForNumber {

	public static void main(String[] args) {
		//請建立一個Test4Numbers.java,可輸出0~100裡4的倍數
		
		int i,fourNum =1,multi = 4;
		
		for (i=1; i<=25;i++){
			
			fourNum = i * multi;
			
			System.out.print(fourNum + " ");
		}
		System.out.println();
		
		int j;
		
		for(j=1;j <= 100;j++){
			
			if(j%multi ==0){
				
				System.out.print(j + " ");
			}
			
		}
		
		
		
	}
}

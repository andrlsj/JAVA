
public class HomeWork09_01_AB106_18 {
	//開啓2個執行緒模擬饅頭人與詹姆士參加快胃王比賽所做的競賽過程。
//• 每個動作都以Thread.sleep()暫停一下,以達到顯示效果。Sleep時間由亂數產生500~3000之間的毫秒數,如圖所示
	//• 參考範例:CounterRunnable.java • 需留意主執行緒執行順序
	
	public static void main(String[] args) {
		
		EatRace eater1 = new EatRace("饅頭人");
		Thread t1 = new Thread(eater1);
		EatRace eater2 = new EatRace("詹姆士");
		Thread t2 = new Thread(eater2);
		
		t1.start();
		t2.start();
		
		try {
			
			t1.join();
			t2.join();
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		System.out.println("game is over");
		
		
	}
	
	
	
}

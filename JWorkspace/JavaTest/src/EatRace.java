
public class EatRace implements Runnable{
	
	private String eater;
	
	//constructor
	public EatRace(String eater) {
		super();
		this.eater = eater;
		
	}
	//setter & getter
	public String getEater() {
		return eater;
	}
	public void setEater(String eater) {
		this.eater = eater;
	}
	
	//run()
	public void run() {
		
		for(int i =1;i<=10;i++){
			
			System.out.println(eater + "吃了第 " + i+" 碗");
			try {
				Thread.sleep((long)(Math.random()*2500)+500);
			} catch (Exception e) {
			}
		}
		System.out.println(eater+"吃完了");		
	}
}

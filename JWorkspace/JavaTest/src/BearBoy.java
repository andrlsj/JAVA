
public class BearBoy extends Thread {
	BearBoyAccount account;

	public BearBoy(BearBoyAccount account) {
		super();
		this.account = account;
	}
	
	public void run(){
		
		for(int i=1;i<=10;i++){
			account.withdraw(2000);
		}
		
	}
}

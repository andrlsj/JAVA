
public class BearMom extends Thread{
	
	BearBoyAccount account;

	public BearMom(BearBoyAccount account) {
		super();
		this.account = account;
	}
	
	public void run(){
		for(int i=1;i<=10;i++){
			account.deposit(2000);
		}
	}

}

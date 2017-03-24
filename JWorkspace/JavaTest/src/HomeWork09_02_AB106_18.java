
public class HomeWork09_02_AB106_18 {

	public static void main(String[] args) {
		BearBoyAccount account = new BearBoyAccount();
		BearBoy bboy = new BearBoy(account);
		BearMom bmom = new BearMom(account);
		bboy.start();
		bmom.start();
		
		
	}

}

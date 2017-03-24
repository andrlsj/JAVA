
public class MyPassArgs {

	static void passValue(double value){
		value = 20.0;
	}
	
	static void passReference(Pen reference){
		reference.price = 20.0;
	}
	
	public static void main(String[] args){
		double price = 10.0;
		passValue(price);
		System.out.println(price);
		
		Pen myPen = new Pen();
		
		myPen.price = 10.0;
		System.out.println(myPen.price);
		passReference(myPen);
		System.out.println(myPen.price);
		
		Pen pen1 = new Pen();
		pen1.brand = "money";
		System.out.println(pen1.brand);
		
		
		
		
	}
	
}

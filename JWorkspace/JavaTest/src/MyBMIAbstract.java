
public class MyBMIAbstract extends MyBMIAbstractTest{
	
	public double getHeight(){
		return 1.74;
	}
	public double getWeight(){
		return 70;
	}
	
	public static void main(String[] args) {
		
		MyBMIAbstract test = new MyBMIAbstract();
		
		System.out.println(test.getHealth());
	}

}

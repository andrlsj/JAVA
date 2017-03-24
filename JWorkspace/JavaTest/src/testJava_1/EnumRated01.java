package testJava_1;

enum SuitA{
	club(1),diamond(2),heart(3),spade(4);
	
	private int value;
	
	SuitA(int value){
		this.value=value;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int value){
		this.value=value;
	}
}


public class EnumRated01 {

	public static void main(String[] args) {
		
		for(SuitA a:SuitA.values()){
			System.out.println(a + "=" + a.getValue());
		}
		
		SuitA suit = SuitA.diamond;
		System.out.println(suit.getValue());
		
		suit.setValue(10);
		System.out.println(suit.getValue());
		
		
		
	}

}

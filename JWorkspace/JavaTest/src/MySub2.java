
class Base1{
	public int a = 5;
}

public class MySub2 extends Base1{
	
	public int a = 7;
	
	public void accessOwner(){
		System.out.println(a);
	}
	
	public void accessBase(){
		System.out.println(super.a);
	}
	
	public static void main(String[] args) {
		
		MySub2 m = new MySub2();
		m.accessOwner(); //7
		m.accessBase();	//5
		
	}
	
	
	
}

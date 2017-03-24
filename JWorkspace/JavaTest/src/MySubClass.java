
class MyBaseClass {

	public int a = 5;
}

public class MySubClass extends MyBaseClass{

	public int a = 7;
	
	public void accessOwner(){
		
		System.out.println(a);
		
	}
	
	public void accessBase(){
		System.out.println(super.a);
	}
	
	public static void main(String[] args) {
		MySubClass mm = new MySubClass();
		mm.accessOwner();//override
		mm.accessBase();//super
	}
	
}

class Base2{
	
	public Base2(){
		test();
	}
	public void test(){
		System.out.println("Cat");
	}	
}

public class MySub4 extends Base{
	private String name;
	
	public void test(){
		System.out.println("tiger");
	}
	public static void main(String[] args) {
		MySub4 s = new MySub4();	
		s.test();
		
		//Base2 b = new MySub4(); //錯誤
		//b.test();
		
		Base2 b1 = new Base2();
		
		
	}

}

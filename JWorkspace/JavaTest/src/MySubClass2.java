class BaseClass{
	
	public int book = 6;
	
	public void base() {
		System.out.println("父類普通方法");
	}
	
	public void test() {
		System.out.println("父類被覆蓋的方法");
	}
	
}

public class MySubClass2 extends BaseClass{

	public String book = "java book1";
	
	public void test(){
		System.out.println("子類覆蓋父類方法");
	}
	
	public void sub(){
		System.out.println("子類普通方法");
	}
	
	public static void main(String[] args) {

	
		BaseClass bc = new BaseClass();
		System.out.println(bc.book); //6
		
		bc.base();
		bc.test();
		
		MySubClass2 ms = new MySubClass2();
		
		System.out.println(ms.book);
		ms.base();
		ms.test();
		
		//Polymophic~
		
		BaseClass ployBc = new MySubClass2();
		System.out.println(ployBc.book);//6
		ployBc.base();
		ployBc.test();
		
		
		
		
	}

}

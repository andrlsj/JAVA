
public class MyPerson {

	{
		int a = 6;
		if(a>4){
			System.out.println("Person初始化塊，局部變量a>4");
		}
		System.out.println("Person 1st初始化塊");
	}
	
	{
		System.out.println("Person 2nd初始化塊");
	}
	
	public MyPerson(){
		System.out.println("Person無參數構造器");
	}
	
	public static void main(String[] args){
		new MyPerson();
	}
	
}

package testJava_2;

interface Eatable{
	void taste();
}
interface Flyable{
	void fly(String weather);
}
interface Addable{
	int add(int a,int b);
}

public class LambdaQs {
	
	public void eat(Eatable e){
		System.out.println(e);
		e.taste();
	}	
	public void drive(Flyable f){
		System.out.println("我在駕駛:"+f);
		f.fly("碧海晴天");
	}
	public void test(Addable add){
		System.out.println("5+3"+add.add(5, 3));
	}
	
	public static void main(String[] args) {
	LambdaQs lq = new LambdaQs();
	lq.eat(()->System.out.println("好吃的蘋果"));
		
	lq.drive((weather)->{System.out.println("今天天氣是:"+weather);});
	
	lq.test((a,b)->a+b);	
		
	}

}

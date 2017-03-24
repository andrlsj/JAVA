package testJava_1;

public class TestGetWeight {
	//請運用多型設計讓Powder, Plane, Dog這三個類別藉由getWeightMethod()方法可以顯示出各自適合的量體重的工具
	//(如: Powder使用天秤, Plane使用地磅, Dog使用體重計)
	public static void main(String[] argse){
		GetWeightable[] items = new GetWeightable[3];
		
		items[0]=new Dog("狗",12.0);
		items[1]=new Plane();
		items[2]=new Powder();
		
		for(GetWeightable a : items){
			a.getWeightMethod();
		}
		
		
	}	
}


public class MySeasonEnumTest {

	public void judge(MySeasonEnum s){
		switch(s){
			
		case SPRING:
			System.out.println("春暖花開");
			break;
			
		case SUMMER:
			System.out.println("夏日炎炎");
			break;
			
		case FALL:
			System.out.println("秋高氣爽");
			break;
			
		case WINTER:
			System.out.println("冬日賞雪");
			break;
			
		}
		
	}
	
	public static void main(String[] args){
		
		for(MySeasonEnum s: MySeasonEnum.values()){//MySeasonEnum.values()->MySeasonEnum[]
			System.out.println(s);
		}
		
		new MySeasonEnumTest().judge(MySeasonEnum.SPRING);
		
		System.out.println(MySeasonEnum.SPRING.ordinal());//spring在MySeasonEnum序次
		
		MySeasonEnum mset = Enum.valueOf(MySeasonEnum.class, "SPRING");
		
		System.out.println(mset);
	}
	
	
}

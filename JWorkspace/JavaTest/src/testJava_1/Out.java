package testJava_1;

import java.io.PrintWriter;

public interface Out {
	
	int MAX_CHCHE_LINE=50;
	
	void out();
	void getData(String msg);
	
	default void print(String ...msgs){
		for(String msg:msgs){
			System.out.println(msg);
		}
	}
	
	default void test(){
		System.out.println("默認的test方法");
				
	}
	
	static String staticTest(){
		return "接口類的方法";
	}
	
}

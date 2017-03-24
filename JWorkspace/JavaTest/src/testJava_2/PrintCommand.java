package testJava_2;

public class PrintCommand implements Command {
	public void process(int[] target){
		for(int tmp:target){
			System.out.println("迭代輸出目標數組:"+tmp);
		}
	}
	
	
}

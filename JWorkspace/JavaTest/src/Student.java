
public class Student {

	int score=80;
	
	public void play(int hours){
		
		score = score - hours;
		System.out.println("玩樂  " + hours + " hour; " + " score: " + score);
	}
	
	public void study(int hours){
		score = score + hours;
		System.out.println("讀書  " + hours + " hour; " + " score: "+ score);
	}
	
	public static void main(String[] args) {
		
		Student st = new Student();
		st.play(3);
		st.study(5);
		
	}
	
	
	
	
}

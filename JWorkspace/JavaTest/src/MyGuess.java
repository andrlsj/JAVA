import java.util.Scanner;

public class MyGuess {

	public static void main(String[] args) {
		
		Scanner con = new Scanner(System.in);
		
		int number = (int)(Math.random()*10);
		int guess;
		System.out.println("答案: "+ number);
		
		
		System.out.println("猜10以下數字");
		do{
			guess = con.nextInt();
		
		}while(guess != number);
		
		System.out.println("猜中！");
	}
	
	
	
}

package ch04;

/*
 * Switch - case應用與示範
 * JDK 7以後switch - case也可進行字串比對
 */
public class TestSwitchCase {

	public static void main(String[] args) {
		int n = 10; // 10 20 30

		switch (n) {
		case 10:
			System.out.println("n 的值是 10");
			break;
		case 20:
			System.out.println("n 的值是 20");
			break;
		default:
			System.out.println("n 的值不是 10 也不是 20");
		}

		System.out.println("我仍有執行到!");
		
		System.out.println("===========================");
		
		int m = 10;
		switch(m){
		case 10:
			System.out.println("m is 10");
			break;
		case 20:
			System.out.println("m is 20");
			break;			
		default:
			System.out.println("^^");
		}
		System.out.println("here I go~");
		
		System.out.println("===========================");
		
		char p = 'a';
		switch(p){
		
		case 'a':
			System.out.println("a");
			break;
		case 'A':
			System.out.println("A");
			break;
		default:
			System.out.println("^^");
		}	
		
		System.out.println("===========================");	
		
		String season = "summer";
		switch(season){
		
		case "spring":
			System.out.println("spring");
			break;
		case "summer":
			System.out.println("summer");
			break;
		default:
			System.out.println(" ^^ ");	
		}
		
		}
				
	}



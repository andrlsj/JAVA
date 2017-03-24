
public class TestChristTree {

	public static void main(String[] args) {
		 for (int i = 1; i < 8; i++) {
			   for (int j = 8; j >= i; j--) {
			    System.out.print(" ");
			   }
			   for (int k = 1; k <= 2 * i - 1; k++) {
			    System.out.print("*");
			   }
			   System.out.println();
			  }
			  
			  for (int a = 1; a <= 4; a++) {
			   for (int b = 1; b < 8; b++) {
			    System.out.print(" ");
			   }
			   System.out.println("**");
			  }
			 }

	}



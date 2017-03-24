package testJava_1;

enum Month{
	JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;	
}

public class EnumMonth {

	public static void main(String[] args) {
		
		for(Month m:Month.values()){
			System.out.print(" "+ m);
		}
		
		
		
	}

}

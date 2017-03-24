package ch05;
/*
 * 此範例為while迴圈測試
 */
public class TestWhile {

	public static void main(String[] args) {
		int i = 100;

		while (i <= 10) {
			System.out.println(i);
			i++;
		}

		System.out.println("------------------------------");

		int count = 1;
		while (count++ < 5){
			System.out.println("count = " + count);
		}
		
		System.out.println("------------------------------");
		String love = "Love";
		int n = 1;
		while(n <5){
			System.out.println(love);
			n++;
		}
		
		
		
	}

}

import java.util.HashSet;
import java.util.Set;

public class GuessNumber {

	public static void main(String[] args) {

		Set set = new HashSet<>();

		
		while(set.size()<6){
			
			set.add((int) (Math.random() * 49) + 1);
		}
		
		
		
		System.out.println(set);

	}

}

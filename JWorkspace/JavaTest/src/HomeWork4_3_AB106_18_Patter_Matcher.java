import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork4_3_AB106_18_Patter_Matcher {

	public static void main(String[] args) {

		String[] strings = { "mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune" };
		String stars = String.join("", strings);
		
		Pattern p1 = Pattern.compile("[aeiou]");
		Matcher m1 = p1.matcher(stars);
		
		int count=0;
		while(m1.find()){
			count +=1;
		}
		
		System.out.println("母音共計有: " + count);
	}
}

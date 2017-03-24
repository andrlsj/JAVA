package testJava_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTestStar {

	public static void main(String[] args) {
		String[] strings = { "mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune" };
		String stars = String.join("", strings);
		
		Pattern p1 = Pattern.compile("[aeiou]");
		Matcher m1 = p1.matcher(stars);
		
		int count=0;
		while(m1.find()){
			count +=1;
		}
		
		System.out.println("\n"+count);
		

	}

}

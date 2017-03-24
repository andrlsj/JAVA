package testJava_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatternStartEnd {

	public static void main(String[] args) {
		
		String str = "Java is very funny";
		System.out.println("target: "+ str);
		
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()){
			System.out.println(matcher.group()+" start from " + matcher.start()+" end with :" + matcher.end());
			
			
		}
		
		
	}

}

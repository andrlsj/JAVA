import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDiamond {
	
	public static void main(String[] args) {
		List<String> an = new ArrayList<>();
		an.add("cat");
		an.add("cat and dog");
		an.forEach(ele -> System.out.println(ele.length()));
		an.forEach(a -> System.out.println(a.length()));
		
		
		Map<String,List<String>> schoolsInfo = new HashMap<>();
		List<String>schools = new ArrayList<>();
		schools.add("斜月三星洞");
		schools.add("西天取佛經");
		schoolsInfo.put("孫悟空",schools);
		
		schoolsInfo.forEach((key,value)->System.out.println(key+ "->"+value));
		
		
		
	}
	
	
	
	
	
}

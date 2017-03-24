import java.util.ArrayList;
import java.util.List;

public class MyGenericList {

	public static void main(String[] argse){
		
		List<String> strList = new ArrayList<String>();
		strList.add("cat and dog");
		strList.add("dog");
		//strList.add(38);
		
		strList.forEach(str -> System.out.println(str.length()));
		
	}
	
	
	
}

package testJava_1;

import java.util.*;

public class GenericList {

	public static void main(String[] args) {

		List<String> data = new ArrayList();
		data.add("Hello");
		data.add("world");
		
		Iterator<String> it = data.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		
		
		
		
		
		
	}

}

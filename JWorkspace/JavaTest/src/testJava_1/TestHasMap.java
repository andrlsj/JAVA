package testJava_1;

import java.util.*;

public class TestHasMap {
	
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("one",new Integer(1));
		map.put("two", "2");
		map.put("three", new Float(3.0));
		
		System.out.println(map.get("one"));
		System.out.println(map.get("two"));
		System.out.println(map.get("three"));
		
		Set set = map.keySet();
		
		Iterator it = set.iterator();
		while(it.hasNext()){
			Object myKey = it.next(); 
			System.out.println(myKey + "=" + map.get(myKey));
		}
		
		System.out.println("=============");
		
		for(Object obj:set){
			System.out.print(obj + " ");
		}
		
		
		
		
		
		
	}
	
	
}

package testJava_1;

import java.util.*;

public class TestHashSet {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(new Integer(12));
		set.add(new Long(34L));
		set.add(new Double(5.6));
		set.add("Hello");
		set.add("Hello");
		
		Iterator objs = set.iterator();
		while(objs.hasNext()){
			System.out.print(objs.next()+" ");
		}
		System.out.println("\n"+"================"+"\n");
		
		for(Object obj:set){
			System.out.print(obj+" ");
		}
		
		
	}
	
	
}

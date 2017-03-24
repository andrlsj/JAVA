package idv.david.additional.sort;

import java.util.*;

public class TestLinkedHashSet {
	public static void main(String args[]) {
		Set set = new LinkedHashSet();
		set.add(new Integer(56));
		set.add(new Integer(34));
		set.add(new Integer(12));

		Iterator objs = set.iterator();
		while (objs.hasNext())
			System.out.println(objs.next());
		
		System.out.println("===========");
		
		Set set2 = new HashSet();
		set2.add(new Integer(56));
		set2.add(new Integer(34));
		set2.add(new Integer(12));
		 
		Iterator objs2 = set2.iterator();
		while(objs2.hasNext())
		    System.out.println(objs2.next());
	}
}

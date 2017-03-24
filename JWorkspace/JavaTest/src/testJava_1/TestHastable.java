package testJava_1;

import java.util.*;

public class TestHastable {

	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		
		ht.put("one",new Integer(1));
		ht.put("two","2");
		ht.put("three",new Float(3.0));
		
		Integer iv = (int)ht.get("one");
		String sv = (String)ht.get("two");
		Float fv = (float)ht.get("three");
		
		System.out.println(iv+ " " + sv + " "+ fv +" ");
	}

}

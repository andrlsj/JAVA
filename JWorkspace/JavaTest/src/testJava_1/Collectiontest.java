package testJava_1;

import java.util.*;

public class Collectiontest {

	public static void main(String[] args) {
		
		Collection c = new ArrayList();
		List l = new ArrayList();
		
		c.add("貓狗大戰");
		c.add(new Integer(12));
		c.add(12);
		System.out.println(c.size());
		c.remove(12); //只刪除第一個符合條件的元素
		System.out.println(c.size());
		System.out.println(c.contains(12));//true
		System.out.println(c.contains("12"));//false
		
		Collection books = new HashSet<>();
		books.add("JAVA_EE");
		books.add("CrazyJava");
		
		System.out.println(c.containsAll(books));//false
		System.out.println(books.containsAll(books));//true
		
		books.forEach(obj -> System.out.println(obj));
		
		Iterator it = books.iterator();
		System.out.println("=================");
		while(it.hasNext()){
		String book = (String)it.next();
		System.out.println(book);
		
		
		}
		
		
		
		
		
		
	}

}

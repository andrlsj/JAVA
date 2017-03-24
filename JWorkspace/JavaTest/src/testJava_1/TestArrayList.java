package testJava_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		
		List lt = new ArrayList();
		lt.add(new Integer(12));
		lt.add(new Long(34L));
		lt.add(new Double(5.6));
		lt.add("Hello");
		lt.add("hello");
		
		System.out.println("show "+ lt);
		System.out.println("elements "+lt.size());
		
		System.out.println("=====================");
		Iterator objs = lt.iterator();
		while(objs.hasNext()){
			System.out.print(objs.next()+" ");
		}
		System.out.println("\n"+"====================="+" \n");
		for(int i =0;i<lt.size();i++){
			Object obj = lt.get(i);
			System.out.print(obj+" ");
		}
		System.out.println("\n"+"====================="+"\n");
		for(Object o:lt){
			System.out.print(o+" ");
		}
		
		
	}

}

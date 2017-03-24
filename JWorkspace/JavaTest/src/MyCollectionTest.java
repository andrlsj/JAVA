import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class MyCollectionTest {
	
	public static void main(String[] args){
		
		Collection c = new ArrayList();
		c.add("Monkey");
		c.add(6);
		System.out.println(c.size());
		c.remove(6);
		System.out.println(c.size());
		System.out.println(c.contains("Monkey"));//there is a "monkey" in the ArrayList(Collection)
		c.add("cat");
		System.out.println(c);//[Monkey, cat]
		System.out.println("===============");
		
		Collection aa = new HashSet();//[cat, dog]
		aa.add("dog");
		aa.add("cat");
		System.out.println(aa);
		System.out.println(c.containsAll(aa));//c vs aa ->false
		
		c.removeAll(aa);
		System.out.println(c);//[Monkey]
		
		c.clear();
		System.out.println(c);
		
		aa.retainAll(c);
		System.out.println(aa);
		
		
		
		
		
	}
	
	
	

}

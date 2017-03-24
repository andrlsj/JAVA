import java.util.ArrayList;
import java.util.List;

public class MyListTest {

	public static void main(String[] args){
	
		List a = new ArrayList();
		
		a.add(new String("cat"));
		a.add(new String("dog"));
		a.add(new String("monkey"));
		System.out.println(a);//[cat, dog, monkey]
		
		a.add(1, new String("lion"));
		
		for(int i =0; i<a.size();i++){
			
			System.out.println(a.get(i));
		
		}
		
		a.remove(2);
		System.out.println(a);// remove dog ->[cat, lion, monkey]
		System.out.println(a.indexOf("lion"));//1 ->2nd
		
		a.set(1, "goat");
		System.out.println(a);//[cat, goat, monkey]
		
		System.out.println(a.subList(1,2));//[goat]
		
		
		
	}
}

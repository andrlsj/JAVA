import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HomeWork8_01_AB106_18 {
//	請建立一個Collection物件並將以下資料加入:
//		- new Integer(100)
//		- new Double(3.14)
//		- new Long(21L)
//		- new Short(“100”)
//		- new Double(5.1)
//		- “Kitty”
//		- new Integer(100)
//		- new Object()
//		- “Snoopy”
//		- new BigInteger(“1000”)
//	印出這個物件裡的所有元素(使用Iterator, 傳統for與增強for)
//	• 移除不是java.lang.Number家族的物件
//	• 再次印出這個集合物件的所有元素,觀察是否已將非Number家族的物件移除成功
	
	public static void main(String[] args) {
		
		List data = new ArrayList();
		data.add(new Integer(100));
		data.add(new Double(3.14));
		data.add(new Long(21L));
		data.add(new Short("100"));
		data.add(new Double(5.1));
		data.add(new String("Kitty"));
		data.add(new Integer(100));
		data.add(new Object());
		data.add(new String("Snoopy"));
		data.add(new BigInteger("1000"));
		System.out.println("//增強型");
		//增強型
		for(Object obj:data){
			System.out.print(obj + " ");
		}
		System.out.println("\n"+"//傳統"+ " ");
		//傳統
		for(int i =0;i<data.size();i++){			
			System.out.print(data.get(i)+ " ");
		}
		//Iterator
		System.out.println("\n"+"//迭代 Iterator"+ " ");
		Iterator it = data.iterator();
		while(it.hasNext()){			
			System.out.print(it.next() + " ");
		}
		//Iterator with lambda
		Iterator itl = data.iterator();
		itl.forEachRemaining(obj->{System.out.print(obj);});

		
		System.out.println("\n"+"方法一 用removeif ");
		data.removeIf(ele -> !(ele instanceof Number));
		System.out.println(data);
	
		List newData = new ArrayList();
		for(int i = 0;i<data.size();i++){
			if(data.get(i) instanceof Number){
				newData.add(data.get(i));
			}		
		}
		System.out.println("方法二 用新設集合放合條件物件");
		//已將非Number家族的物件移除成功
		for(Object n:newData){
			System.out.print(n + " ");
		}
		
		
		
		
	}
	
}

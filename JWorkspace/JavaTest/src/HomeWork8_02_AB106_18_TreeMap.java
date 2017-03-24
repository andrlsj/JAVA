import java.util.*;

public class HomeWork8_02_AB106_18_TreeMap {

	public static void main(String[] args)  {
		//設計對應的getter/setter方法,並透過建構子產生以下7個Train的物件,放到每小題需使用的集合裡
		//  (202, “普悠瑪”, “樹林”, “花蓮”, 400)
		//- (1254, “區間”, “屏東”, “基隆”, 700)
		//- (118, “自強”, “高雄”, “台北”, 500)
		//- (1288, “區間”, “新竹”, “基隆”, 400)
		//- (122, “自強”, “台中”, “花蓮”, 600)
		//- (1222, “區間”, “樹林”, 七堵, 300)
		//- (1254, “區間”, “屏東”, “基隆”, 700)
				
		Train train1 = new Train(202,"普悠瑪","樹林","花蓮",400.0);
		Train train2 = new Train(1254,"區間","屏東","基隆",700.0);
		Train train3 = new Train(118,"自強","高雄","台北",500.0);
		Train train4 = new Train(1288,"區間","新竹","基隆",400.0);
		Train train5 = new Train(122,"自強","台中","花蓮",600.0);
		Train train6 = new Train(1222,"區間","樹林","七堵",300.0);
		Train train7 = new Train(1254,"區間","屏東","基隆",700.0);
		
		//請寫一隻程式,能讓台鐵安排車次的人員取得不會重覆的Train物件(請分別用Iterator與for迴圈取值)		
		Map list = new TreeMap<>();
		list.put(train1.getNumber(),train1);
		list.put(train2.getNumber(),train2);
		list.put(train3.getNumber(),train3);
		list.put(train4.getNumber(),train4);
		list.put(train5.getNumber(),train5);
		list.put(train6.getNumber(),train6);
		list.put(train7.getNumber(),train7);
			
		System.out.println("for迴圈取值");
		Collection clist = list.values();
				
		for(Object obj:clist){
			System.out.print(obj + " ");
		}
				
		System.out.println("\n"+"================");
		System.out.println("Iterator取值");
		Iterator it = clist.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		// 承上,Train物件不會重覆之外,還能讓班次編號  **由大排到小列出
		
		System.out.println("\n"+"======================");
		Set set = list.keySet();
		
		List cl = new ArrayList<>(set);
		Collections.reverse(cl);		
		
		System.out.println("班線排序");
		for( Object obj:cl){
			System.out.print(obj+" ");
		}
		
		// 因應年假人潮,台鐵要再加開一個車次(116, “自強”, “高雄”, “台北”,500)在原本7個車次的後面,
		// 承上,有哪些取值的方式能得到這8個Train的物件
		
		
		
		
		
		
		
		}
}

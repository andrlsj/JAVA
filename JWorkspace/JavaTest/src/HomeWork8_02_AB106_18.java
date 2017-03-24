import java.util.*;

public class HomeWork8_02_AB106_18 {

	public static void main(String[] args) {
		// 設計對應的getter/setter方法,並透過建構子產生以下7個Train的物件,放到每小題需使用的集合裡
		Train train1 = new Train(202, "普悠瑪", "樹林", "花蓮", 400.0);
		Train train2 = new Train(1254, "區間", "屏東", "基隆", 700.0);
		Train train3 = new Train(118, "自強", "高雄", "台北", 500.0);
		Train train4 = new Train(1288, "區間", "新竹", "基隆", 400.0);
		Train train5 = new Train(122, "自強", "台中", "花蓮", 600.0);
		Train train6 = new Train(1222, "區間", "樹林", "七堵", 300.0);
		Train train7 = new Train(1254, "區間", "屏東", "基隆", 700.0);

		// 請寫一隻程式,能讓台鐵安排車次的人員取得不會重覆的Train物件(請分別用Iterator與for迴圈取值)
		Set trains = new HashSet();
		
		trains.add(train1);
		trains.add(train2);
		trains.add(train3);
		trains.add(train4);
		trains.add(train5);
		trains.add(train6);
		trains.add(train7);
		
		System.out.println("======for enhance=======");
		for (Object obj : trains) {
			System.out.print(obj+ " ");
		}
		System.out.println("\n"+ "=======Iterator======");
		
		Iterator it = trains.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		
		// 承上,Train物件不會重覆之外,還能讓班次編號  **由大排到小列出
		System.out.println("\n" +"=======物件大到小========");
		List<Train> cl = new ArrayList<>(trains);
		Collections.sort(cl);
		Collections.reverse(cl);
		
		for(int i = 0;i<cl.size();i++){
			System.out.print(cl.get(i).getNumber()+" ");
			System.out.print(cl.get(i).getType()+" ");
			System.out.print(cl.get(i).getStart()+" ");
			System.out.print(cl.get(i).getDest()+" ");
			System.out.print(cl.get(i).getPrice()+" ");
			System.out.println();
		}
		// 因應年假人潮,台鐵要再加開一個車次(116, “自強”, “高雄”, “台北”,500)在原本7個車次的後面,
		
		Train train8 = new Train(116, "自強", "高雄", "台北", 500.0);
		cl.add(train8);
				
		// 承上,有哪些取值的方式能得到這8個Train的物件
		System.out.println("\n"+"===for each====");
		for(Object obj:cl){
			System.out.print(obj + " ");
		}
		System.out.println("\n"+"===Iterator====");
		Iterator<Train> its = cl.iterator();
		while(its.hasNext()){
			System.out.print(its.next() +" ");
		}
		System.out.println("\n"+"===for====");
		for(int i =0;i<cl.size();i++){
			System.out.print(cl.get(i) +" ");
		}
		
		for(int i = 0;i<cl.size();i++){
			System.out.print(cl.get(i).getNumber()+" ");
			System.out.print(cl.get(i).getType()+" ");
			System.out.print(cl.get(i).getStart()+" ");
			System.out.print(cl.get(i).getDest()+" ");
			System.out.print(cl.get(i).getPrice()+" ");
			System.out.println();
		}
		
	}

}

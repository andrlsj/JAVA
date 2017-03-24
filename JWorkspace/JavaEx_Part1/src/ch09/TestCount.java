package ch09;

public class TestCount {

	public static void main(String[] args) {
		System.out.println("起始數量:" + Count.getTotalCount() + "\n");//以類別，呼叫類別方法

		Count count1 = new Count(); //建立count 實體count1
		System.out.println("累計數量:" + Count.getTotalCount());
		System.out.println("序號:" + count1.getSerialNumber() + "\n");//實體物件呼叫實體方法

		Count count2 = new Count();
		System.out.println("累計數量:" + Count.getTotalCount());
		System.out.println("序號:" + count2.getSerialNumber() + "\n");
	}

}

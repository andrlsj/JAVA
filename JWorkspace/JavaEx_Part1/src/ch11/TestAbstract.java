package ch11;

// 筆類別(父類別)
// 抽象類別
abstract class Pen {//此類為抽象類 另此類對物件屬性 對於其可視類別 隨意調用
	protected String brand; //同package及其子類可調用
	protected double price;

	// 抽象方法
	public abstract void write();//僅為編譯性過關 及 強制繼承之子類進行實作

	public void setdata(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}
}

// 自訂的筆類別(子類別) 繼承Pen
class MyPen extends Pen {
	// 定義抽象類別的動作
	public void write() {
		System.out.print("牌子是： " + brand);
		System.out.println("價格為： " + price);
	}
}

public class TestAbstract {
	public static void main(String args[]) {
		MyPen myPen = new MyPen();
		myPen.setdata("SKB", 10);
		myPen.write();
	}
}

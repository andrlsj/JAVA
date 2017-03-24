package ch09;

public class Count {
	// 產品序號
	private int serialNumber; //私有實體變數

	public int getSerialNumber() {//公開實體方法
		return serialNumber;
	}

	// 產品數量
	private static int counter;//靜態或是類別變數

	public static int getTotalCount() {//靜態或類別方法
		return counter;
	}

	// 建構式
	public Count() {
		counter++;
		serialNumber = 1000 + counter;
	}
}

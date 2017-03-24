package ch05;

class Outer1 {
	static int x = 1;
	int y = 2;
	
	public static class Inner {
		public int z = 3;
		public void show() {
			System.out.println("Outer1.x = " + Outer1.x);// Outer1.x _> x
			//static內部類別無法存取外部類別的實體成員，會編譯失敗
//			System.out.println("Outer1.this.y = " + Outer1.this.y); //Outer1.this.y_>y
			System.out.println("this.z = " + this.z);
		}
	}
}


public class StaticInner {
	public static void main(String[] args) {
		Outer1.Inner inner = new Outer1.Inner();
		inner.show();
	}
}

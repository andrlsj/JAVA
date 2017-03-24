package ch13;

public class TestEquals {
	public static void main(String args[]) {
		Employee e1 = new Employee(7001, "king");
		Employee e2 = new Employee(7001, "king");

		System.out.println("e1==e2 = " + (e1 == e2));
		System.out.println("e1.equals(e2) = " + e1.equals(e2));//若employee把註解取消，則會得到true
		//已改寫方法
	}
}

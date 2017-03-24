package ch05;

public class TestGC {
	public static void main(String args[]) {
		System.out.print("剩餘記憶體:");
		System.out.println(Runtime.getRuntime().freeMemory());
		String str = "Hello World!";
		System.out.print("剩餘記憶體:");
		System.out.println(Runtime.getRuntime().freeMemory());

		System.out.println("強制進行垃圾收集");
		System.gc();

		System.out.print("剩餘記憶體:");
		System.out.println(Runtime.getRuntime().freeMemory());
	}
}

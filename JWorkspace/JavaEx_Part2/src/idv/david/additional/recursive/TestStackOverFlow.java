package idv.david.additional.recursive;

public class TestStackOverFlow {
	
	private int add(int x, int y) {
		return add(x, ++y);
	}
	
	
	public static void main(String[] args) {
		TestStackOverFlow tsof = new TestStackOverFlow();
		System.out.println(tsof.add(1, 1));
	}

}

package testJava_1;

public class Hello {
	String title;
	int value;

	public Hello() {
		title += " World";
	}

	public Hello(int value) {
		this.value = value;
		title = "Hello";
		//Hello(); //constructor can not calling this way 
	}

	public static void main(String[] args) {

		Hello c = new Hello(5);
		System.out.print(c.title);
	}

}

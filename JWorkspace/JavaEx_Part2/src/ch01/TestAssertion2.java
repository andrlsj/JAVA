package ch01;

public class TestAssertion2 {

	public static void checkVowels(char c) {
		switch (c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.println(c + "是母音");
			break;
		default:
			assert false : "非母音";
		}
	}

	public static void main(String[] args) {
		char ch = 'e';
//		char ch2 = 's';
		checkVowels(ch);
	}

}

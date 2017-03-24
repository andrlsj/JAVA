package testJava_1;

class Book<T>{
	T price;
	public static void show(Book<? extends Number> b){
		System.out.println(b.price);
	}
}

public class GenericAdv {

	public static void main(String[] args) {
		Book<Integer> book = new Book();
		book.price = 580;
		Book.show(book);
		
		
		
	}

}

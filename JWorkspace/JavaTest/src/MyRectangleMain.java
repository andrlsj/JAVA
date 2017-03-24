
public class MyRectangleMain {
	// (1) 使用public MyRectangle()建構子建立物件,設定width, depth為10, 20,透過getArea()印出結果
	// (2) 使用public MyRectangle(double width, double depth)建構子建立物件,設定width,
	// depth為10, 20,
	// 透過getArea()印出結果

	public static void main(String[] args) {

		MyRectangle rect = new MyRectangle();

		rect.setWidth(10.0);
		rect.setDepth(20.0);
		rect.getArea();
		System.out.println(rect.getArea());

		MyRectangle rect1 = new MyRectangle(10.0, 20.0);
		System.out.println(rect1.getArea());

	}

}

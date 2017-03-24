package testJava_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalTest1 {
	// 請設計兩個類別CalException.java與CalTest.java,在CalTest.java裡有個自
	// 訂方法為powerXY(int x, int y),功能是會計算x的y次方並回傳結果。使用者
	// 可以輸入x與y的值,請加入例外處理機制,讓程式能解決以下狀況:
	// 1. x與y同時為0,(產生CalException的例外物件)
	// 2. y為負值,而導致x的y次方結果不為整數
	// 3. x與y皆正確情況下,會顯示運算後結果

	private int x;
	private int y;

	// setter & getter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// constructor
	public CalTest1(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public CalTest1() {

	}

	// method
	public int power(int x, int y) throws CalException {

		if (x == 0 && y == 0) {
			throw new CalException("0的0次沒有意義");
		} else if (y < 0) {

			throw new CalException("次方為負值，結果回傳不為整數");
		} else {
			return (int) Math.pow(x, y);
		}
	}

	public static void main(String[] args) {

		CalTest1 ct = new CalTest1();
		Scanner sc = new Scanner(System.in);

		try 
		{
			System.out.println("請輸入x的值");
			int xValue = sc.nextInt();
			System.out.println("請輸入y的值");
			int yValue = sc.nextInt();
			System.out.println(ct.power(xValue, yValue));
		}
		catch (CalException ce) 
		{
			System.out.println(ce.getMessage());
			ce.printStackTrace();
		} 
		catch (InputMismatchException e) 
		{
			System.out.println("格式不正確");
		} 
		finally 
		{
			sc.close();
		}

	}

}

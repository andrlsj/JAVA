package testJava_1;

import java.util.Scanner;

public class IDNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("please key in your ID number");
		String idNum = sc.next();
		String reg = "[a-zA-Z][12]{1}[0-9]{8}";
		
		if(idNum.matches(reg)){
			System.out.println("GJ");
		}else{
			System.out.println("BB");
		}
		
		
		
		
		
	}

}

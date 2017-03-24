import java.util.Arrays;

import sun.awt.image.PNGImageDecoder.Chromaticities;

public class MyArrayWord {

	public static void main(String[] args) {
		
		char[] cat = {'c','a','t'};
		for(char a:cat){
			System.out.print(a);
		}
		String s = "dogandcat"; 
		char a = s.charAt(0);
		System.out.println("\n"+ a);
		
		char[] c = new char[s.length()];
		for(int i =0;i<s.length();i++){
			c[i]=s.charAt(i);
		}
		
		for(char b:c){
		System.out.print(b);
		}
		
		String sc = Arrays.toString(cat);
		System.out.println("\n" + sc);
		
		String[] animal = {"monkey","dog","mar"};
		
		animal[0].toCharArray();
		
		for(char d:animal[0].toCharArray()){
			System.out.print(d);
		}
		
		
		
		
	}
	
	
}

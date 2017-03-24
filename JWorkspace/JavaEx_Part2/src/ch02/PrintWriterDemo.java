package ch02;

// Demonstrate PrintWriter

import java.io.*;

public class PrintWriterDemo {
	public static void main(String args[]) {
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("This is a string");
		int i = -7;
		out.println(i);
		double d = 4.5e-7;
		out.println(d);
		
		
		
	}
}
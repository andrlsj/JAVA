package testJava_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileLockInterruptionException;

public class MyFileInputstram {

	public static void main(String[] args) {
		int readed;
		
		FileInputStream fis = null;
		BufferedReader br = null;
		
		try {
			
			fis = new FileInputStream("c:\\javawork\\sample.txt");
			while((readed=fis.read())>0){
				System.out.print((char)readed);
			}
			
		} catch (Exception e) {
			
		}
		
		
		
	}

}

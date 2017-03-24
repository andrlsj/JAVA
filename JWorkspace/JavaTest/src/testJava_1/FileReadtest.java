package testJava_1;

import java.io.FileReader;
import java.io.IOException;

public class FileReadtest {

	public static void main(String[] args) throws IOException{
		
		try{
			FileReader fr = new FileReader("c:\\javawork\\Sample.txt");
			
			char[] cbuf = new char[32];
			int hasread = 0;
			
			while((hasread=fr.read(cbuf))>0){
				System.out.println(new String(cbuf,0,hasread));
			}
	
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}
		
		
	}

}

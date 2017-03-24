package testJava_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

	public static void main(String[] args) {
		
		int readed=0;
		try{
	//		FileReader fr = new FileReader("c:\\javawork\\Sample.txt");
	//		
	//		while((readed=fr.read())>0 ){
	//			System.out.print((char)readed);
	//		}
			
//			FileReader fr = new FileReader("c:\\javawork\\sample.txt");
//			BufferedReader br = new BufferedReader(fr);//使用BUFFEREDREADER更快速
//			while((readed=br.read())>0){
//				System.out.print((char)readed);
//			}
//			
//			br.close();
//			fr.close();
			
			String readeds;
			FileReader fr = new FileReader("c:\\javawork\\sample.txt");
			BufferedReader br = new BufferedReader(fr);
			while((readeds=br.readLine()) != null){
				System.out.println(readeds);
				
			}
			
			
			
			
			
		}catch(IOException ie){
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
				
		
		
		
		
		
	}

}

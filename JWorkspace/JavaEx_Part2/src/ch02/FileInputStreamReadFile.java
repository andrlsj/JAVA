package ch02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamReadFile {
	public static void main(String args[]) {
		int i;
			FileInputStream fis =null;
			BufferedInputStream bis = null;
		try {

//			FileInputStream fis = new FileInputStream("c:\\javawork\\hello.txt");
//			while ((i = fis.read()) != -1)
//				System.out.print((char) i);
//			fis.close();

			fis = new FileInputStream("c:\\javawork\\hello.txt");
			bis = new BufferedInputStream(fis);//緩沖引入接管 預設8kb
			while ((i = bis.read()) != -1)
				System.out.print((char) i);

		} catch (IOException e) {
			
		}finally{
			
			try {
				bis.close();
				fis.close();
				//偷個懶 不作null值檢定
			} catch (IOException e2) {
				
			}
		}
	}
}

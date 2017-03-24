package ch02;

import java.io.*;
import java.net.*;

public class GetNatalieFromInternet {

	public static void main(String[] args) {
		
		File dir = new File("c:\\jpegs");
		//File dir = new File("/Users/hangermo/Desktop/Images");//for mac
		
		if (!dir.exists()) {//資料匣建立
			dir.mkdir();
		}
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		for (int i = 1; i <= 42; i++) {
			
			String url = "http://www.space-fox.com/wallpapers/celebs/natalie-portman" + 
					"/natalie_portman_" + i	+ ".jpg";
			
			String filename = url.substring(url.lastIndexOf("/") + 1);
			
			File file = new File(dir, filename);
			
			try {
				URL myURL = new URL(url);
				HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
				bis = new BufferedInputStream(conn.getInputStream());
				bos = new BufferedOutputStream(new FileOutputStream(file));
				
				System.out.println("Wallpaper: " + filename + " kick-off!");

				int length = 0;
				byte[] b = new byte[8192];//緩沖區空間定義 也就是 最大陣列個數
				while ((length = bis.read(b)) != -1)
					bos.write(b, 0, length);
				bos.flush();
				bos.close();
				System.out.println(filename + " Done!");

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

package ch04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetNatalieTest implements Runnable{
	
	private static int i=0;
	
	public static void main(String[] args) {
		GetNatalieTest gnt = new GetNatalieTest();
		
		for(i=0;i<50;i++){
		Thread t = new Thread(gnt);
		t.start();
		}

	}

	public void run() {
		
		File dir = new File("c:\\jpegs");
		String url = "http://www.space-fox.com/wallpapers/celebs/natalie-portman" + 
				"/natalie_portman_" + i	+ ".jpg";
		if (!dir.exists()) {//資料匣建立
			dir.mkdir();
		}
		String filename = url.substring(url.lastIndexOf("/") + 1);
		
		File file = new File(dir, filename);
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
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

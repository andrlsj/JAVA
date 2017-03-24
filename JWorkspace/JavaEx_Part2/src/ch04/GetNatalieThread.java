package ch04;

import java.io.*;
import java.net.*;

public class GetNatalieThread implements Runnable {
	private File dir;
	private String url;
	
	public GetNatalieThread(File dir, String url) {
		this.dir = dir;
		this.url = url;
	}
	
	@Override
	public void run() {
		String filename = url.substring(url.lastIndexOf("/") + 1);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		File file = new File(dir, filename);
		
		try {
			URL myURL = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
			bis = new BufferedInputStream(conn.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(file));

			System.out.println("Wallpaper: " + filename + " kick-off!");

			int length = 0;
			byte[] b = new byte[8192];
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

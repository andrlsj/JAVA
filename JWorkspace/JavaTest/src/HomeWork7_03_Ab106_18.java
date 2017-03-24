import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class HomeWork7_03_Ab106_18 {
	// 請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt
	// 的檔案裡 (請參考本章講義第23頁,使用append方式觀察效果)

	public static void main(String[] args) {
		
		HWRadnom1000 hw = new HWRadnom1000();
		int[] rans = hw.makeRandom();
		
		try {
		
		File file = new File("c:\\Data");
		if(!file.exists()){
			file.mkdir();
		}
			
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:\\data\\data.txt",true));	
		
		oos.writeObject(rans);	
			
			
		} catch (Exception e) {
			
		}
		
	
		
		
		
		
	}
}

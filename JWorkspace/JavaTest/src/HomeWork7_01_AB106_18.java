import java.io.*;

public class HomeWork7_01_AB106_18 {
	//請寫一個程式,可以在讀入一個檔案後,顯示有多少個位元組
		
	public void showFileSize(File f){
		
		System.out.println(f.length()+" bytes");
		
	}
	 
	
	public static void main(String[] args) {
		
		File someFile = new File("c:/javawork/TQC+Java_1_5.ppt");
		HomeWork7_01_AB106_18 hw = new HomeWork7_01_AB106_18();
		hw.showFileSize(someFile);
	}

}

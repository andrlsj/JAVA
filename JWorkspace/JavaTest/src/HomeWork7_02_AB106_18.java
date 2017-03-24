import java.io.*;


public class HomeWork7_02_AB106_18 {

	// 請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:
	// Sample.txt檔案共有xxx個位元組,yyy個字元,zzz列資料
	// (分別使用FileInputStream, FileReader, BufferedReader處理)

	public void showInfo() throws IOException {
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		FileReader fr = null;
		BufferedReader br = null;
		int countChar = 0, countLine = 0;

		try {
			File myFile = new File("c:/javawork/sample.txt");
			// FileInputStream
			fis = new FileInputStream(myFile);
			isr = new InputStreamReader(fis);//sample.txt utf-8
			int i = 0;
			while ((i = isr.read()) != -1) {
				countChar += 1;
			}
			// FileReader, BufferedReader
			fr = new FileReader(myFile);
			br = new BufferedReader(fr);
			String str;

			while ((str = br.readLine()) != null) {
				countLine += 1;
			}
			// 輸出結果
			System.out.println(
					"檔案大小為: " + myFile.length() + " bytes" + "\n" + "字元: " + 
			countChar + "個" + "\n" + "列數: " + countLine);

		} catch (IOException ie) {

			System.out.println(ie.getMessage());

		} finally {

			br.close();
			fr.close();
			isr.close();
			fis.close();
		}
	}

	public static void main(String[] args) throws IOException {
		HomeWork7_02_AB106_18 hw = new HomeWork7_02_AB106_18();
		hw.showInfo();
	}
}

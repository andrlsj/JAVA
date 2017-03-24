import java.io.*;

public class HomeWork7_04_AB106_18 {

	// 請設計一個方法名為copyFile,這個方法有兩個參數。呼叫此方法時,第一個
	// 參數所代表的檔案會複製到第二個參數代表的檔案

	public void copyFile(File fileA, File fileB) throws IOException {
		FileReader in = null;
		FileWriter out = null;
		try {
			in = new FileReader(fileA);
			out = new FileWriter(fileB);

			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}

		} catch (IOException ie) {
			System.out.println(ie.getMessage());

		} finally {
			in.close();
			out.close();
		}
	}

	public static void main(String[] args) {
		File fileA = new File("c:/javawork/a.txt");
		File fileB = new File("c:/javawork/b.txt");

		HomeWork7_04_AB106_18 hw = new HomeWork7_04_AB106_18();
		try {
			hw.copyFile(fileA, fileB);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

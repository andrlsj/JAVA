import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class HomeWork7_06_AB106_18 {
	// 請寫一個程式,能讀出Object.dat這四個物件,並執行speak()方法
	// 觀察結果如何 (請利用多型簡化本題的程式設計)
	public static void main(String[] args) throws IOException {

		File file = new File("C:\\data\\Object.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			while (true) {
				((CatAndDog) ois.readObject()).speak();
				System.out.println("--------------------");
			}

		} catch (Exception e) {
			// System.out.println(e.getMessage());
			System.out.println("完工");
		}

		ois.close();
		fis.close();
	}

}

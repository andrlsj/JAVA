import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadTxtFile {
	public static void main(String[]args) {
		BufferedReader bReader = null;
		String line;
		FileReader fReader;
		try {
			fReader = new FileReader("c:\\javawork\\上市股票代碼表.txt");
			bReader = new BufferedReader(fReader);
			while((line= bReader.readLine()) != null){
			    System.out.println(line);
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}

	}
}

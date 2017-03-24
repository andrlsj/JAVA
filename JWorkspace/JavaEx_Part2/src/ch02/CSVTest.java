package ch02;
import java.io.*;

public class CSVTest {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\javawork\\Employee.csv");
		
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, "MS950");//*
		//*利用InputStreamReader來進行接口轉換同時指定應用解碼表表號"MS950"->Big5
		
		BufferedReader br = new BufferedReader(isr);
		
		String str;
		while ((str = br.readLine()) != null)
			System.out.println(str);
		
		br.close();
		isr.close();
		fis.close();
	}

}

 import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;

public class ReadCsvFile {
	public static void main(String[]args) {
		try {
			CSVReader csvReader = new CSVReader(new FileReader("c:\\javawork\\103年06月18日成交量前二十名證券.csv"));
			String[] row = null;
			while((row = csvReader.readNext()) != null) {
			    System.out.println(row[0] + "#" + row[1]);
			}
			csvReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

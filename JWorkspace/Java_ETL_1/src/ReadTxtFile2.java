import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadTxtFile2 {
	public static void main(String[]args) {
		try {
			Scanner sc = new Scanner(new File("c:\\javawork\\上市股票代碼表.txt"));
			while(sc.hasNextLine()){
			    String next = sc.nextLine();
			    System.out.println(next);
			}
			sc.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}

	}
}

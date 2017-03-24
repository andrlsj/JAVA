import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ReadFirstColumn {
	public static void main(String[]args) {
		Scanner sc;
		try {
			sc = new Scanner(new File("c:\\javawork\\上市股票代碼表.txt"));
			while(sc.hasNextLine()){
			    String next = sc.nextLine();
			    Scanner sc2 = new Scanner(next);
			    sc2.useDelimiter("\t");
			    System.out.println(sc2.next());
			    sc2.close();
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

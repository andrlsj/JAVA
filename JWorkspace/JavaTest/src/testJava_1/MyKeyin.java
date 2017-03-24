package testJava_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyKeyin {

	public static void main(String[] args) {
		
		try(
		
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr))
		{
				String line = null;		
				while((line=br.readLine()) != null){
				
					if(line.equals("exit")){
					System.exit(1);
					}
					
					System.out.println("輸入內容為: "+line);
				}

		} catch (Exception e) {
			
		}
			
	}
}

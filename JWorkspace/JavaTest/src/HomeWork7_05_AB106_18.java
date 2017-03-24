import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class HomeWork7_05_AB106_18 {
	
	//請寫一支程式,利用老師提供的Dog與Cat類別分別產生兩個物件,寫到
	//C:\data\Object.dat裡。注意物件寫入需注意的事項,若C:\內沒有data資料夾,
	//請用程式新增這個資料夾
	
	public static void main(String[] args) {
		
		File dataFolder = new File("c:\\data");
		if(!dataFolder.exists()){
			dataFolder.mkdir();
		}
		CatAndDog[] cats = new CatAndDog[2];
		cats[0] = new Cat("Big cat");
		cats[1] = new Cat("Small cat");
		
		CatAndDog[] dogs = new CatAndDog[2];
		dogs[0] = new Dog("Black dog");
		dogs[1] = new Dog("White dog");
				
		try {
			FileOutputStream fos = new FileOutputStream("C:\\data\\Object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);				
			for(int i =0; i<cats.length;i++){
				oos.writeObject(cats[i]);	
			}
			for(int i =0; i<dogs.length;i++){
				oos.writeObject(dogs[i]);
			}
			
			System.out.println("物件存入完成");
			
			oos.close();
			fos.close();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		} 
			
			
		
		
		
		
		
		
	}

}

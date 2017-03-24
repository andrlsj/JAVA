
public class MyArrayTest {

	public static void main(String[] args) {
		int arraylist = 3;
		int arraynumber = 3;		
		int[][]x = {{1,2,3},{4,5,6},{7,8,9}};
		int[][]y ={{1,1,1},{2,2,2},{3,3,3}};
		int[][]z = {{1,1,1},{2,2,2},{1,1,1}};
		//x 陣列
		System.out.println("x陣列");
		int[][]x1 = new int[arraylist][arraynumber];
		
		for(int i = 0;i<x1.length;i++){
			
			for(int j=0;j<x1[i].length;j++){
				
				x1[i][j]= (int)(Math.random()*31);
				System.out.print(x1[i][j] + "\t");				
			}			
		System.out.println();
		}
		System.out.println("\n"+"============================");	
		
		//y陣列
		System.out.println("y陣列");
		int[][]y1 = new int[arraylist][arraynumber];
		
		for(int i = 0;i<y1.length;i++){
			
			for(int j=0;j<y1[i].length;j++){
				
				y1[i][j]= (int)(Math.random()*31);
				System.out.print(y1[i][j] + "\t");
			}	
			System.out.println();
		}

		System.out.println("\n"+"============================");		
		//=============================================	
		int sum = 0;
		for(int i = 0; i<x.length;i++){
			for(int j =0; j<y.length;j++){			
				sum = sum + x[i][j];
			}
		}  
		//System.out.println("x[][]加總:" + sum);
		//=============================================			
		
		//z陣列
		System.out.println("z陣列");
		for(int i =0; i<x1.length;i++){

			for(int j=0;j<y1[i].length;j++){				

				z[i][j]= x1[i][j]+y1[i][j];				
				System.out.print(z[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

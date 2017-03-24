
public class MyArrayMethod {

	public static void main(String[] args) {
		
		MyArrayMethod mam = new MyArrayMethod();
		int[][]x = mam.getRandomArray(3, 3);
		mam.printArray(x);
		
		System.out.println("====================");
		
		int[][]y = mam.getRandomArray(3, 3);
		mam.printArray(y);
		
		System.out.println("====================");
		int[][]z = mam.arrayPluse(3, 3, x, y);
		mam.printArray(z);
		
		
		
	}
	
	public int[][] getRandomArray(int r,int n){
		
		int[][] array = new int[r][n];
		
		for(int i = 0; i<array.length;i++){
			
			for(int j = 0;j<array[i].length;j++){
				
				array[i][j] = (int)(Math.random()*31);
			}
		}		
		return array;
	}
	
	public void printArray(int[][] array){
		
		for(int i = 0;i<array.length;i++){
			
			for(int j = 0;j<array[i].length;j++){
				
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	
	public int[][] arrayPluse(int r,int n, int[][] x,int[][] y){
		
		int[][] ap = new int[r][n]; 
		for(int i = 0; i<x.length;i++){
			
			for(int j= 0;j<x[i].length;j++){
				
				ap[i][j] = x[i][j]+y[i][j]; 
			}			
		}
		return ap;
	}
	
	
	
	
}

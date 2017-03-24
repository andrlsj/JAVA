
public class ArrayTest {
	
	public static void main(String[] args) {
		
		int[]scores = {29,100,39,41,50,8,66,77,95,15};
		
		int sum = 0;
		double ave;
		for(int i =0; i<scores.length;i++){
			
			sum += scores[i];			
		}
		ave = sum/scores.length;
		
		for(int i =0; i<scores.length;i++){
			
			if(scores[i]>ave){
				System.out.print(scores[i] + " ");
			}
		}
		
		
		System.out.println("\n"+ "總合:" + sum);
		System.out.println("平均:" + ave);
		
		System.out.println("=================");
		int sum1 =0;
		double ave1;
		for (int i : scores) {
			sum1 += i;
		}		
		ave1 = sum1/scores.length;
		System.out.println(sum1);
		System.out.println(ave1);
		
		System.out.println("=================");
				
	}

	
	
	
}

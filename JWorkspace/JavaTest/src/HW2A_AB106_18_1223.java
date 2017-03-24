
public class HW2A_AB106_18_1223 {

	public static void main(String[] args) {
		//0:使用for迴圈 + for迴圈		
		System.out.println("0:使用for迴圈 + for迴圈");
		int i,j;
		for(i =1 ;i<=9;i++){
			
			for(j=1;j<=9;j++){
			System.out.print(i + "*" + j + "=" + i*j + "\t");
			}			
			System.out.println();
		}
		
		System.out.println("=====================");
		//一:使用for迴圈 + while迴圈
		System.out.println("一:使用for迴圈 + while迴圈");
		int k;
		for(k=1;k<=9;k++){
			int l = 1;
			while(l<=9){
				System.out.print(k + "*" + l + "=" + k*l + "\t");
				l++;
			}
			System.out.println();
		}
		System.out.println("==========================");
		
		//二:使用for迴圈 + do while迴圈		
		System.out.println("二:使用for迴圈 + do while迴圈");
		
		int m;		
		for(m=1;m<=9;m++){

			int n=1;
			do{
				System.out.print(m + "*" + n + "=" + m*n + "\t");
				n++;
			}while(n<=9);
			
			System.out.println();
		}		
		System.out.println("==========================");
		
		//三:使用while迴圈 + do while迴圈
		
		System.out.println("三:使用while迴圈 + do while迴圈");
		int o = 1;
		while(o<=9){
			int p=1;
			do{
				System.out.print(o + "*" + p + "=" + o*p + "\t");	
				p++;
			}while(p<=9);
			o++;
			System.out.println();
		}
	
	}
}

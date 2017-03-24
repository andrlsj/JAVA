
public class MyQuoRem {

	public int gotQuotient(int fNum,int bNum) {
		return (int)fNum/bNum;		
	}
	
	public int gotReminder(int fNum,int bNum) {
		return fNum % bNum;
	}
	
	public int[]  gotQuoRem(int fNum,int bNum) {
		int[] result = {(int)fNum/bNum,fNum % bNum};
		return result; 
	}
	
	
	public static void main(String[] args) {
		
		MyQuoRem mq = new MyQuoRem();
		System.out.println(mq.gotQuotient(100, 50));
		
		System.out.println((int)new MyQuoRem().gotReminder(77, 12));
		
		for(int a:mq.gotQuoRem(77, 12)){
			System.out.print(a+" ");
		}
		
		int[] test = mq.gotQuoRem(88, 15);
		System.out.println("\n"+"商"+test[0]+"餘"+test[1]);
	}
	
	
	

}

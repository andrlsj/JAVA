class AddInt{
	
	int a;
	
	public int vartest(int... c){
		int sum=0;
		
		for(int i=0;i<c.length;i++){
			sum += c[i];
		}
		return sum;
		
	}
	
}


public class MyAddInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddInt add = new AddInt();
		
		int sum = add.vartest(1,2,3);
		System.out.println(sum);
		System.out.println(add.a);
	}

}

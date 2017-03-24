
public class ArrayTestCrazy {

	public static void main(String[] args) {
		
		int[] intArr;
		intArr = new int[]{5,6,8,20};
		
		for(int a:intArr){
			System.out.print(a);
		}
		System.out.println("\n" + "=============");
		
		int[] intArr3;
		intArr3 = new int[]{22,22,33};
		for(int a:intArr3){
			System.out.print(a);
		}
		System.out.println("\n" +"=============");
		
		String[] strArr1 = new String[]{"毛","毛","蟲"};
		for(String a:strArr1){
			System.out.print(a);
			
		}
		System.out.print("\n"+strArr1[0]+strArr1[1]+strArr1[2]);
		System.out.println();
		
		
		Object[] objArr;
		objArr = new String[]{"貓","狗","大戰"};
		for(Object a:objArr){
			System.out.print(a);
		}
		
		
		
		Object[] objArr2;
		objArr2 = new Object[]{"雨","晴"};
		
		

	}

}

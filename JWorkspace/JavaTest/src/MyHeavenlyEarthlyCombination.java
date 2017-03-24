
public class MyHeavenlyEarthlyCombination {
	//甲乙丙丁戊己庚辛壬癸
	//子丑寅卯辰巳午未申酉戌亥
	
	public static void main(String[] args) {
		
		String[] heavens = new String[]{"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
		String[] earths = new String[]{"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
		for(String a:heavens){			
			System.out.print(a+ " ");
		}
		System.out.println("\n" + heavens[0]);
		
		int count;
		for(int i = 0; i <=9 ;i++){	
			System.out.print(heavens[i]);
		}
		System.out.println();
		for(count = 0; count<60 ; count++){
			System.out.print(heavens[count%10] + earths[count%12] + " ");			
		}
		System.out.println("\n" + "count:" + count);
		
		
		
	}
	
	
	
}

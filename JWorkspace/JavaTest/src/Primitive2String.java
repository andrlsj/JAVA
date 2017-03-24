
public class Primitive2String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String intStr = "123";
				
		int it1 = Integer.parseInt(intStr);
		int it2 = new Integer(intStr);
		System.out.println(it2);
		
		String floatStr = "4.556";
		float ft1 = Float.parseFloat(floatStr);
		float ft2 = new Float(floatStr);
		System.out.println(ft2);
		
		String ftStr = String.valueOf(2.3445f);
		String dbStr = String.valueOf(3.344);
		String boolStr = String.valueOf(true);
		System.out.println(boolStr.toUpperCase());
		
		Integer ina = 2;
		Integer inb = 2;
		System.out.println(ina==inb);//true
		
		Integer biga = 128;
		Integer bigb = 128;
		System.out.println(biga==bigb);//false
		
		
		
		
	}

}

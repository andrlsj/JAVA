
public class HWRadnom1000 implements java.io.Serializable{
	
	public int[] makeRandom() {

		int[] ran = new int[10];

		for (int i = 1; i < 10; i++){
			
			ran[i]=(int)(Math.random()*1000)+1;	
			
		}
			return ran;
	}
		
	
}

import java.math.BigDecimal;

public class MyBigDecimal {

	public static void main(String[] args) {
		
		BigDecimal op1 = new BigDecimal("1.0");
		BigDecimal op2 = new BigDecimal("0.8");
		BigDecimal result = op1.subtract(op2);
		
		System.out.println(result);//0.2
		
	}
	
}

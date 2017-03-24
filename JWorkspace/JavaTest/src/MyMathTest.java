
public class MyMathTest {

	public static void main(String[] args){
		
		/*三角運算*/
		System.out.println(Math.toDegrees(Math.PI)); //弧度換成角度 ->180.0
		System.out.println(Math.toRadians(180.0));//將角度換成弧度 ->PI
		
		System.out.println(Math.acos(0.5));//
		System.out.println(Math.acos(0.5));//
		System.out.println(Math.sin(1.57));
		
		/*取整數 */
		System.out.println(Math.floor(1.51));//1.0
		System.out.println(Math.floor(-1.51));//-2.0
		
		System.out.println(Math.ceil(1.51));//2.0
		System.out.println(Math.ceil(-1.51));//-1.0
		
		System.out.println(Math.round(1.51));//2 四捨五入
		/*  乘方 開方 指數運算 */
		
		System.out.println(Math.sqrt(81));//平方根  9
		System.out.println(Math.cbrt(27));//立方根 3
		System.out.println(Math.pow(2, 3));//8
		System.out.println(Math.log(12));
		System.out.println(Math.log10(9));
		/* 計算絕對值 */
		System.out.println(Math.abs(-12.5));
		/*計算最大最小*/
		System.out.println(Math.max(1.2, 5.2));
		System.out.println(Math.min(1.2, 5.2));
		System.out.println(Math.nextAfter(1.2,1.0));
		System.out.println(Math.nextUp(1.2));
		System.out.println(Math.random());
	}
	
	
}


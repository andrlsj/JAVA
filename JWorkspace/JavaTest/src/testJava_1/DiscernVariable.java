package testJava_1;

public class DiscernVariable {

	private String prop="外部";
	
	private class InClass{
		
		private String prop = "內部";
		
		public void info(){
			String pro = "局部變量";
			System.out.println("外部類的實例變量值 "+ DiscernVariable.this.prop);
			
			System.out.println("內部類的實例變量值 " + this.prop);
			
			System.out.println("局部變量值"+prop);
			
		}
		
	}
	
	public void test(){
		InClass in = new InClass();
		in.info();
	}
	
		
	public static void main(String[] args) {
		new DiscernVariable() .test();

	}

}

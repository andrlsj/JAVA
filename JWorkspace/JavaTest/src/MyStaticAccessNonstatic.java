
public class MyStaticAccessNonstatic {

	public void info(){
		System.out.println("info");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MyStaticAccessNonstatic().info();//
		
		MyStaticAccessNonstatic ms = new MyStaticAccessNonstatic();
		ms.info();
		
		
		
	}

}

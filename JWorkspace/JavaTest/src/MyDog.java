
public class MyDog {

	public void jump(){
	
		System.out.println("jump");
	};
	
	public void run(){
	
		this.jump(); //以調用run()的對象作為jump()的調用者
		jump();//省略 this
		System.out.println("run");
	
	};
	
	public static void main(String[] args) {
		
		MyDog md = new MyDog();
		md.run();
		
		
		
	}
	
	
	
	
	
	
	
}

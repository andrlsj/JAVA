package testJava_1;

class Super{
	private int a;
	protected Super(int a){
		this.a= a;
	}
	
}


 class Sub {

	public Sub(int a){
		super();
	}
	
	public Sub(){
		this(5);
	}
	
}

package testJava_2;

abstract class Device{	
	private String name;
	public abstract double getPrice();
	public Device(){}
	public Device(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


public class AnonymousInner {
	public void test(Device d){
		System.out.println("購買一個"+d.getName()+"花掉"+d.getPrice());
	}
	
	public static void main(String[] args) {
		AnonymousInner ai = new AnonymousInner();
		ai.test(new Device ("電子示波器"){

			@Override
			public double getPrice() {
				return 76.8;
			}			
		});
		Device d = new Device(){
			{
				System.out.println("匿名內部類的初始化塊");
			}

			@Override
			public double getPrice() {
				// TODO Auto-generated method stub
				return 56.2;
			}
			@Override
			public String getName(){
				return "鍵盤";
			}			
		};
		
		ai.test(d);
		
	}

}

class Base{
	public double size;
	public String name;
	public Base(double size,String name){
		this.size = size;
		this.name =name;
	}
	
	public Base(){	
	}
}

public class MySub3 extends Base{
	public String color;
	
	public MySub3(double size,String name,String color){
		super(size,name);
		this.color = color;
	}
	public static void main(String[] args) {
		
		MySub3 s = new MySub3(5.6, "target", "red");
		
		System.out.println(s.size +" "+ s.name +" "+ s.color);
		
		
		
	}
	
	
}

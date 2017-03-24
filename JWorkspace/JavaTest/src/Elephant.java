
public class Elephant extends Animal{
	
	private String name;
	
	//constructor
	public Elephant(int age, float weight, String name) {
		super(age, weight);
		this.name = name;
	}
	
	public Elephant(){
		
	}
	
	//setter & getter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//method
	public void speak(){
		super.speak();
		System.out.println("姓名:"+name);
	}

	public static void main(String[] args) {
		
		Animal an1 = new Animal(3,8.0f);
		an1.speak();
		
		Elephant an2 = new Elephant(8,1200.0f,"大象");
		an2.speak();
	}

}

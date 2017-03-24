package testJava_1;

public class Dog implements GetWeightable{
	private String name;
	private double weight;
	
	public Dog() {
		super();
	}

	public Dog(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void getWeightMethod(){
		System.out.println(name + "使用體重計");
	}
	

	
}

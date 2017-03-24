package testJava_1;

public class Powder implements GetWeightable{
	private String color; 
	private double weight;
	
	public Powder() {
		super();
	}
	
	public Powder(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void getWeightMethod(){
		System.out.println("粉末使用天秤");
	}
}

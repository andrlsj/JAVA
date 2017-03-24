package testJava_1;

public class Plane implements GetWeightable{
	private String kind;     // 種類
	private double weight;
	
	public Plane() {
		super();
	}

	public Plane(String kind, double weight) {
		super();
		this.kind = kind;
		this.weight = weight;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void getWeightMethod(){
		System.out.println("飛機使用地秤");
	}
	
	
}

package testJava_1;

public class Cow {
	//basic setting for class
	private double weight;
	public Cow(){};
	public Cow(double weight){
		this.weight= weight;
	}
	//inner class
	private class CowLeg{ //private
		
		//basic setting for class
		private double length;
		private String color;
		
		public CowLeg(){};
		public CowLeg(double length,String color){
			this.length=length;
			this.color=color;
		}
		public double getLength() {
			return length;
		}
		public void setLength(double length) {
			this.length = length;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
		public void info(){
			System.out.println("cow leg now is "+color+" ,長度 is "+length);
			System.out.println("cow leg belong to the cow's weight "+weight);			
		}
	
		
	}
	
	public void test(){
		CowLeg cowleg = new CowLeg(1.12,"black and white");
		cowleg.info();
	}
	
	public static void main(String[] args) {
	
		Cow cow = new Cow(388.2);
		cow.test();
		
		

	}

}


public class Animal {
	
	private int age;
	private float weight;
	
	public Animal(int age,float weight){
		this.age = age;
		this.weight = weight;
	}
	
	public Animal(int age){
		this(age,5.0f);
	}
	
	public Animal(float weight){
		this(2,weight);
	}
	
	public Animal(){
		this(2,5.0F);
	}	
	
	//method
	public void speak(){
		System.out.println("年紀:"+age+ "歲" +", 重量: "+ weight + " 公斤");
	}
	
	//setter & getter method
	public void setAge(int age){		
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setWeight(float weight){
		this.weight = weight;
	}
	
	public float getWeight(){	
		return this.weight;
	}
	
	public void setAgeAndWeight(int age,float weight){
		this.age = age;
		this.weight = weight;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal an1 = new Animal(2, 5.0F);
		an1.speak();
		
		System.out.println("3 years pass");
		
		an1.setAge(5);
		an1.setWeight(30.0F);
		an1.speak();
		
		
	}

}

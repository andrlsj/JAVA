
public abstract class MyBMIAbstractTest {
	
	private double height,weight;
	private String suggest;
	public MyBMIAbstractTest(){
		
	}
	
	public abstract double getHeight();
	public abstract double getWeight();
	
	public String getHealth(){
		double bmi = weight/ Math.pow(height, 2);
		
		if(bmi<18.5){
			suggest = "太瘦";
		}else if (bmi>24){
			
			suggest = "太胖";
		}else{
			suggest = "一般";
		}
		
		return suggest;
	}
	
}

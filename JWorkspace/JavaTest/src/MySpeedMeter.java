
public abstract class MySpeedMeter {
	
	private double turnRate;
	public MySpeedMeter(){
		
	} 

	public abstract double getRadius();//抽象方法
	
	public void setTurnRate(double turnRate){
		this.turnRate = turnRate;
	}
	
	public double getSpeed(){
		return Math.PI * 2 * getRadius() * turnRate;
	}
	
	
	
	
	
	
}

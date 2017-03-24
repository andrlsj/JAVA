
public class MySpeedMeterImpl extends MySpeedMeter{
	
	public double getRadius(){ //實作父類抽象方法
		
		return 0.28;
	}
	
	public static void main(String[] args) {
		
		MySpeedMeterImpl carSpeed = new MySpeedMeterImpl();
		carSpeed.setTurnRate(15);
 		System.out.println(carSpeed.getSpeed());

	}

}

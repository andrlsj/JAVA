
public class MyTestOverLoading {
	
	public static double areaMeasure(double radius){
		return Math.pow(radius, 2)*Math.PI;
	}
	
	public static double areaMeasure(double height,double width){
		return height * width;
	}
	
	public static double areaMeasure(double upper,double bottom,double height){
		return (upper + bottom) * height / 2;
	}
	
	public static void main(String[] args){
		double i = areaMeasure(3.0);
		double j = areaMeasure(3.0,4.0);
		double k = areaMeasure(3.0,4.0,5.0);
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		
	}
	

}

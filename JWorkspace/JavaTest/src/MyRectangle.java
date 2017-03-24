
public class MyRectangle {
	
	private double width;
	private double depth;
	
	//setter & getter
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getDepth() {
		return depth;
	}
	
	public void setDepth(double depth) {
		this.depth = depth;
	}
	
	public double getArea(){
		
		return this.depth*this.width;
		
	}
	
	//constructor
	public MyRectangle(double width, double depth) {
		super();
		this.width = width;
		this.depth = depth;
	}
	
	 public MyRectangle(){
		 
	 }
	
	
	

}

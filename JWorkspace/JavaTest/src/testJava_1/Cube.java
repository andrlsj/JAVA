package testJava_1;

public class Cube {

	//請建立一個正立方體Cube.java檔案,並定義邊長屬性(double length),建構子(Constructor)與getter/setter方法
	//產生一個cube物件並同時傳入邊長值,若是值為0或負數,則拋出自行定義的例外CubeException,並顯示「正立方體邊長不得為0或是
	//負數」的訊息, 若是傳入邊長的值沒有問題,則顯示體積
	
	private double length;

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Cube(double length) {
		super();
		this.length = length;
	}
	
	public Cube(){
		
	}
	
	public void getArea(double length) throws CubeException{	
		
		if(length<=0){
			throw new CubeException("邊長不得小於或等於零");
		}else{
		System.out.println(Math.pow(length,3));
		}
	
	}
	
	public static void main(String[] args) {
		
		Cube cubeArea = new Cube();
		
		try{
		cubeArea.getArea(-1);
		
		}catch(CubeException ce){
			System.out.println(ce.getMessage());
			ce.printStackTrace();
		}
	
		
	}
}

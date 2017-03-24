
public class MintStick {

	String brand;
	double weight;
	String smell;
	int price;
	
	public void info(){
		
		System.out.println(brand + weight + smell + price + "元");
	}
	
	public static void main(String[] args) {
		
		MintStick ms = new MintStick();
		
		ms.brand = "千鳥 ";
		ms.weight =25.0;
		ms.smell = " 茶樹香味 ";
		ms.price = 100;
		
		ms.info();
		
		
	}
	
	
	
}


interface Product{
	int getProductTime();
}


public class MyPrinter implements MyOutput,Product{

	private String[] printData =  new String[MAX_CACHE_LINE];
	private int dataNum = 0;
	
	public void out(){
		while(dataNum>0){
			
			System.out.println("打開打印機:"+printData[0]);
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
		
	}
	
	public void getData(String msg){
		
		if(dataNum >= MAX_CACHE_LINE){
			System.out.println("輸出列已滿 添加失敗");
		}else{
			printData[dataNum++] = msg;
		}
		
	}
	
	public int getProductTime(){
		return 45;
	}
	
	public static void main(String[] args) {
		//page194
		MyOutput o = new MyPrinter();
		o.getData("貓狗大戰");
		o.getData("銀河大戰");
		o.out();
		
		o.getData("狗貓大戰");
		o.getData("星際大戰");
		o.out();
		
		o.print("sun","moon","star");
		o.test();
		
		Product p = new MyPrinter();
		System.out.println(p.getProductTime());
		Object obj = p;
		
	}
	
	
	
}

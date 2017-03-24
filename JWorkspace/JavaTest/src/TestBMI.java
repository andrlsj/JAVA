
public class TestBMI {

	public static void main(String[] args) {
	/*
	 * 請建立一個TestBMI.java,並計算自己的BMI值後輸出,另加入判斷
		結果為過瘦、正常或是過重
		提示一:BMI公式為體重(kg) / 身高2(m)
		提示二:BMI<18.5為過瘦,18.5≦BMI<24為正常、BMI≧24為過胖
		提示三:運算子 + if – else判斷
	*/	
		
		
		double height = 1.8;
		double weight = 70.0;
		double bmi = weight / Math.pow(height, 2);
		
		if(bmi < 18.5){
			System.out.println("過瘦");		
		}else if(18.5<=bmi && bmi<24){
			System.out.println("正常");
		}else{
			System.out.println("過胖");
		}
		
		
		
		
		
	}

}


public class BearBoyAccount {

	private int cashInBank =0;
	int mcount=0;
	int scount=0;
	synchronized public void deposit(int cash){
		 
		while(cashInBank > 3000){
			System.out.println("熊媽看到餘額3000以上，不給存了！");
			try {				
				wait();
			} catch (Exception e) {
				e.getMessage();
			}			
		}
		cashInBank +=cash;
		mcount +=1;	
		System.out.println("熊媽存了"+cash+"帳戶: "+cashInBank+"  熊媽第" +mcount +"次");
		
		
		if(cashInBank>3000){
		System.out.println("熊大被熊媽告知帳戶有錢可以領了!");
		notify();		
		}
	}
	
	synchronized public void withdraw(int cash){
		
		while(cashInBank <cash){
			System.out.println("熊大看到存款不足一千，打電話哀求匯款");
			try {
				wait();
			} catch (Exception e) {	
				e.getMessage();
			}
		}	
			cashInBank -= cash;
			scount +=1;
			 System.out.println("熊大領了一千元，存款餘額"+cashInBank+" 熊大第"+scount+"次");
			 
			 if(cashInBank<=1000){
				 System.out.println("熊大看到存款不足一千，打電話哀求匯款"); 
				 if(cashInBank==0){
				 System.out.println("熊大看到存款沒有錢，暫停提款");
				 notify();
				 System.out.println("熊媽被熊大要求匯款");
				 }
			 }
	
	}	
}

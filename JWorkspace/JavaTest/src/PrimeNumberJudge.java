
public class PrimeNumberJudge {

	

	public void judgePrimeNumber(int number){
		
		 if(number == 2 || number == 3)
		 {
             System.out.println(number+" : "+"質數");
		 }
         int i;
         for(i = 2; i<= Math.sqrt(number); i++)
         {
             if((number % i) == 0)
             {
                 System.out.println(number+" : "+"非質數");
                 break;
             }
         }
         if(i > Math.sqrt(number))
         {
             System.out.println(number+" : "+"質數");
         }
		
		
		
		
		
		
	}
	
	
	
	
	

}

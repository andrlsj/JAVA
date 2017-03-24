package ch09;
/*
 * 此範例為示範static方法使用
 */
public class TestStaticMethod {

	public static void main(String[] args) {
		 System.out.println("請畫三角形!");
         int count = 5;
         
         drawTriangle(count);//省略類別名稱
         
         TestStaticMethod.drawTriangle(count);//完整類別呼叫方法
         
         TestStaticMethod tsm = new TestStaticMethod();
         tsm.drawTriangle1(count);//把類別方法轉為成員方法後 以物件來呼叫
         
         System.out.println("畫的還不錯!");
     }
     
     public static void drawTriangle(int count){//類別方法
         int i, j;
         for ( i = 1; i <= count; i++){
            for ( j = 1; j <= i; j++ )
               System.out.print("*");
            System.out.println();
         }
	}

     public void drawTriangle1(int count){//成員方法
         int i, j;
         for ( i = 1; i <= count; i++){
            for ( j = 1; j <= i; j++ )
               System.out.print("*");
            System.out.println();
         }
	}
     
     
}

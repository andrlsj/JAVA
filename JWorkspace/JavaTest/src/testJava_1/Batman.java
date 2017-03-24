package testJava_1;

public class Batman {
	
	   int squares = 81;

	    public static void main(String[] args) {
	        new Batman().go();
	    }

	    void go() {
	        incr(++squares);// 
	        System.out.println(squares);
	    }

	    void incr(int squares) { //a  //square 方法以自身區域變數優先 若要使用實體變數 須要在前邊加上this
	        squares += 10;
	    }
	
}

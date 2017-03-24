package testJava_1;

public class Cal {
	
	private int x;
	private int y;

	// setter & getter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// constructor
	public Cal(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Cal() {
	}

	// method:check input
	public int[] checkInput(String[] input) throws CalException {
		
		if(input[0].equals("file")|| input[1].equals("exit")){
			System.exit(1);
		}
		
		
		if (input[0].matches(".*[^0-9-]+.*") || input[1].matches(".*[^0-9-]+.*")) {
			//讓 非數字及"-"進入 以報出格式錯誤
			throw new CalException("格式不正確");

		} else if (Integer.parseInt(input[1]) < 0) {
			throw new CalException("次方為負值，結果回傳不為整數");
		}
			
		else if (Integer.parseInt(input[0]) == 0 && Integer.parseInt(input[1]) == 0) {
			throw new CalException("0的0次沒有意義");

		} else {
			return new int[] { Integer.parseInt(input[0]), Integer.parseInt(input[1]) };
		}

	}

	// method:cal power
	public void power(int x, int y) {

		System.out.println((int) Math.pow(x, y));

	}
	
	

}

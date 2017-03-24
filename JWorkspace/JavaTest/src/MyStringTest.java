
public class MyStringTest {

	public static void main(String[] args) {
		
		String s = new String("cat bite dog");
		System.out.println(s.charAt(5));
		
		String s1 = "abcdefghijklmn";
		String s2 = "abcdefghijkn";
		String s3 = "abcdefghijkamn";
		
		System.out.println(s1.compareTo(s2));//3  返回長度長 即"lmn" 3個字元
		System.out.println(s1.compareTo(s3));//相同長度時 返回相異碼差 'l'-'a'
		System.out.println('l'-'a');
		
		System.out.println(s1.concat(s2));//"+"
		
		String s4 = ".org";
		String s5 = "cAt.org";	
		System.out.println(s5.endsWith(s4)); //endwith 以指定字串 作另字串結尾確認
		
		byte[] aa = s5.getBytes();
		System.out.println(s5.getBytes());
		for(Object a: aa){
			System.out.print(a + " " + "\n"); //99 65 116 46 111 114 103 
		}
		
		char bb = 'o';
		System.out.println(s5.indexOf(bb));//'o'在cAt.org第幾個序次 ->4
		
		String s6 = "At";
		System.out.println(s5.indexOf(s6));//"At"在cAt.org第幾個序次->1
		
		System.out.println(s5.length());//長度為7
		
		char c1 = 'a';
		String s8 = s5.replace('A', c1);
		System.out.println(s8);//替換 字元 由A->a
		
		String s9 = s8.toUpperCase();
		System.out.println(s9); //將字串字母全大寫
		
		char c2[] = s5.toCharArray();
		for(char c3:c2){
			System.out.print(c3 + " ");
		}
		
		StringBuilder sb = new StringBuilder();
		String s10 = "cat and dog";
		sb.append(s10);
		System.out.println("\n"+ sb);
		sb.insert(0, "Hello! ");
		System.out.println(sb);//Hello! cat and dog
		System.out.println(sb.indexOf("and"));//11
		System.out.println(sb.length());//18
		System.out.println(sb.capacity());//34 容量
		
		
		
		
		
		
	}
	
	
	
	
	
}

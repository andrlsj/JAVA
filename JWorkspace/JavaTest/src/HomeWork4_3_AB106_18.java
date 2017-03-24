
public class HomeWork4_3_AB106_18 {

	public static void main(String[] args) {

		// 字串陣列如下 (八大行星):{“mercury”, “venus”, “earth”, “mars”, “jupiter”,
		// “saturn”, “uranus”,“neptune”}
		// 請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u) (提示:字元比對,String方法)

		String[] strings = { "mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune" };

		try {

			HomeWork4_3_AB106_18 hw = new HomeWork4_3_AB106_18();
			System.out.println(hw.countVowel(strings));

		} catch (Exception e) {

			System.out.println(e.getMessage());
			
		}

	}

	public int countVowel(String[] strings) {
		int count = 0;
		char[] ae = { 'a', 'e', 'i', 'o', 'u' };
		for (char c : ae) {
			// 以c=母音a來群訪
			for (int i = 0; i < strings.length; i++) {
				// 取出第一文字 mercury
				for (int j = 0; j < strings[i].length(); j++) {
					// 將第一文字 拆開 m e r c u r y後比較
					if (strings[i].charAt(j) == c) {
						count += 1;
					}
				}
			}
		}
		return count;
	}

}

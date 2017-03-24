import java.util.Arrays;

public class HomeWork5_05_AB106_18 {
	// 請設計一個方法void genAuthCode(),當呼叫此方法時,會回傳一個8位數的驗證碼,
	// 此驗證碼內容包含了英文大小寫與數字的亂數組合,如圖:
	public static void main(String[] args) {
		HomeWork5_05_AB106_18 hw = new HomeWork5_05_AB106_18();
		hw.genAuthCode();
	}

	char[] eNum = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Y', 'Z' };
	char[] randNum = new char[8];

	public void genAuthCode() {

		for (int i = 0; i < 8; i++) {
			int random = (int) (Math.random() * (eNum.length));
			randNum[i] = eNum[random - 1];

		}

		System.out.println(Arrays.toString(randNum) + "\n");

		for (char a : randNum) {
			System.out.print(a);
		}
	}

}

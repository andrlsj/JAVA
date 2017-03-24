package Util;

import java.lang.Math;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {
	// 調試時用main函數
	public static void main(String args[]) {
		System.out.println(format(123456789.9999,2));
/*		CurrencyUtil mon = new CurrencyUtil();
		System.out.println(-99999999999999.999
				+ mon.Num2NTStr(-99999999999999.999));
		System.out.println(99999999999999.999 + mon
				.Num2NTStr(99999999999999.999));
		System.out.println(mon.Num2NTStr(100000000.00));
		System.out.println(mon.Num2NTStr(100000001.00));
		System.out.println(mon.Num2NTStr(1234567891.50));
		System.out.println(mon.Num2NTStr(.50));*/
		
//		System.out.println(mon.Num2EngStr(1234567891.50));
//		for(int i=0;i<100;i++)
//			System.out.println(mon.Num2Eng999(i));
//		System.out.println(mon.Num2EngStr(123456789));
//		System.out.println(mon.Num2EngStr(999999999));
//		System.out.println(mon.Num2EngStr(11840.50));
//		System.out.println(mon.Num2EngStr(0.50));
//		System.out.println(mon.Num2EngStr(11292.05));
//		System.out.println(mon.Num2EngStr(11292.01));
	}

	private static CurrencyUtil instance;
	private static int checkedOut = 0;	
	
	private static String[] HanDigiStr = new String[] { "零", "壹", "貳", "叁", "肆", "伍", "陸",
			"柒", "捌", "玖" };
	private static String[] HanDiviStr = new String[] { "", "拾", "佰", "仟", "萬", "拾", "佰", "仟",
			"億", "拾", "佰", "仟", "萬", "拾", "佰", "仟", "億", "拾", "佰", "仟", "萬", "拾", "佰", "仟" };
	
	private static String[] engNumber= new String[]{"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN",
			"ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN","TWENTY"};
	
	public String Num2NTStr(double val) 
	{
		String SignStr = "";
		String TailStr = "";
		long fraction, integer;
		int jiao, fen;
		if (val < 0) 
		{
			val = -val;
			SignStr = "負";
		}
		if (val > 99999999999999.999 || val < -99999999999999.999)
			return "數值位數過大!";
		// 四舍五入到分
		long temp = Math.round(val * 100);
		integer = temp / 100;
		fraction = temp % 100;
		jiao = (int) fraction / 10;
		fen = (int) fraction % 10;
		if (jiao == 0 && fen == 0) 
		{
			TailStr = "整";
		}else{
			TailStr = HanDigiStr[jiao];
			if (jiao != 0)
				TailStr += "角";
			if (integer == 0 && jiao == 0) // 零元後不寫零幾分
				TailStr = "";
			if (fen != 0)
				TailStr += HanDigiStr[fen] + "分";
		}
		// 下一行可用于非正規金融場合，0.03只顯示“叁分”而不是“零元叁分”
		if(integer<1) return SignStr+TailStr;
		return SignStr + PositiveIntegerToHanStr(String.valueOf(integer))
				+ "元" + TailStr;
	}
	
	public String PositiveIntegerToHanStr(String NumStr) 
	{ 
		// 輸入字符串必須正整數，只允許前導空格(必須右對齊)，不宜有前導零
		String NTStr = "";
		boolean lastzero = false;
		boolean hasvalue = false; // 億、萬進位前有數值標記
		int len, n;
		len = NumStr.length();
		if (len > 15)
			return "數值過大!";
		for (int i = len - 1; i >= 0; i--) 
		{
			if (NumStr.charAt(len - i - 1) == ' ')
				continue;
			n = NumStr.charAt(len - i - 1) - '0';
			if (n < 0 || n > 9)
				return "輸入含非數字字符!";

			if (n != 0) 
			{
				if (lastzero)
					NTStr += HanDigiStr[0]; // 若幹零後若跟非零值，只顯示一個零
				// 除了億萬前的零不帶到後面
				// if( !( n==1 && (i%4)==1 && (lastzero || i==len-1) ) ) //
				// 如十進位前有零也不發壹音用此行
				if (!(n == 1 && (i % 4) == 1 && i == len - 1)) // 十進位處于第一位不發壹音
					NTStr += HanDigiStr[n];
				NTStr += HanDiviStr[i]; // 非零值後加進位，個位爲空
				hasvalue = true; // 置萬進位前有值標記
			} else {
				if ((i % 8) == 0 || ((i % 8) == 4 && hasvalue)) // 億萬之間必須有非零值方顯示萬
					NTStr += HanDiviStr[i]; // “億”或“萬”
			}
			if (i % 8 == 0)
				hasvalue = false; // 萬進位前有值標記逢億複位
			lastzero = (n == 0) && (i % 4 != 0);
		}
		if (NTStr.length() == 0)
			return HanDigiStr[0]; // 輸入空字符或"0"，返回"零"
		return NTStr;
	}
	
	public String Num2EngStr(double val) 
	{
		String strTmp="";
		long fraction, integer;
		if (val > 99999999999999.999 || val < -99999999999999.999)
			return "數值位數過大!";
		// 四舍五入到分
		long temp = Math.round(val * 100);
		integer = temp / 100;   // 整數的部份
		fraction = temp % 100;  // 小數點的部份		
		if(integer/100000000>0)
		{
			int i = (int) (integer/100000000);
			strTmp = Num2Eng999(i) + " BILLION";
			integer = integer - i*100000000;
		}
		if(integer/1000000>0)
		{
			int i = (int)(integer/1000000);
			if(!strTmp.equals(""))
				strTmp = strTmp + " ";
			strTmp = strTmp + Num2Eng999(i) + " MILLION";
			integer = integer - i*1000000;
		}
		if(integer/1000>0)
		{
			int i = (int)(integer/1000);
			if(i/100>0)
			{
				int j=(int)(i/100);
				if(!strTmp.equals(""))
					strTmp = strTmp + " ";
				strTmp = strTmp + Num2Eng999(j)+ " HUNDRED";				
				integer=integer-j*100000;				
			}
			if(integer/1000>0)
			{
				int j=(int)(integer/1000);
				if(!strTmp.equals(""))
					strTmp = strTmp + " ";
				strTmp = strTmp + Num2Eng999(j) + " THOUSAND";
				integer = integer - j*1000;
			}
		}
		if(integer/100>0)
		{
			int i = (int)(integer/100);
			if(!strTmp.equals(""))
				strTmp = strTmp + " ";
			strTmp = strTmp + Num2Eng999(i) + " HUNDRED";
			integer = integer - i*100;
		}
		if(integer>0)
		{
			if(!strTmp.equals(""))
				strTmp = strTmp + " ";
			strTmp = strTmp + Num2Eng999((int)integer);
		}
		if(fraction>0)
		{
			if(!strTmp.equals(""))
				strTmp = strTmp + " AND ";
			strTmp = strTmp + Num2Eng999((int)fraction) + " CENT";
			if(fraction>1)
				strTmp = strTmp + "S";			
		}
		return strTmp;
	}
	
	private String Num2Eng999(int iValue)
	{		
		String strTmp="";
		if(iValue > 99)
		{
			strTmp = Num2Eng999(iValue/100) + " HUNDRED";
			iValue = iValue%100;
		}
		if(iValue/90>0)
		{
			strTmp = "NINETY";
			iValue = iValue%90;
		}
		if(iValue/80>0){
			strTmp = "EIGHTY";
			iValue = iValue%80;
		}
		if(iValue/70>0){
			strTmp = "SEVENTY";
			iValue = iValue%70;
		}
		if(iValue/60>0){
			strTmp = "SIXTY";
			iValue = iValue%60;
		}
		if(iValue/50>0){
			strTmp = "FIFTY";
			iValue = iValue%50;
		}
		if(iValue/40>0){
			strTmp = "FORTY";
			iValue = iValue%40;
		}
		if(iValue/30>0){
			strTmp = "THIRTY";
			iValue = iValue%30;
		}
		if(iValue/20>0){
			strTmp = "TWENTY";
			iValue = iValue%20;
		}else{
			iValue = iValue%20;
		}
		if(iValue>0)
		{
			if(!strTmp.equals(""))
				if(iValue>0)
					strTmp = strTmp + "-";
				else 
					strTmp = strTmp + " ";
			strTmp = strTmp + engNumber[iValue];
		}		
		return strTmp;
	}

	public static CurrencyUtil getInstance()
	{
		synchronized (CurrencyUtil.class) {
			if (instance == null) {
				instance = new CurrencyUtil();
			}
		}
		synchronized (instance) {
			CurrencyUtil.checkedOut++;
		}
		return instance;
	}
	
	public static String format(double dValue, int iFractionDigits)
	{
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		formatter.setMinimumFractionDigits(iFractionDigits);
		formatter.setDecimalSeparatorAlwaysShown(true);
		return formatter.format(dValue);  //DecimalFormat("#,##0.00");
	}
	
	public int getCheckout()
	{
		return checkedOut;
	}
}
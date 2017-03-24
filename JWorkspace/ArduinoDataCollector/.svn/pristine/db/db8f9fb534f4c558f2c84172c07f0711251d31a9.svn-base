package util;

import java.util.Random;

public class MathUtil {
	public static void main(String[] args)
	{
		//System.out.println(getRandom(6) + " " + getRandom(6) + " " + getRandom(6));
		//System.out.println(getRandomInteger(3,6));
		System.out.println(MathUtil.getRandom(1000));
	}
	
	public static String getRandomInteger(int iDigits, int iDigitRange)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<iDigits; i++)
		{
			sb.append(getRandom(iDigitRange));
		}
		return sb.toString();
	}
	
	public static int getRandom(int iRange)
	{
		Random ran = new Random();
		return ran.nextInt(iRange)+1;
	}
}

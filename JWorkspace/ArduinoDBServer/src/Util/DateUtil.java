package Util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	public static void main(String[] args)
	{
		System.out.println(getFirstDateOfCurrentMonth());
		System.out.println(getLastDateOfCurrentMonth());
		System.out.println(getFirstDateOfSpecifiedMonth(8));	
		System.out.println(getLastDateOfSpecifiedMonth(8));
		System.out.println(getFirstDateOfSpecifiedYearMonth(2014,8));	
		System.out.println(getLastDateOfSpecifiedYearMonth(2014,8));
		System.out.println(getDateDiffInMin(getDateStart(new Date()), new Date()));
		System.out.println(DateUtil.getCymmetrikDate(DateUtil.addDay(new Date(),-30)));
		System.out.println(DateUtil.getDateDiffInMin(DateUtil.addMinute(new Date(), 3), new Date()));
	}
	public static Date getFirstDateOfCurrentMonth() 
	{
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}
	public static Date getLastDateOfCurrentMonth() 
	{
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}
	public static Date getLastDateOfSpecifiedMonth(int iMonth)
	{
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.MONTH, iMonth-1);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();		
	}
	public static Date getFirstDateOfSpecifiedMonth(int iMonth)
	{
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.MONTH, iMonth-1);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();		
	}
	public static Date getLastDateOfSpecifiedYearMonth(int iYear, int iMonth)
	{
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, iYear);
		cal.set(Calendar.MONTH, iMonth-1);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();		
	}
	public static Date getFirstDateOfSpecifiedYearMonth(int iYear, int iMonth)
	{
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, iYear);
		cal.set(Calendar.MONTH, iMonth-1);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();		
	}	
	
	public static Date getDate(String strDate)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try {
		    dt = df.parse(strDate);		    
		} catch (ParseException e) {
		   e.printStackTrace();
		}
		return dt;
	}
	
	public static Date getDateTime(String strDatetime)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dt = null;
		try {
		    dt = df.parse(strDatetime);		    
		} catch (ParseException e) {
		   e.printStackTrace();
		}
		return dt;
	}
	
	public static String getDateString(Date date)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	public static String getTimeString(Date date)
	{
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(date);
	}
	
	public static String getDateTimeString(Date date)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	public static Date getDateStart(Date dt) {
	    Date res = dt;
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(dt);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    res = calendar.getTime();
	    return res;
	}
	public static Date getDateEnd(Date dt) {
	    Date res = dt;
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(dt);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MILLISECOND, 999);
	    res = calendar.getTime();
	    return res;
	}
	
	public static double getDoubleRoundUp(int iPlace, double dValue)
	{
		return new BigDecimal(dValue)
        .setScale(iPlace, BigDecimal.ROUND_HALF_UP)
        .doubleValue();		
	}
	
	public static String getNowCymmetrikDate()
	{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	    return sdf.format(new Date());
	}
	
	public static String getNowCymmetrikDateTime()
	{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	    return sdf.format(new Date());
	}
	
	public static String getCymmetrikDate(Date date)
	{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	    return sdf.format(date);
	}
	
	public static String getCymmetrikDateTime(Date date)
	{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	    return sdf.format(date);
	}
	
	public static long getDateDiffInMin(Date da, Date db) {
	    long diffMin = 0;
	    diffMin = (da.getTime() - db.getTime())/60000;
	    return diffMin;
	}
	
	public static long getDateDiffInMsec(Date da, Date db) {
	    long diffMSec = 0;
	    diffMSec = da.getTime() - db.getTime();
	    return diffMSec;
	}

	// to convert Milliseconds into DD HH:MM:SS format.
	public String getDateFromMsec(long diffMSec) {
	    int left = 0;
	    int ss = 0;
	    int mm = 0;
	    int hh = 0;
	    int dd = 0;
	    left = (int) (diffMSec / 1000);
	    ss = left % 60;
	    left = (int) left / 60;
	    if (left > 0) {
	        mm = left % 60;
	        left = (int) left / 60;
	        if (left > 0) {
	            hh = left % 24;
	            left = (int) left / 24;
	            if (left > 0) {
	                dd = left;
	            }
	        }
	    }
	    String diff = Integer.toString(dd) + " " + Integer.toString(hh) + ":"
	            + Integer.toString(mm) + ":" + Integer.toString(ss);
	    return diff;

	}
	
	public static Date addMonth(Date date, int n)  
	{  
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);  
		cal.add(Calendar.MONTH, n);  
		return cal.getTime();  
	}  
	
	public static Date addDay(Date date, int n)  
	{  
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);  
		cal.add(Calendar.DATE, n);  
		return cal.getTime();  
	}  

	public static Date addMinute(Date date, int n)  
	{  
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);  
		cal.add(Calendar.MINUTE, n);  
		return cal.getTime();  
	}  
	
}

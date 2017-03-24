package db.manager;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Util {
	public static String getString(String str)
	{		
		return StringUtils.isEmpty(str)?"":str;
	}
	
	public static Date getDate(String strDatetime)
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
}

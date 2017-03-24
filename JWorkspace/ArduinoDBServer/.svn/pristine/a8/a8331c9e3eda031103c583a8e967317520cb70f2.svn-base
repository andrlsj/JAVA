package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	private static PropertyUtil instance;
	private static int checkedOut = 0;	
	private static Properties prop = null;
	
	public PropertyUtil(){}
	
	public PropertyUtil(File propertyFile)
	{
		setPropertyFile(propertyFile);
	}

	public String getProperties(String strKey)
	{
		return (String)prop.get(strKey);
	}
	
	public void setPropertyFile(File propertyFile)
	{
		FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(propertyFile);
        }
        catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
        Properties prop = new Properties();
        try
        {
            prop.load(fis);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	public static PropertyUtil getInstance()
	{
		synchronized (PropertyUtil.class) {
			if (instance == null) {
				instance = new PropertyUtil();
			}
		}
		synchronized (instance) {
			PropertyUtil.checkedOut++;
		}
		return instance;
	}
	
	public int getCheckout()
	{
		return checkedOut;
	}
}

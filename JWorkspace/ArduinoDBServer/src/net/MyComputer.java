package net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

//import org.apache.log4j.Logger;
//import org.apache.log4j.xml.DOMConfigurator;

public class MyComputer
{
	//private static Logger logger = Logger.getLogger(MyComputer.class);

	public static String getLocalIP()
	{
		//DOMConfigurator.configure("./config/log4j.xml");
		String sIP = "";
		InetAddress ip = null;
		try
		{
			if (isWindowsOS())
			{
				ip = InetAddress.getLocalHost();
			} else
			{
				boolean bFindIP = false;
				Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
						.getNetworkInterfaces();
				while (netInterfaces.hasMoreElements())
				{
					if (bFindIP)
					{
						break;
					}
					NetworkInterface ni = (NetworkInterface) netInterfaces
							.nextElement();
					//logger.info("NI:" + ni.toString());
					if (!ni.toString().contains("lo"))
					{

						Enumeration<InetAddress> ips = (Enumeration<InetAddress>) ni
								.getInetAddresses();
						//logger.info("IPS:" + ips.toString());
						while (ips.hasMoreElements())
						{
							ip = (InetAddress) ips.nextElement();
							//logger.info("IP:" + ip.toString());
							if (ip.isSiteLocalAddress()
									&& !ip.isLoopbackAddress()
									&& ip.getHostAddress().indexOf(":") == -1)
							{
								if (!ip.getHostAddress().contains("127."))
								{
									bFindIP = true;
									break;
								} else
								{
									ip = null;
								}
							}
						}
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		if (null != ip)
		{
			sIP = ip.getHostAddress();
		}
		return sIP;
	}

	public static boolean isWindowsOS()
	{
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1)
		{
			isWindowsOS = true;
		}
		return isWindowsOS;
	}
}

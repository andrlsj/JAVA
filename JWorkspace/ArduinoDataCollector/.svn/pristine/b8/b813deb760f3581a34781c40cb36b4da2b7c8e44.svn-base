package job;

import db.manager.SettingManager;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import mail.Mail;
import mail.SendFactory;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import snc02ManagerWebService.Snc02;
import util.DateUtil;

public class MinXHttpDataReader extends Thread {
	private static Logger logger = Logger.getLogger(Min30HttpDataReaderJob.class);
	private static HashMap<String, String> hm = SettingManager.getConfigHM();
	private String strWSIP = hm.get("ArduinoDBServerIP");
	private String strIP = "";
	private String strHostName = "";
	private static boolean bSendEmail=true;

	public static void main(String[] args) throws IOException {
		//getData2DB("192.168.4.161", "192.168.200.204", "CZY0002");
		System.out.println(hm.toString());
	}
	
	public void run() {
		getData2DB(strWSIP, strIP, strHostName);
	}

	public MinXHttpDataReader(String strWsip, String strIp, String strHostname) {
		strWSIP = strWsip;
		strIP = strIp;
		strHostName = strHostname;
	}
	
	public MinXHttpDataReader(String strWsip, String strIp, String strHostname, boolean bSendMail) {
		strWSIP = strWsip;
		strIP = strIp;
		strHostName = strHostname;
		bSendMail = bSendEmail;
	}

	public static boolean getData2DB(String strWSIP, String strIP, String strHostName) {
		hm = SettingManager.getConfigHM();
		boolean bResult = false;
		try {
			// Document doc = Jsoup.connect("http://" + strIP + "/").get();
			Document doc = null;
			try {
				doc = Jsoup.parse(new URL("http://" + strIP + "/"), Integer.parseInt(hm.get("DelayTime"))*1000);
			} catch (SocketTimeoutException ste) {
			}
			if (doc != null) {
				Elements jsElms = doc.getElementsByTag("html");
				Iterator<org.jsoup.nodes.Element> iter = jsElms.iterator();
				while (iter.hasNext()) {
					Element e = (Element) iter.next();
					for (int i = 0; i < e.childNodes().size(); i++) {
						if (e.childNode(i).toString().contains("<body>")) {
							String ss = e.childNode(i).unwrap().toString();

							String[] strArray = ss.split(",");
							for (int j = 0; j < strArray.length; j++) {
								String[] strData = strArray[j].split(":");
								try {
									Snc02 snc = new Snc02();
									if (strData[1].equals("nan")) {
										emailSensorError(strIP, strHostName);
									} else {
										float f = Float.parseFloat(strData[1]);
										snc.setSncx0201(strHostName); // 設定主機名稱
										snc.setSncx0202(strData[0].trim()); // 設定傳感器種類 H22, T22, H11, T11
										snc.setSncx0203(f); // 設定溫度資料
										snc.setSncx0204(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()));
										//System.out.println(snc.toString());
									if(!SNC02Transfer.transfer(strWSIP, snc, true))
										{
											if(SNC02Transfer.Save2LocalDB(snc))
											{
												logger.info("SaveToLocalDB reslult true ");
											}else{
											   logger.info("SaveToLocalDB reslult false ");
											}
										}	
									}
								} catch (Exception e2) {
									logger.error(e2.toString());
								}
							}
						}
					}
				}
			} else {
				System.out.println("email:" + strIP + " " + strHostName);
				email(strIP, strHostName);
			}
		} catch (Exception ste) {
			ste.printStackTrace();
			email(strIP, strHostName);
		}

		return bResult;
	}

	private static boolean email(String strIP, String strHostName) {
		if(!bSendEmail)
			return true;
		boolean bResult = false;
		if (((String) hm.get("MailAlert")).equals("Yes")) {
			StringBuilder sb = new StringBuilder(strHostName);
			sb.append("  (" + strIP + ")  " + DateUtil.getNowCymmetrikDateTime() + " 連線異常!");
			System.out.println(sb.toString());
			Mail mail = new Mail();
			mail.setHost((String) hm.get("MailHost"));
			mail.setPort((String) hm.get("MailPort"));
			mail.setMailFrom("ArduinoDataCollector@cymmetrik.com");
			mail.setSubject("【" + (String) hm.get("MailSubject") + "】-- " + strHostName + " 設備無法連線!");
			mail.setMailTo((String) hm.get("MailTo"));
			if (!hm.get("MailCC").toString().equals("")) {
				mail.setCc(hm.get("MailCC").toString());
			}

			mail.setMessage(sb.toString());
			SendFactory.getMailSender().Send(mail);
			bResult = true;
		}
		return bResult;
	}

	private static boolean emailSensorError(String strIP, String strHostName) {
		boolean bResult = false;
		if (((String) hm.get("MailAlert")).equals("Yes")) {
			StringBuilder sb = new StringBuilder(strHostName);
			sb.append("  (" + strIP + ")  " + DateUtil.getNowCymmetrikDateTime() + " 感測器資料異常!");
			System.out.println(sb.toString());
			Mail mail = new Mail();
			mail.setHost((String) hm.get("MailHost"));
			mail.setPort((String) hm.get("MailPort"));
			mail.setMailFrom("ArduinoDataCollector@cymmetrik.com");
			mail.setSubject("【" + (String) hm.get("MailSubject") + "】-- " + strHostName + " 感測器資料異常!");
			mail.setMailTo((String) hm.get("MailTo"));
			if (!hm.get("MailCC").toString().equals("")) {
				mail.setCc(hm.get("MailCC").toString());
			}

			mail.setMessage(sb.toString());
			SendFactory.getMailSender().Send(mail);
			bResult = true;
		}
		return bResult;
	}

	public String getStrWSIP() {
		return strWSIP;
	}

	public String getStrIP() {
		return strIP;
	}

	public String getStrHostName() {
		return strHostName;
	}

}

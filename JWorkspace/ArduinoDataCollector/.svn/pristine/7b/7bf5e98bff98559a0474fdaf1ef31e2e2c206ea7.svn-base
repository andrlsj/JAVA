package job;

import db.manager.SettingManager;
import java.io.IOException;
import java.util.HashMap;
import mail.Mail;
import mail.SendFactory;
import util.DateUtil;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpRequestTest extends Thread {
	private static Logger logger = Logger.getLogger(Min30HttpDataReaderJob.class);
	private static HashMap<String, String> hm = SettingManager.getConfigHM();
	private String strWSIP = hm.get("ArduinoDBServerIP");
	private String strIP = "";
	private String strHostName = "";
	private static boolean bSendEmail = true;

	public static void main(String[] args) throws IOException 
	{
		for(int i=1;i<3;i++)
		{
		callURL("http://192.168.4.162:9191/podprint/podprint.jsp?companyid=CCM&count="+i+"&content=cm_mio_in_date.btw%2cPDF%2cC02060071A0140%2f1660500010%2c%e8%b6%85%e9%80%8f%e6%98%8ePP#50%2f%e9%80%8f%e6%98%8e#30(%e8%b2%bcPE%e7%93%b6)%2cX-UPLT-T-GF08%2c140X550M%2c2016.05.06%2");
		callURL("http://192.168.4.162:9191/podprint/podprint.jsp?companyid=CCM&count="+i+"&content=cm_mio_in_date.btw%2cPDF%2cC02060071A0140%2f1660500010%2c%e8%b6%85%e9%80%8f%e6%98%8ePP#50%2f%e9%80%8f%e6%98%8e#30(%e8%b2%bcPE%e7%93%b6)%2cX-UPLT-T-GF08%2c140X550M%2c2016.05.06%2");
		}
	}

	public static void callURL(String strURL) {
		Document doc=null;
		try {
			doc = Jsoup.connect(strURL).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(doc.toString());

	}

	private static boolean email(String strIP, String strHostName) {
		if (!bSendEmail)
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

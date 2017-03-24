package snc02ManagerWebService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;

public class SNC02Manager {
	public boolean Save(String strWsdlPath, Snc02 snc) {
		QName SERVICE_NAME = new QName("http://WebService/", "SNC02ManagerService");
		SNC02ManagerService service = null;
		try {
			service = new SNC02ManagerService(new URL(strWsdlPath));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		URL wsdlURL = service.getWSDL_LOCATION(strWsdlPath);

		SNC02ManagerService ss = new SNC02ManagerService(wsdlURL, SERVICE_NAME);
		ISNC02Manager port = ss.getSNC02ManagerPort();
		boolean bResult = port.saveSNC02(snc);

		return bResult;
	}

	public static List<Snc02> getRecentSNCX02S(String strWsdlPath, String strCompanyId) {
		SNC02ManagerService service = null;
		try {
			service = new SNC02ManagerService(new URL(strWsdlPath));
			service.setWSDL_LOCATION(new URL(strWsdlPath));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		ISNC02Manager port = service.getSNC02ManagerPort();
		List<Snc02> lstSNC02 = port.getRecentSNCX02S(strCompanyId);

		return lstSNC02;
	}

	public static void main(String[] args) {
		//List<Snc02> lstSnc02 = getRecentSNCX02S("http://10.4.145.101:9092/SNC02Manager?wsdl", "CZF");
		List<Snc02> lstSnc02 = getRecentSNCX02S("http://192.168.4.162:9092/SNC02Manager?wsdl", "CZF");
		System.out.println(lstSnc02.size());
	}
}

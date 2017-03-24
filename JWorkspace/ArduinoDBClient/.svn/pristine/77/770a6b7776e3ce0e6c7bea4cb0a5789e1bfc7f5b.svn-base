package snc01ManagerWebService;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;

public class SNC01Manager {
	public boolean Save(String strWsdlPath, Snc01 snc) {
		boolean bResult=false;
		QName SERVICE_NAME = new QName("http://WebService/", "SNC01ManagerService");
		try {
			//SNC01ManagerService service = new SNC01ManagerService(new URL(strWsdlPath));
			URL wsdlURL = SNC01ManagerService.getWSDL_LOCATION(new URL(strWsdlPath));

			SNC01ManagerService ss = new SNC01ManagerService(wsdlURL, SERVICE_NAME);
			ISNC01Manager port = ss.getSNC01ManagerPort();
			bResult = port.saveSNC01(snc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	
		return bResult;
	}

	public List<Snc01> getSNCX01S(String strWsdlPath, Snc01 snc) {
		QName SERVICE_NAME = new QName("http://WebService/", "SNC01ManagerService");
		List<Snc01> lstSNC01 = new ArrayList<Snc01>();
		try {
			URL wsdlURL = SNC01ManagerService.getWSDL_LOCATION(new URL(strWsdlPath));

			SNC01ManagerService ss = new SNC01ManagerService(wsdlURL, SERVICE_NAME);
			ISNC01Manager port = ss.getSNC01ManagerPort();
			lstSNC01 = port.getSNCX01S(snc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return lstSNC01;
	}
	
	public List<Snc01> getSNCX01SByMins(String strWsdlPath, Snc01 snc) {
		QName SERVICE_NAME = new QName("http://WebService/", "SNC01ManagerService");
		List<Snc01> lstSNC01 = new ArrayList<Snc01>();
		try {
			URL wsdlURL = SNC01ManagerService.getWSDL_LOCATION(new URL(strWsdlPath));

			SNC01ManagerService ss = new SNC01ManagerService(wsdlURL, SERVICE_NAME);
			ISNC01Manager port = ss.getSNC01ManagerPort();
			lstSNC01 = port.getSNCX01SByMins(snc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return lstSNC01;
	}

	public List<Snc01> getAllSNCX01S(String strWsdlPath) {
		QName SERVICE_NAME = new QName("http://WebService/", "SNC01ManagerService");
		List<Snc01> lstSNC01 = new ArrayList<Snc01>();
		try {
			URL wsdlURL = SNC01ManagerService.getWSDL_LOCATION(new URL(strWsdlPath));

			SNC01ManagerService ss = new SNC01ManagerService(wsdlURL, SERVICE_NAME);
			ISNC01Manager port = ss.getSNC01ManagerPort();
			lstSNC01 = port.getAllSNCX01S();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return lstSNC01;
	}
	

	public Snc01 getSNCX01ByMachineName(String strWsdlPath, String strMachineName) {
		QName SERVICE_NAME = new QName("http://WebService/", "SNC01ManagerService");
		//SNC01ManagerService service = null;
		Snc01 snc01 =null;
		try {
			//service = new SNC01ManagerService(new URL(strWsdlPath));
			URL wsdlURL = SNC01ManagerService.getWSDL_LOCATION(new URL(strWsdlPath));

			SNC01ManagerService ss = new SNC01ManagerService(wsdlURL, SERVICE_NAME);
			ISNC01Manager port = ss.getSNC01ManagerPort();
			snc01 = port.getSNCX01ByMachineName(strMachineName);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return snc01;
	}
}

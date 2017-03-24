package job;

import db.dbmanager.SQLiteManager;
import db.manager.SensorData;
import db.manager.SensorDataManager;
import snc02ManagerWebService.SNC02Manager;
import snc02ManagerWebService.Snc02;

public class SNC02Transfer {
	public static void main(String[] args) {
		Snc02 snc = new Snc02();
		snc.setSncx0201("CHQ0001");
		snc.setSncx0202("H11");
		snc.setSncx0203(50.0F);
		transfer("", snc, false);
	}

	public static boolean transfer(String strWSServerIP, Snc02 snc, boolean bSave) {
		boolean bResult = false;
		String strURL = "192.168.4.161";
		if (!strWSServerIP.equals("")) {
			strURL = strWSServerIP;
		}
		String strWsdlPath = "http://" + strURL + ":9092/SNC02Manager?wsdl";
		SNC02Manager m = new SNC02Manager();
		if (bSave) {
			try {
				bResult = m.Save(strWsdlPath, snc);
    		} catch (Exception localException) {
			}
		}
		return bResult;
	}
	public static boolean Save2LocalDB(Snc02 snc)
	{
		boolean bResult = false;
		SensorData sd = new SensorData();
		sd.setMachineId(snc.getSncx0201());
		sd.setSensorType(snc.getSncx0202());
		sd.setValue(snc.getSncx0203());
		sd.setSystemDT(snc.getSncx0204());
		bResult = SensorDataManager.save(SQLiteManager.getConnection(), sd);
		return bResult;	
	}
}

package job;

import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import db.dbmanager.SQLiteManager;
import db.manager.SensorData;
import db.manager.SensorDataManager;
import db.manager.SettingManager;
import snc02ManagerWebService.Snc02;

public class reSendData {
	private static Logger logger = Logger.getLogger(reSendData.class);
	
	public static void resend()
	{
		HashMap<String, String> hm = SettingManager.getConfigHM();
		List<SensorData> lstSensorData = SensorDataManager.getSensorDataNotTransferred(SQLiteManager.getConnection());
		for(int i=0;i<lstSensorData.size();i++)
		{
			SensorData sd = lstSensorData.get(i);
			Snc02 snc = new Snc02();
			snc.setSncx0201(sd.getMachineId());
			snc.setSncx0202(sd.getSensorType());
			snc.setSncx0203(sd.getValue());
			snc.setSncx0204(sd.getSystemDT());
			String strWsdlIP =  hm.get("ArduinoDBServerIP") ;
		    if(SNC02Transfer.transfer(strWsdlIP, snc, true))
			{
				if(SensorDataManager.updateTransferred(SQLiteManager.getConnection(), sd.getId()))
				{
					logger.info(i + " Update Transferred OK."  +  sd.toString());
				}else{
					logger.info(i + " Update Transferred Error." + sd.toString());
				}
			}else{
				logger.info(i+ " not transferred.");
			}
		}
	}
	
}

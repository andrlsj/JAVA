package WebService;

import db.manager.DeviceManager;
import db.manager.SNC01;
import java.util.List;
import org.apache.log4j.xml.DOMConfigurator;

public class SNC01Manager implements ISNC01Manager {
	//private static Logger logger = Logger.getLogger(SNC01Manager.class);
	
	public SNC01Manager() {
		DOMConfigurator.configure("./config/log4j.xml");
	}

	public boolean SaveSNC01(SNC01 snc) {
		boolean bResult = OracleDB.manager.SNC01Manager.save(snc);
		return bResult;
	}

	public List<SNC01> getAllSNCX01s() {
		List<SNC01> lstSNC01 = OracleDB.manager.SNC01Manager.getSNCX01s();
		return lstSNC01;
	}

	public List<SNC01> getSNCX01sByMins(SNC01 snc) {
		List<SNC01> lst = OracleDB.manager.SNC01Manager.getSNCX01sByMins(snc);
		return lst;
	}
	
	public static void main(String[] args)
	{
		SNC01Manager m = new SNC01Manager();
		SNC01 snc = new SNC01();
		snc.setMemo("5");
		List<SNC01> lst = m.getSNCX01sByMins(snc);
		System.out.println(lst.size());
	
	}

	public SNC01 getSNCX01ByMachineName(String strMachineName) {
		SNC01 snc01 = OracleDB.manager.SNC01Manager.getSNCX01ByMachineName(strMachineName);
		return snc01;
	}

	@Override
	public List<SNC01> getSNCX01s(SNC01 snc) {
		List<SNC01> lst = OracleDB.manager.SNC01Manager.getSNCX01s(snc);
		// 抓取 sqliteDB
		if (lst.size() == 0) {
			lst = DeviceManager.getDevicesByTagName(snc.getCompanyId());
		}
		return lst;
	}
}

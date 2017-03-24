package WebService;

import db.manager.SNC02;
import java.util.List;
import org.apache.log4j.xml.DOMConfigurator;

public class SNC02Manager implements ISNC02Manager {
	//private static Logger logger = Logger.getLogger(SNC02Manager.class);

	public SNC02Manager() {
		DOMConfigurator.configure("./config/log4j.xml");
	}

	public boolean SaveSNC02(SNC02 snc) {
		boolean bResult = false;
		bResult = OracleDB.manager.SNC02Manager.save(snc);
		return bResult;
	}

	public List<SNC02> getRecentSNCX02s(String strCompanyId) {
		List<SNC02> lstSNC02 = OracleDB.manager.SNC02Manager.getRecentSNCX02s(strCompanyId);
		return lstSNC02;
	}

}

package job;

import data.GetData.GetData;
import db.manager.SettingManager;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import snc01ManagerWebService.SNC01Manager;
import snc01ManagerWebService.Snc01;
import util.MathUtil;

public class Min10HttpDataReaderJob implements Job {
	private static Logger logger = Logger.getLogger(Min10HttpDataReaderJob.class);
	private static HashMap<String, String> hm = SettingManager.getConfigHM();
	private static HashMap<String, String> hmSite = GetData.getSite("./config/config.ini", "Site");

	public static void main(String[] args) {
		System.out.println("Min10HttpDataReaderJob run...");
		//ExecutorService exec = Executors.newFixedThreadPool(10);
		List<Snc01> lstSNC01 = getEnableSNCX01SByMins((String) hm.get("ArduinoDBServerIP"), (String) hmSite.get("site"),"10");
		System.out.println(lstSNC01.size());
//		for (int i = 0; i < lstSNC01.size(); i++) {
//			Snc01 snc = (Snc01) lstSNC01.get(i);
//			System.out.println(snc.getCompanyId() + " " + snc.getMachineName() + " " + snc.getIp());
//			logger.info(snc.getCompanyId() + " " + snc.getMachineName() + " " + snc.getIp());
//			MinXHttpDataReader dr = new MinXHttpDataReader((String) hm.get("ArduinoDBServerIP"), snc.getIp(),
//					snc.getMachineName());
//			exec.execute(dr);
//		}
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Min10HttpDataReaderJob run...");
		List<Snc01> lstSNC01 = getEnableSNCX01SByMins((String) hm.get("ArduinoDBServerIP"), (String) hmSite.get("site"),"10");
		if(lstSNC01.size()==0)
			return;
		ExecutorService exec = Executors.newFixedThreadPool(10);
		logger.info(Integer.valueOf(lstSNC01.size()));
		for (int i = 0; i < lstSNC01.size(); i++) 
		{
			Snc01 snc = (Snc01) lstSNC01.get(i);
			logger.info(snc.getCompanyId() + " " + snc.getMachineName() + " " + snc.getIp());
			try {
				Thread.sleep(MathUtil.getRandom(1000));
			} catch (InterruptedException e) {e.printStackTrace();}
			
			MinXHttpDataReader dr = new MinXHttpDataReader((String) hm.get("ArduinoDBServerIP"), snc.getIp(),
					snc.getMachineName());
			exec.execute(dr);
		}
		exec = null;
	}

	private static List<Snc01> getEnableSNCX01SByMins(String strWSServerIP, String strSite, String strMins) {
		String strURL = "192.168.4.161";
		if (!strWSServerIP.equals("")) {
			strURL = strWSServerIP;
		}
		String strWsdlPath = "http://" + strURL + ":9092/SNC01Manager?wsdl";
		SNC01Manager m = new SNC01Manager();
		Snc01 snc = new Snc01();
		snc.setEnable("1");
		snc.setCompanyId(strSite);
		snc.setMemo(strMins);
		return m.getSNCX01SByMins(strWsdlPath, snc);
	}
}

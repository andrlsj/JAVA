package job;

import java.util.List;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import OracleDB.manager.SNC01Manager;
import db.manager.Device;
import db.manager.DeviceManager;
import db.manager.SNC01;

public class SyncDeviceListJob implements Job {
	private static Logger logger = Logger.getLogger(SyncDeviceListJob.class);
	public static void main(String[] args)
	{
		syncDevice();
	}
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		  	logger.info("SyncDeviceListJob run...");
		    syncDevice();
	}
	private static void syncDevice() 
	{
		List<SNC01> lstSNC =SNC01Manager.getSNCX01s();
		for(int i=0;i<lstSNC.size();i++)
		{
			SNC01 snc = lstSNC.get(i);
			Device device = new Device();
			device.setTagName(snc.getMachineName());
			device.setCompanyId(snc.getCompanyId());
			device.setIp(snc.getIp());
			device.setMac(snc.getMac());
			device.setDescription(snc.getMemo());
			device.setEnable(snc.getEnable().equalsIgnoreCase("1")?Boolean.TRUE:Boolean.FALSE);
			//System.out.println(snc.getEnable() + device.isEnable());
			DeviceManager.Save(device);
		}		
	}
}

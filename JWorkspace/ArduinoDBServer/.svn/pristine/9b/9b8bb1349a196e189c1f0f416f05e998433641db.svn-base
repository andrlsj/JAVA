package report.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import db.dbmanager.DatabaseManagerBase;
import db.dbmanager.DatabaseManagerC3P0;
import job.CreateDayReportsJob;
import report.model.TemperatureHumidity;

public class TemperatureHumidityManager
{
	private static Logger logger = Logger.getLogger(CreateDayReportsJob.class);
	
	public static List<TemperatureHumidity> getTemperatureHumidity(Connection conn, String strSTime, String strETime, String strDeviceName)
	{
		DOMConfigurator.configure("./config/log4j.xml"); 
		
		List<TemperatureHumidity> lstTemperatureHumidity = new ArrayList<TemperatureHumidity>();
		String strSQL = "select a.snc02_01 device_name, a.snc02_03 temperature, b.snc02_03 humidity, "
				+ "substr(a.snc02_04, 12, 2) tm from "
				+ "(select * from snc02 where snc02_01 = '" + strDeviceName + "' AND snc02_04 between '" + strSTime + "' and '"
				+ strETime + "' and snc02_02 = 'T22') a, "
				+ "(select * from snc02 where snc02_01 = '" + strDeviceName + "' AND snc02_04 between '" + strSTime + "' and '"
				+ strETime + "' and snc02_02 = 'H22') b "
				+ "where substr(a.snc02_04, 1, 16) = substr(b.snc02_04, 1, 16) and substr(a.snc02_04, 15, 2)='00'";
		try
		{
			logger.info(strSQL);
			System.out.println(strSQL);
			PreparedStatement pst = conn.prepareStatement(strSQL);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				TemperatureHumidity th = new TemperatureHumidity();
				th.setDEVICE_NAME(rs.getString("device_name"));
				th.setHUMIDITY(rs.getDouble("humidity"));
				th.setTEMPERATURE(rs.getDouble("temperature"));
				th.setTM(rs.getString("tm"));

				lstTemperatureHumidity.add(th);
			}
			DatabaseManagerBase.Close(rs, null, pst);
		} catch (SQLException e)
		{
			logger.error("getTemperatureHumidity error!!");
			e.printStackTrace();
		}
		return lstTemperatureHumidity;
	}
}

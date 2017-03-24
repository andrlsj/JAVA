package report.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.dbmanager.DatabaseManagerBase;
import db.dbmanager.DatabaseManagerC3P0;
import report.model.PM;

public class PMManager
{
	public static List<PM> getPM(Connection conn, String strSTime, String strETime, String strDeviceName)
	{
		List<PM> lstPM = new ArrayList<PM>();
		String strSQL = "select snc02_01 device_name,snc02_03 PM_Value,substr(snc02_04, 12, 2) tm from snc02 "
				+ "where snc02_01 = '" + strDeviceName + "' AND snc02_04  between '" + strSTime + "' and '"
				+ strETime + "' and snc02_02 = 'PM2.5' and substr(snc02_04, 15, 2)='00'";
		try
		{
			System.out.println(strSQL);
			PreparedStatement pst = conn.prepareStatement(strSQL);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				PM pm = new PM();
				pm.setDEVICE_NAME(rs.getString("device_name"));
				pm.setPM_VALUE(rs.getDouble("pm_value"));
				pm.setTM(rs.getString("tm"));

				lstPM.add(pm);
			}			
			DatabaseManagerBase.Close(rs, null, pst);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstPM;
	}
}

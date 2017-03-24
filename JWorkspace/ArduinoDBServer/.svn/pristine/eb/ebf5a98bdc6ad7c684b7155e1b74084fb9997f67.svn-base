package report.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.dbmanager.DatabaseManagerBase;
import db.dbmanager.DatabaseManagerC3P0;
import report.model.Device;

public class DeviceManager
{
	public static void main(String[] args) throws SQLException
	{
		DatabaseManagerC3P0 c3p0 = DatabaseManagerC3P0.getInstance();
		Connection conn = c3p0.getConnection();
		List<Device> lstDevice = getTHDeviceInfo(conn);
		System.out.println(lstDevice.size());
		for (int i=0; i<lstDevice.size(); ++i)
		{
			System.out.println(lstDevice.get(i).getDeviceName() + " " + lstDevice.get(i).getCompanyName() + " " + lstDevice.get(i).getCategory());
		}
	}
	public static List<Device> getTHDeviceInfo(Connection conn)
	{
		List<Device> lstDevice = new ArrayList<Device>();
		String strSQL = "select a.snc01_01 device_name, a.snc01_03 company_name, b.snc02_02 category from snc01 a, snc02 b "
				+ "where a.snc01_01 = b.snc02_01 and b.snc02_02 = 'T22' group by a.snc01_01, a.snc01_03, b.snc02_02";
		try
		{
			System.out.println(strSQL);
			PreparedStatement pst = conn.prepareStatement(strSQL);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				Device device = new Device();
				device.setDeviceName(rs.getString("device_name"));
				device.setCompanyName(rs.getString("company_name"));
				device.setCategory(rs.getString("category"));

				lstDevice.add(device);
			}
			DatabaseManagerBase.Close(rs, null, pst);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstDevice;
	}
	
	public static List<Device> getPMDeviceInfo(Connection conn)
	{
		List<Device> lstDevice = new ArrayList<Device>();
		String strSQL = "select a.snc01_01 device_name, a.snc01_03 company_name, b.snc02_02 category from snc01 a, snc02 b "
				+ "where a.snc01_01 = b.snc02_01 and b.snc02_02 = 'PM2.5' group by a.snc01_01, a.snc01_03, b.snc02_02";
		try
		{
			System.out.println(strSQL);
			PreparedStatement pst = conn.prepareStatement(strSQL);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				Device device = new Device();
				device.setDeviceName(rs.getString("device_name"));
				device.setCompanyName(rs.getString("company_name"));
				device.setCategory(rs.getString("category"));

				lstDevice.add(device);
			}
			DatabaseManagerBase.Close(rs, null, pst);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return lstDevice;
	}
}

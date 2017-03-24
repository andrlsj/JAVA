package db.manager;

import data.Sql.SQLiteBase;
import db.dbmanager.DatabaseManagerBase;
import db.dbmanager.SQLiteManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceManager {

	public static void main(String[] args)
	{
		List<Device> lstDevice;
		lstDevice = getDevicesByLikeTagName("CHK");
		for(int i=0;i<lstDevice.size();i++)
		{
			Device device = lstDevice.get(i);
			System.out.println(device.toString());		
		}
		
	}
	
	public static boolean Save(Device device) {
		boolean bResult = false;
		Connection conn = SQLiteManager.getInstance().getConnection();
		Device d0 = getDeviceByTagName(conn, device.getTagName());
		if (!d0.getTagName().equals("")) {
			SQLiteBase.SQLUpdater upd = new SQLiteBase.SQLUpdater("device");
			upd.updateStrField("tagname", device.getTagName());
			upd.updateStrField("ip", device.getIp());
			upd.updateStrField("company_id", device.getCompanyId());
			upd.updateIntField("enable", device.isEnable() ? 1 : 0);
			upd.updateStrField("description", device.getDescription());
			upd.updateStrField("mac", device.getMac());
			upd.updateStrField("ucl", device.getUcl());
			upd.updateStrField("lcl", device.getLcl());
			upd.updateStrField("ucl02", device.getUcl02());
			upd.updateStrField("lcl02", device.getLcl02());
			upd.updateStrField("tag_type", device.getTagType());
			upd.addStrCond("tagname", device.getTagName());
			System.out.println(upd.toString());
			DatabaseManagerBase.Update(conn, upd.toString());
			bResult = true;
		} else {
			SQLiteBase.SQLInserter ins = new SQLiteBase.SQLInserter("device");
			ins.addStrValue("tagname", device.getTagName());
			ins.addStrValue("ip", device.getIp());
			ins.addStrValue("company_id", device.getCompanyId());
			ins.addIntValue("enable", device.isEnable() ? 1 : 0);
			ins.addStrValue("description", device.getDescription());
			ins.addStrValue("mac", device.getMac());
			ins.addStrValue("ucl", device.getUcl());
			ins.addStrValue("lcl", device.getLcl());
			ins.addStrValue("ucl02", device.getUcl02());
			ins.addStrValue("lcl02", device.getLcl02());
			ins.addStrValue("tag_type", device.getTagType());
			System.out.println(ins.toString());
			DatabaseManagerBase.Insert(conn, ins.toString());
			bResult = true;
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return bResult;
	}

	public static Device getDeviceByTagName(Connection con, String strDeviceName) {
		SQLiteBase.SQLSelecter sel = new SQLiteBase.SQLSelecter("device");
		sel.addSelect("*");
		sel.addStrCond("tagname", strDeviceName);
		Device device = new Device();
		try {
			System.out.println(sel.toString());
			ResultSet rs = DatabaseManagerBase.Select(con, sel.toString());
			while (rs.next()) {
				device.setId(rs.getInt("id"));
				device.setTagName(rs.getString("tagname"));
				device.setIp(rs.getString("ip"));
				device.setCompanyId(rs.getString("company_id"));
				device.setEnable(rs.getBoolean("enable"));
				device.setDescription(rs.getString("description"));
				device.setMac(rs.getString("mac"));
				device.setUcl(rs.getString("ucl"));
				device.setLcl(rs.getString("lcl"));
				device.setUcl02(rs.getString("ucl02"));
				device.setLcl02(rs.getString("lcl02"));
				device.setTagType(rs.getString("tag_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return device;
	}

	public static List<Device> getDevicesByLikeTagName(String strTagName) {
		Connection conn = SQLiteManager.getInstance().getConnection();
		SQLiteBase.SQLSelecter sel = new SQLiteBase.SQLSelecter("device");
		sel.addSelect("*");
		if (!strTagName.equals("")) {
			sel.addLikeCond("tagname", "%"+strTagName+"%");
		}
		sel.addIntCond("enable", 1);

		List<Device> lstDevice = new ArrayList<Device>();
		try {
			System.out.println(sel.toString());
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());
			while (rs.next()) {
				Device device = new Device();
				device.setId(rs.getInt("id"));
				device.setTagName(rs.getString("tagname"));
				device.setIp(rs.getString("ip"));
				device.setCompanyId(rs.getString("company_id"));
				device.setEnable(rs.getBoolean("enable"));
				device.setDescription(rs.getString("description"));
				device.setMac(rs.getString("mac"));
				device.setUcl(rs.getString("ucl"));
				device.setLcl(rs.getString("lcl"));
				device.setUcl02(rs.getString("ucl02"));
				device.setLcl02(rs.getString("lcl02"));
				device.setTagType(rs.getString("tag_type"));
				lstDevice.add(device);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return lstDevice;
	}

	public static List<SNC01> getDevicesByTagName(String strTagName) {
		Connection conn = SQLiteManager.getInstance().getConnection();
		SQLiteBase.SQLSelecter sel = new SQLiteBase.SQLSelecter("device");
		sel.addSelect("*");
		if (!strTagName.equals("")) {
			sel.addLikeCond("tagname", "%"+strTagName+"%");
		}
		sel.addIntCond("enable", 1);

		List<SNC01> lstSNC = new ArrayList<SNC01>();
		try {
			System.out.println(sel.toString());
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());
			while (rs.next()) {
				SNC01 snc = new SNC01();
				snc.setCompanyId(rs.getString("company_id"));
				snc.setIp(rs.getString("ip"));
				snc.setMachineName(rs.getString("tagname"));
				snc.setMac(rs.getString("mac"));
				snc.setEnable(rs.getBoolean("enable")==Boolean.TRUE?"1":"0");				
				lstSNC.add(snc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseManagerBase.Close(null, null, null, conn);			
		}
		return lstSNC;
	}
	
}

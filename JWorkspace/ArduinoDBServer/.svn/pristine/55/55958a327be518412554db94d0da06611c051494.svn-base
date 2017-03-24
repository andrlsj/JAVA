package db.manager;

import Util.DateUtil;
import Util.StringUtil;
import data.Sql.SQLiteBase;
import db.dbmanager.DatabaseManagerBase;
import db.dbmanager.SQLiteManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingManager {
	public static boolean Save(Setting setting) {
		Connection conn = SQLiteManager.getInstance().getConnection();
		boolean bResult = false;
		Setting usr0 = getSettingById(conn, String.valueOf(setting.getId()));
		if (!usr0.getName().equals("")) {
			SQLiteBase.SQLUpdater upd = new SQLiteBase.SQLUpdater("setting");
			upd.updateStrField("name", setting.getName());
			upd.updateStrField("sysname", setting.getSysname());
			upd.updateStrField("value", setting.getValue());
			upd.updateIntField("enable", setting.isEnable() ? 1 : 0);
			upd.updateStrField("memo", setting.getMemo());
			upd.updateTimeField("datetime");
			upd.addStrCond("id", setting.getId());
			System.out.println(upd.toString());
			DatabaseManagerBase.Update(conn, upd.toString());
			bResult = true;
		} else {
			SQLiteBase.SQLInserter ins = new SQLiteBase.SQLInserter("setting");
			ins.addStrValue("id", setting.getId());
			ins.addStrValue("name", setting.getName());
			ins.addStrValue("sysname", setting.getSysname());
			ins.addStrValue("value", setting.getValue());
			ins.addIntValue("enable", setting.isEnable() ? 1 : 0);
			ins.addStrValue("memo", StringUtil.getString(setting.getMemo()));
			ins.addSysdateValue("datetime");
			System.out.println(ins.toString());
			DatabaseManagerBase.Insert(conn, ins.toString());
			bResult = true;
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return bResult;
	}

	public static HashMap<String, String> getConfigHM() {
		HashMap<String, String> hm = new HashMap<String, String>();
		List<Setting> lstSetting = getSettingsBySysname("system", true);
		for (int i = 0; i < lstSetting.size(); i++) {
			Setting setting = (Setting) lstSetting.get(i);
			hm.put(setting.getName(), setting.getValue());
		}
		return hm;
	}

	public static Setting getSettingById(Connection con, String strSettingId) {
		SQLiteBase.SQLSelecter sel = new SQLiteBase.SQLSelecter("setting");
		sel.addSelect("*");
		sel.addStrCond("id", strSettingId);
		Setting setting = new Setting();
		try {
			System.out.println(sel.toString());
			ResultSet rs = DatabaseManagerBase.Select(con, sel.toString());
			while (rs.next()) {
				setting.setId(rs.getString("id"));
				setting.setName(rs.getString("name"));
				setting.setSysname(rs.getString("sysname"));
				setting.setEnable(rs.getBoolean("enable"));
				setting.setValue(rs.getString("value"));
				setting.setMemo(StringUtil.getString(rs.getString("memo")));
				setting.setDatetime(DateUtil.getDate(rs.getString("datetime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return setting;
	}

	public static List<Setting> getSettingBySysnameLikeName(String strSysname, String strName) {
		Connection conn = SQLiteManager.getInstance().getConnection();
		SQLiteBase.SQLSelecter sel = new SQLiteBase.SQLSelecter("setting");
		sel.addSelect("*");
		if (!strSysname.equals("")) {
			sel.addStrCond("sysname", strSysname);
		}
		sel.addLikeCond("name", strName);
		List<Setting> lstSetting = new ArrayList<Setting>();
		try {
			System.out.println(sel.toString());
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());
			while (rs.next()) {
				Setting setting = new Setting();
				setting.setId(rs.getString("id"));
				setting.setName(rs.getString("name"));
				setting.setSysname(rs.getString("sysname"));
				setting.setValue(rs.getString("value"));
				setting.setEnable(rs.getBoolean("enable"));
				setting.setMemo(StringUtil.getString(rs.getString("memo")));
				setting.setDatetime(DateUtil.getDate(rs.getString("datetime")));
				lstSetting.add(setting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstSetting;
	}

	public static Setting getSettingBySysnameName(String strSysname, String strName) {
		Connection conn = SQLiteManager.getInstance().getConnection();
		SQLiteBase.SQLSelecter sel = new SQLiteBase.SQLSelecter("setting");
		sel.addSelect("*");
		if (!strSysname.equals("")) {
			sel.addStrCond("sysname", strSysname);
		}
		sel.addStrCond("name", strName);
		Setting setting = new Setting();
		try {
			System.out.println(sel.toString());
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());
			while (rs.next()) {
				setting.setId(rs.getString("id"));
				setting.setName(rs.getString("name"));
				setting.setSysname(rs.getString("sysname"));
				setting.setValue(rs.getString("value"));
				setting.setEnable(rs.getBoolean("enable"));
				setting.setMemo(StringUtil.getString(rs.getString("memo")));
				setting.setDatetime(DateUtil.getDate(rs.getString("datetime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseManagerBase.Close(null, null, null,conn);
		}
		return setting;
	}

	public static List<Setting> getSettingsBySysname(String strSysname) {
		return getSettingsBySysname(strSysname, false);
	}

	public static List<Setting> getSettingsBySysname(String strSysname, boolean bEnable) {
		Connection conn = SQLiteManager.getInstance().getConnection();
		SQLiteBase.SQLSelecter sel = new SQLiteBase.SQLSelecter("setting");
		sel.addSelect("*");
		if (!strSysname.equals("")) {
			sel.addStrCond("sysname", strSysname);
		}
		if (bEnable) {
			sel.addCond("enable", "1");
		}
		List<Setting> lstSetting = new ArrayList<Setting>();
		// System.out.println(sel.toString());
		try {
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());
			while (rs.next()) {
				Setting setting = new Setting();
				setting.setId(rs.getString("id"));
				setting.setName(rs.getString("name"));
				setting.setValue(rs.getString("value"));
				setting.setSysname(rs.getString("sysname"));
				setting.setEnable(rs.getBoolean("enable"));
				setting.setDatetime(DateUtil.getDate(rs.getString("datetime")));
				setting.setMemo(StringUtil.getString(rs.getString("memo")));
				lstSetting.add(setting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseManagerBase.Close(null, null, null, conn);
		}
		return lstSetting;
	}
}

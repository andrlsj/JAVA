package OracleDB.manager;

import Util.StringUtil;
import data.Sql.OracleSQLBase;
import db.dbmanager.DatabaseManagerBase;
import db.dbmanager.DatabaseManagerC3P0;
import db.manager.SNC01;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class SNC01Manager {
	private static Logger logger = Logger.getLogger(SNC01Manager.class);

	public static boolean save(SNC01 snc) {
		boolean bResult = false;
		DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
		Connection conn = dbcp.getConnection();
		SNC01 snc1 = getSNCX01ByMachineName(snc.getMachineName());
		if (!snc1.getMachineName().equals("")) {
			OracleSQLBase.SQLUpdater upd = new OracleSQLBase.SQLUpdater("SNC01");
			/*
			 * upd.updateStrField("SNC01_02", snc.getIp());
			 * upd.updateStrField("SNC01_03", snc.getCompanyId());
			 */
			if (!snc.getMemo().equals(""))
				upd.updateStrField("SNC01_04", snc.getMemo());
			if (!snc.getEnable().equals(snc1.getEnable()))
				upd.updateStrField("SNC01_05", snc.getEnable());
			// upd.updateStrField("SNC01_06", snc.getMac());
			upd.updateStrField("SNC01_12", snc.getMins());
			upd.addStrCond("SNC01_01", snc.getMachineName());
			logger.info(upd.toString());
			DatabaseManagerBase.Update(conn, upd.toString());
			bResult = true;
		} else {
			OracleSQLBase.SQLInserter ins = new OracleSQLBase.SQLInserter("SNC01");
			ins.addStrValue("SNC01_01", snc.getMachineName());
			ins.addStrValue("SNC01_02", snc.getIp());
			ins.addStrValue("SNC01_03", snc.getCompanyId());
			ins.addStrValue("SNC01_04", snc.getMemo());
			ins.addStrValue("SNC01_05", snc.getEnable());
			ins.addStrValue("SNC01_06", snc.getMac());
			ins.addStrValue("SNC01_12", snc.getMins());
			logger.info(ins.toString());
			DatabaseManagerBase.Insert(conn, ins.toString());
			bResult = true;
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return bResult;
	}

	public static boolean updateIPByDeviceId(String strDeviceID, String stIP) {
		boolean bResult = false;
		SNC01 snc1 = getSNCX01ByMachineName(strDeviceID);
		if (!snc1.getMachineName().equals("")) {
			DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
			Connection conn = dbcp.getConnection();
			OracleSQLBase.SQLUpdater upd = new OracleSQLBase.SQLUpdater("SNC01");
			upd.updateStrField("SNC01_02", stIP);
			upd.addStrCond("SNC01_01", strDeviceID);
			logger.info(upd.toString());
			DatabaseManagerBase.Update(conn, upd.toString());
			bResult = true;
			DatabaseManagerBase.Close(null, null, null, conn);
		}
		return bResult;
	}

	public static List<SNC01> getSNCX01s() {
		return getSNCX01s(null);
	}

	public static List<SNC01> getSNCX01s(SNC01 snc01) {
		DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
		Connection conn = dbcp.getConnection();
		OracleSQLBase.SQLSelecter sel = new OracleSQLBase.SQLSelecter("SNC01");
		sel.addSelect("*");
		sel.addOrder("SNC01_01");
		if (snc01 != null) {
			if (snc01.getCompanyId() != null) {
				if (!snc01.getCompanyId().equals("")) {
					sel.addStrCond("SNC01_03", snc01.getCompanyId());
				}
			}
			if (snc01.getMachineName() != null) {
				if (!snc01.getMachineName().equals("")) {
					sel.addLikeCond("SNC01_01", snc01.getMachineName());
				}
			}
			if (snc01.getIp() != null) {
				if (!snc01.getIp().equals("")) {
					sel.addLikeCond("SNC01_02", snc01.getIp());
				}
			}
			if (snc01.getEnable().equals("1")) {
				sel.addStrCond("snc01_05", "1");
			}
			// if(snc01.getMemo().equals("reconnect"))
			// {
			// OracleManagerC3P0 dbcp = OracleManagerC3P0.getInstance();
			// dbcp.reset();
			// conn = dbcp.getConnection();
			// snc01.setMemo("");
			// }
		}
		List<SNC01> lstSNCX01 = new ArrayList<SNC01>();
		logger.info(sel.toString());
		try {
			PreparedStatement pst = conn.prepareStatement(sel.toString());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				SNC01 snc = new SNC01();
				snc.setMachineName(rs.getString("SNC01_01"));
				snc.setIp(rs.getString("SNC01_02"));
				snc.setCompanyId(rs.getString("SNC01_03"));
				snc.setMemo(rs.getString("SNC01_04"));
				snc.setEnable(StringUtil.getString(rs.getString("SNC01_05")));
				snc.setMac(rs.getString("SNC01_06"));
				snc.setMins(rs.getString("SNC01_12"));
				lstSNCX01.add(snc);
			}
			DatabaseManagerBase.Close(rs, null, pst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return lstSNCX01;
	}

	public static List<SNC01> getSNCX01sByMins(SNC01 snc01) {
		DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
		Connection conn = dbcp.getConnection();
		OracleSQLBase.SQLSelecter sel = new OracleSQLBase.SQLSelecter("SNC01");
		sel.addSelect("*");
		sel.addOrder("SNC01_01");
		if (snc01 != null) {
			if (snc01.getCompanyId() != null) {
				if (!snc01.getCompanyId().equals("")) {
					sel.addStrCond("SNC01_03", snc01.getCompanyId());
				}
			}
			if (snc01.getMachineName() != null) {
				if (!snc01.getMachineName().equals("")) {
					sel.addLikeCond("SNC01_01", snc01.getMachineName());
				}
			}
			if (snc01.getIp() != null) {
				if (!snc01.getIp().equals("")) {
					sel.addLikeCond("SNC01_02", snc01.getIp());
				}
			}
			if (snc01.getEnable().equals("1")) {
				sel.addStrCond("snc01_05", "1");
			}
			if (!snc01.getMemo().equals("")) {
				sel.addStrCond("snc01_12", snc01.getMemo());
			}
		}
		List<SNC01> lstSNCX01 = new ArrayList<SNC01>();
		logger.info(sel.toString());
		try {
			PreparedStatement pst = conn.prepareStatement(sel.toString());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				SNC01 snc = new SNC01();
				snc.setMachineName(rs.getString("SNC01_01"));
				snc.setIp(rs.getString("SNC01_02"));
				snc.setCompanyId(rs.getString("SNC01_03"));
				snc.setMemo(rs.getString("SNC01_04"));
				snc.setEnable(StringUtil.getString(rs.getString("SNC01_05")));
				snc.setMac(rs.getString("SNC01_06"));
				snc.setMins(rs.getString("SNC01_12"));
				lstSNCX01.add(snc);
			}
			DatabaseManagerBase.Close(rs, null, pst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return lstSNCX01;
	}

	public static SNC01 getSNCX01ByMachineName(String strMachineName) {
		DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
		Connection conn = dbcp.getConnection();
		OracleSQLBase.SQLSelecter sel = new OracleSQLBase.SQLSelecter("SNC01");
		sel.addSelect("*");
		sel.addStrCond("snc01_01", strMachineName);

		SNC01 snc01 = new SNC01();
		logger.info(sel.toString());
		try {
			PreparedStatement pst = conn.prepareStatement(sel.toString());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				snc01.setMachineName(rs.getString("SNC01_01"));
				snc01.setIp(rs.getString("SNC01_02"));
				snc01.setCompanyId(rs.getString("SNC01_03"));
				snc01.setMemo(rs.getString("SNC01_04"));
				snc01.setEnable(StringUtil.getString(rs.getString("SNC01_05")));
				snc01.setMac(rs.getString("SNC01_06"));
				snc01.setMins(rs.getString("SNC01_12"));
			}
			DatabaseManagerBase.Close(rs, null, pst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return snc01;
	}

	public static List<SNC01> getSNCX01sByCompanyId(String strCompanyId) {
		DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
		Connection conn = dbcp.getConnection();
		OracleSQLBase.SQLSelecter sel = new OracleSQLBase.SQLSelecter("SNC01");
		sel.addSelect("*");
		sel.addStrCond("snc01_03", strCompanyId);

		logger.info(sel.toString());
		List<SNC01> lst = new ArrayList<SNC01>();
		try {
			PreparedStatement pst = conn.prepareStatement(sel.toString());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				SNC01 snc01 = new SNC01();
				snc01.setMachineName(rs.getString("SNC01_01"));
				snc01.setIp(rs.getString("SNC01_02"));
				snc01.setCompanyId(rs.getString("SNC01_03"));
				snc01.setMemo(rs.getString("SNC01_04"));
				snc01.setEnable(StringUtil.getString(rs.getString("SNC01_05")));
				snc01.setMac(rs.getString("SNC01_06"));
				snc01.setMins(rs.getString("SNC01_12"));
				lst.add(snc01);
			}
			DatabaseManagerBase.Close(rs, null, pst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return lst;
	}

	public static List<SNC01> getSNCX01sCompanyId() {
		DatabaseManagerC3P0 dbcp = DatabaseManagerC3P0.getInstance();
		Connection conn = dbcp.getConnection();
		String strSelect = "select distinct snc01_03 from snc01 where snc01_03 <> 'CIT' order by snc01_03";

		// logger.info(strSelect);
		List<SNC01> lst = new ArrayList<SNC01>();
		try {
			PreparedStatement pst = conn.prepareStatement(strSelect);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				SNC01 snc01 = new SNC01();
				snc01.setCompanyId(rs.getString("SNC01_03"));
				lst.add(snc01);
			}
			DatabaseManagerBase.Close(rs, null, pst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return lst;
	}
}

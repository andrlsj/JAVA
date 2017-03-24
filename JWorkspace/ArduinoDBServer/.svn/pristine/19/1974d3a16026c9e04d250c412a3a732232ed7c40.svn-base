package SQLite.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import data.Sql.OracleSQLBase;
import data.Sql.OracleSQLBase.SQLInserter;
import data.Sql.OracleSQLBase.SQLSelecter;
import db.dbmanager.DatabaseManagerBase;
import db.manager.SNC02;

public class SNC02Manager {
	private static Logger logger = Logger.getLogger(SNC02Manager.class);
	public static boolean save(Connection conn, SNC02 snc) {
		boolean bResult = false;
		SQLInserter ins = new OracleSQLBase.SQLInserter("SNC02");
		ins.addStrValue("SNC02_01", snc.getSncx02_01());
		ins.addStrValue("SNC02_02", snc.getSncx02_02());
		ins.addFloatValue("SNC02_03", snc.getSncx02_03());
		ins.addStrValue("SNC02_04", snc.getSncx02_04());
		ins.addSysdateValue("SNC02_05");
		logger.info(ins.toString());
		DatabaseManagerBase.Insert(conn, ins.toString());
		bResult = true;
		return bResult;
	}

	public static List<SNC02> getSNCX02s(Connection conn) {
		SQLSelecter sel = new OracleSQLBase.SQLSelecter("SNC02");
		sel.addSelect("*");

		List<SNC02> lstSNCX02 = new ArrayList<SNC02>();
		logger.info(sel.toString());
		try {
			PreparedStatement stat = conn.prepareStatement(sel.toString());
			ResultSet rs = stat.executeQuery();				
			while (rs.next()) {
				SNC02 snc = new SNC02();
				snc.setSncx02_01(rs.getString("SNC02_01"));
				snc.setSncx02_02(rs.getString("SNC02_02"));
				snc.setSncx02_03(rs.getInt("SNC02_03"));
				snc.setSncx02_04(rs.getString("SNC02_04"));
				lstSNCX02.add(snc);
			}
		} catch (SQLException e) {
			logger.error(e.toString());
		}
		return lstSNCX02;
	}

}

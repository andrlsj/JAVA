package SQLite.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Sql.SQLiteBase;
import data.Sql.SQLiteBase.SQLInserter;
import data.Sql.SQLiteBase.SQLSelecter;
import data.Sql.SQLiteBase.SQLUpdater;
import db.dbmanager.DatabaseManagerBase;
import db.dbmanager.SQLiteManager;
import db.manager.User;

public class UserManager {
	public static boolean Save(User usr) throws SQLException
	{
		Connection conn = SQLiteManager.getInstance().getConnection();
		boolean bResult = false;
		User usr0 = getUserById(conn, String.valueOf(usr.getId()));
		if(!usr0.getName().equals(""))
		{
			SQLUpdater upd = new SQLiteBase.SQLUpdater("User");
			upd.updateStrField("name", usr.getName());
			upd.updateStrField("email", usr.getEmail());
			upd.updateStrField("sex", usr.getSex());
			upd.updateStrField("tel", usr.getTel());
			upd.updateIntField("enable", usr.isEnable()?1:0);
			upd.updateStrField("serial", usr.getSerial());
			upd.updateStrField("memo", usr.getMemo());
			upd.updateTimeField("datetime");
			upd.addStrCond("id", usr.getId());
			System.out.println(upd.toString());
			DatabaseManagerBase.Update(conn, upd.toString());
			bResult=true;
		}else{	
			SQLInserter ins = new SQLiteBase.SQLInserter("User");
			ins.addStrValue("id", usr.getId());
			ins.addStrValue("name", usr.getName());
			ins.addStrValue("email", usr.getEmail());
			ins.addStrValue("tel", usr.getTel());
			ins.addStrValue("sex", usr.getSex());
			ins.addIntValue("enable", usr.isEnable()?1:0);
			ins.addStrValue("serial", Util.getString(usr.getSerial()));
			ins.addStrValue("memo", Util.getString(usr.getMemo()));
			ins.addSysdateValue("datetime");
			System.out.println(ins.toString());
			DatabaseManagerBase.Insert(conn, ins.toString());
			bResult = true;
		}
		DatabaseManagerBase.Close(null, null, null, conn);
		return bResult;
	}
	
	public static User getUserById(Connection con, String strUserId)
	{
		SQLSelecter sel = new SQLiteBase.SQLSelecter("User");
		sel.addSelect("*");
		sel.addStrCond("id", strUserId);
		User usr = new User();
		try {
			System.out.println(sel.toString());
			ResultSet rs = DatabaseManagerBase.Select(con, sel.toString());
			while (rs.next())
            {
				usr.setId(rs.getString("id"));
				usr.setName(rs.getString("name"));
				usr.setEmail(rs.getString("email"));
				usr.setSex(rs.getString("sex"));
				usr.setTel(rs.getString("tel"));
				usr.setEnable(rs.getBoolean("enable"));
				usr.setSerial(rs.getString("serial"));
				usr.setMemo(Util.getString(rs.getString("memo")));
				usr.setDatetime(Util.getDate(rs.getString("datetime")));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usr;
	}


	public static List<User> getUserByCompId(Connection conn, String strCompId)
	{
		SQLSelecter sel = new SQLiteBase.SQLSelecter("User");
		sel.addSelect("*");
		sel.addStrCond("compid", strCompId);
		List<User> lstEmps = new ArrayList<User>();
		System.out.println(sel.toString());
		try{
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());			
			while (rs.next())
			{
				User usr = new User();
				usr.setId(rs.getString("id"));
				usr.setName(rs.getString("name"));		
				usr.setEmail(rs.getString("email"));
				usr.setTel(rs.getString("tel"));
				usr.setSex(rs.getString("sex"));
				usr.setEnable(rs.getBoolean("enable"));
				usr.setSerial(rs.getString("serial"));
				usr.setDatetime(Util.getDate(rs.getString("datetime")));
				usr.setMemo(rs.getString("memo"));
				lstEmps.add(usr);
			} 	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstEmps;
	}

	public static List<User> getUserByLikeName(String strName)
	{
		Connection conn = SQLiteManager.getInstance().getConnection();
		SQLSelecter sel = new SQLiteBase.SQLSelecter("User");
		sel.addSelect("*");
		if(!strName.equals(""))
			sel.addLikeCond("name", "%" + strName + "%");
		List<User> lstEmps = new ArrayList<User>();
		System.out.println(sel.toString());
		try{
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());			
			while (rs.next())
			{
				User usr = new User();
				usr.setId(rs.getString("id"));
				usr.setName(rs.getString("name"));
				usr.setEmail(rs.getString("email"));				
				usr.setTel(rs.getString("tel"));
				usr.setSex(rs.getString("sex"));
				usr.setEnable(rs.getBoolean("enable"));
				usr.setSerial(rs.getString("serial"));
				usr.setDatetime(Util.getDate(rs.getString("datetime")));
				usr.setMemo(rs.getString("memo"));
				lstEmps.add(usr);
			} 	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseManagerBase.Close(null, null, null, conn);
		}
		return lstEmps;
	}
	
	public static List<User> getUserByLikeNameLoginName(String strName)
	{
		Connection conn = SQLiteManager.getInstance().getConnection();
		SQLSelecter sel = new SQLiteBase.SQLSelecter("User");
		sel.addSelect("*");
		if(!strName.equals(""))
		{
			sel.addLikeCond("name", "%" + strName + "%");	
		}
		List<User> lstEmps = new ArrayList<User>();

		try{
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString() + " or id like '%" + strName + "%'");			
			while (rs.next())
			{
				User usr = new User();
				usr.setId(rs.getString("id"));
				usr.setName(rs.getString("name"));
				usr.setEmail(rs.getString("email"));				
				usr.setTel(rs.getString("tel"));
				usr.setSex(rs.getString("sex"));
				usr.setEnable(rs.getBoolean("enable"));
				usr.setSerial(rs.getString("serial"));
				usr.setDatetime(Util.getDate(rs.getString("datetime")));
				usr.setMemo(rs.getString("memo"));
				lstEmps.add(usr);
			} 	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseManagerBase.Close(null, null, null, conn);
		}
		return lstEmps;
	}	
}

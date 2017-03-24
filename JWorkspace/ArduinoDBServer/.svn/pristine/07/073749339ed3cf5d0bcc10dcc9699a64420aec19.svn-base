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
import db.manager.Department;

public class DepartmentManager {
	public static void Save(Department dept) throws SQLException
	{
		Connection conn = SQLiteManager.getInstance().getConnection();
		Department dept0 = getDepartmentByIdOnly(conn, dept.getId());
		if(dept0.getId()!=null && dept0.getName()!=null)
		{
			SQLUpdater upd = new SQLiteBase.SQLUpdater("Department");
			upd.updateStrField("name", dept.getName());
			upd.updateStrField("company_id", dept.getCompId());
			upd.updateStrField("deptmgr", dept.getDeptMgr());
			upd.updateStrField("deputymgr1", dept.getDeputyMgr1());
			upd.updateStrField("deputymgr2", dept.getDeputyMgr2());
			upd.updateStrField("level", dept.getLevel());
			upd.updateStrField("dept_level", dept.getDept_level());
			upd.updateStrField("dept_level_desc", dept.getDept_level_desc());
			upd.updateStrField("deptorderby", dept.getDeptOrderBy());
			upd.updateTimeField("datetime");
			upd.addStrCond("id", dept.getId());
			DatabaseManagerBase.Update(conn, upd.toString());
		}else{	
			SQLInserter ins = new SQLiteBase.SQLInserter("Department");
			ins.addStrValue("id", dept.getId());
			ins.addStrValue("company_id", dept.getCompId());
			ins.addStrValue("name", dept.getName());
			ins.addStrValue("deptmgr", dept.getDeptMgr());
			ins.addStrValue("deputymgr1", dept.getDeputyMgr1());
			ins.addStrValue("deputymgr2", dept.getDeputyMgr2());
			//ins.addStrValue("level", dept.getLevel());
			ins.addStrValue("dept_level", dept.getDept_level());
			ins.addStrValue("dept_level_desc",  dept.getDept_level_desc());
			ins.addStrValue("deptorderby", dept.getDeptOrderBy());
			ins.addSysdateValue("datetime");
			DatabaseManagerBase.Insert(conn, ins.toString());		
		}
		DatabaseManagerBase.Close(null, null, null, conn);
	}
	
	private static Department getDepartmentByIdOnly(Connection conn, String strId)
	{
		SQLSelecter sel = new SQLSelecter("Department");
		sel.addSelect("*");
		sel.addStrCond("id", strId);
		Department dept = new Department();
		try {
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());
			while (rs.next())
            {
				dept.setId(rs.getString("id"));
				dept.setName(rs.getString("name"));
				dept.setCompId(rs.getString("company_id"));
				dept.setDeptMgr(rs.getString("deptmgr"));
				dept.setDeputyMgr1(rs.getString("deputymgr1"));
				dept.setDeputyMgr2(rs.getString("deputymgr2"));
				dept.setDeptOrderBy(rs.getString("deptorderby"));
				dept.setLevel(rs.getString("dept_level"));
				dept.setDept_level(rs.getString("dept_level"));
				dept.setDept_level_desc(rs.getString("dept_level_desc"));
				//dept.setDatetime(Util.getDate(rs.getString("datetime")));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}
	
	public static Department getDepartmentById(Connection con, String strId)
	{
		String strSQL = "select a.*, b.name deptMgrName from Department a, Employee b where a.deptmgr = b.id and a.id='" + strId + "'";
		Department dept = new Department();
		try {
			ResultSet rs = DatabaseManagerBase.Select(con, strSQL);
			while (rs.next())
            {
				dept.setId(rs.getString("id"));
				dept.setName(rs.getString("name"));
				dept.setCompId(rs.getString("company_id"));
				dept.setDeptMgr(rs.getString("deptmgr"));
				dept.setDeptMgrName(rs.getString("deptmgrname"));
				dept.setDeputyMgr1(rs.getString("deputymgr1"));
				dept.setDeputyMgr2(rs.getString("deputymgr2"));
				dept.setDeptOrderBy(rs.getString("deptorderby"));
				dept.setLevel(rs.getString("dept_level"));
				dept.setDept_level(rs.getString("dept_level"));
				dept.setDept_level_desc(rs.getString("dept_level_desc"));
				//dept.setDatetime(Util.getDate(rs.getString("datetime")));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}


	public static List<Department> getDepartmentsByCompId(String strCompId)
	{
		Connection conn = SQLiteManager.getInstance().getConnection();
		String strSQL = "select a.*, b.name deptMgrName from Department a, Employee b where a.deptmgr = b.id";
		if(!strCompId.equals(""))
			strSQL = strSQL + " and a.company_id = '"+ strCompId + "'";		
		List<Department> lstDepts = new ArrayList<Department>();
		System.out.println(strSQL);
		try{
			ResultSet rs = DatabaseManagerBase.Select(conn, strSQL.toString());			
			while (rs.next())
			{
				Department dept = new Department();
				dept.setId(rs.getString("id"));
				dept.setName(rs.getString("name"));
				dept.setCompId(rs.getString("company_id"));
				dept.setDeptMgr(rs.getString("deptmgr"));
				dept.setDeptMgrName(rs.getString("deptmgrname"));
				dept.setDeputyMgr1(rs.getString("deputymgr1"));				
				dept.setDeputyMgr2(rs.getString("deputymgr2"));
				dept.setDeptOrderBy(rs.getString("deptorderby"));
				dept.setLevel(rs.getString("level"));
				dept.setDept_level(rs.getString("dept_level"));
				dept.setDept_level_desc(rs.getString("dept_level_desc"));
				
				lstDepts.add(dept);
			} 	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseManagerBase.Close(null, null, null, conn);
		}
		return lstDepts;
	}
	
}

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
import db.manager.Company;

public class CompanyManager {
	public static void Save(Company comp) throws SQLException
	{
		Connection conn = SQLiteManager.getInstance().getConnection();
		Company comp0 = getCompanyById(conn, comp.getId());
		//System.out.println(comp0.toString());
		if(comp0.getId() !=null && comp0.getName()!=null)
		{
			SQLUpdater upd = new SQLiteBase.SQLUpdater("Company");
			upd.updateStrField("name", comp.getName());
			upd.updateStrField("ename", comp.getEname());
			upd.updateStrField("address", comp.getAddress());
			upd.updateStrField("address_in_eng",  comp.getAddressInEng());
			upd.updateStrField("tel", comp.getTel());
			upd.updateStrField("fax", comp.getFax());
			upd.updateStrField("nation", comp.getNation());
			upd.updateStrField("abbreviatedname", comp.getAbbreviatedName());
			upd.updateTimeField("datetime");
			upd.addStrCond("id", comp.getId());
			System.out.println(upd.toString());
			DatabaseManagerBase.Update(conn, upd.toString());
		}else{	
			SQLInserter ins = new SQLiteBase.SQLInserter("Company");
			ins.addStrValue("id", comp.getId());
			ins.addStrValue("name", comp.getName());
			ins.addStrValue("ename", comp.getEname());
			ins.addStrValue("address",  comp.getAddress());
			ins.addStrValue("address_in_eng", comp.getAddressInEng());
			ins.addStrValue("tel", comp.getTel());
			ins.addStrValue("fax", comp.getFax());
			ins.addStrValue("nation", comp.getNation());
			ins.addStrValue("abbreviatedname", comp.getAbbreviatedName());		
			ins.addSysdateValue("datetime");
			System.out.println(ins.toString());
			DatabaseManagerBase.Insert(conn, ins.toString());		
		}
		DatabaseManagerBase.Close(null, null, null, conn);
	}
	
	public static Company getCompanyById(Connection conn, String strId)
	{
		SQLSelecter sel = new SQLiteBase.SQLSelecter("Company");
		sel.addSelect("*");
		sel.addStrCond("id", strId);
		Company comp = new Company();
		try {
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());
			while (rs.next())
            {
                comp.setId(rs.getString("id"));
                comp.setName(rs.getString("name"));
                comp.setEname(rs.getString("ename"));
                comp.setAddress(rs.getString("address"));
                comp.setAddressInEng(rs.getString("address_in_eng"));
                comp.setTel(rs.getString("tel"));
                comp.setFax(rs.getString("fax"));
                comp.setNation(rs.getString("nation"));
                comp.setAbbreviatedName(rs.getString("abbreviatedName"));
                comp.setDatetime(Util.getDate(rs.getString("datetime")));
                
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comp;
	}


	public static List<Company> getAllCompany()
	{
		Connection conn = SQLiteManager.getInstance().getConnection();
		SQLSelecter sel = new SQLiteBase.SQLSelecter("Company");
		sel.addSelect("*");
		
		List<Company> lstCompanies = new ArrayList<Company>();
		System.out.println(sel.toString());
		try{
			ResultSet rs = DatabaseManagerBase.Select(conn, sel.toString());			
			while (rs.next())
			{
				Company comp = new Company();
				comp.setId(rs.getString("id"));
				comp.setName(rs.getString("name"));
				comp.setAbbreviatedName(rs.getString("abbreviatedName"));
				comp.setEname(rs.getString("ename"));	
                comp.setAddress(rs.getString("address"));
                comp.setAddressInEng(rs.getString("address_in_eng"));
                comp.setTel(rs.getString("tel"));
                comp.setFax(rs.getString("fax"));
                comp.setNation(rs.getString("nation"));		
                //System.out.println(rs.getString("datetime"));
				comp.setDatetime(Util.getDate(rs.getString("datetime")));

				lstCompanies.add(comp);
			} 	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseManagerBase.Close(null, null, null, conn);
		}
		return lstCompanies;
	}

}

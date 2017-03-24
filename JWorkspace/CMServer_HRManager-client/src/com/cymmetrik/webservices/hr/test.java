package com.cymmetrik.webservices.hr;





import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class test {

	/**
	 * @param args
	 */
	public static void main(String args[]) throws java.lang.Exception {
		// HRManager hrManager = new HRManager();
		//String strURL = "192.168.4.161";
		String strURL = "10.4.145.105";
		String strWsdlPath = "http://" + strURL + ":9000/HRManager?wsdl";

//		int i=0;
//		i = HRManager.getAllUnderEmpsNoByCompNoDeptNo(strURL, strWsdlPath, "CHQ", "CHQ3031");
//		System.out.println("Count: "+i);
		
		//createAllXML(strURL, strWsdlPath, Boolean.TRUE);

		//createAllXML(strURL, strWsdlPath, Boolean.FALSE);
		
		// List<Company> lstCompany =
		// HRManager.getAllCompany(strURL,strWsdlPath);
		// for (int i = 0; i < lstCompany.size(); i++) {
		// Company comp = lstCompany.get(i);
		// System.out.println(comp.getAbbreviatedName() + " " + comp.getName());
		// }
		//
		// List<Department> lstDepartment =
		// HRManager.getDepartmentsByCompanyNoDeptNo(strURL,strWsdlPath,"","","�L�e");
		// System.out.println("Department: "+lstDepartment.size());
		// for (int i = 0; i < lstDepartment.size(); i++) {
		// Department department = lstDepartment.get(i);
		// System.out.println(department.getDeptNo() + " " +
		// department.getDeptName() + " " + department.getSegSegmentNo());
		// //System.out.println(department.toString());
		// }
		//
		// List<Employee> lstEmployee =
		// HRManager.getEmployeesByCompanyNoAndDeptNo(strURL,strWsdlPath,"CHQ","3031",Boolean.FALSE);
		// System.out.println("Employee: "+lstEmployee.size());
		// for (int i = 0; i < lstEmployee.size(); i++) {
		// Employee employee = lstEmployee.get(i);
		// System.out.println(employee.getEmpName() + employee.getJobStatus() +
		// " " + employee.getEmpNo());
		// }

		// List<Employee> lstEmployee =
		// HRManager.getEmployeesByCompanyNoAndDeptNoAndJobStatus(strURL,strWsdlPath,"CHK","3031",Boolean.FALSE,1);
		// System.out.println("Employee: "+lstEmployee.size());
		// for (int i = 0; i < lstEmployee.size(); i++) {
		// Employee employee = lstEmployee.get(i);
		// System.out.println(employee.getEmpName() + employee.getJobStatus() +
		// employee.getSex());
		// }
		//
		 List<Employee> lstEmployee =
		 HRManager.getEmployeeByEmpNo(strWsdlPath,"010571");
		 System.out.println("Employee: "+lstEmployee.size());
		 for (int i = 0; i < lstEmployee.size(); i++) {
		 Employee employee = lstEmployee.get(i);
		 System.out.println(employee.getEmpName() + employee.getJobStatus() +
		 employee.getSex() + employee.getCompId());
		 }

		// List<Employee> lstEmployee =
		// HRManager.getAllUnderEmployeesByCompNoDeptNo(strURL,strWsdlPath,"","3031","��");
		// System.out.println("Employee: "+lstEmployee.size());
		// for (int i = 0; i < lstEmployee.size(); i++) {
		// Employee employee = lstEmployee.get(i);
		// System.out.println(employee.getEmpName() + employee.getJobStatus() +
		// employee.getDeptName() + employee.getCompId());
		// }

//		 List<Employee> lstEmployee2 =
//		 HRManager.getEmployeeByEmpName(strURL,strWsdlPath,"���@��");
//		 System.out.println("Employee: "+lstEmployee2.size());
//		 for (int i = 0; i < lstEmployee2.size(); i++) 
//		 {
//			 Employee employee = lstEmployee2.get(i);
//			 System.out.println(employee.getEmpName() + employee.getJobStatus() + employee.getSex() + employee.getCompId());
//		 }
		//
//		 List<Department> lstDepartment =
//		 HRManager.getDeptsByDeptNo(strURL,strWsdlPath,"3031");
//		 System.out.println("Department: "+lstDepartment.size());
//		 for (int i = 0; i < lstDepartment.size(); i++) {
//		 Department dept = lstDepartment.get(i);
//		 System.out.println(dept.getDeptName() + dept.getDeptNo() +
//		 dept.getSegSegmentNo());
//		 }

		// List<Department> lstDepartment2 =
		// HRManager.getDeptsByUpperDeptNo(strURL,strWsdlPath,"CHQ","4660");
		// System.out.println("Department: "+lstDepartment2.size());
		// for (int i = 0; i < lstDepartment2.size(); i++) {
		// Department dept = lstDepartment2.get(i);
		// System.out.println(dept.getDeptName() + dept.getDeptNo() +
		// dept.getSegSegmentNo());
		// }

		// List<Department> lstDepartment2 =
		// HRManager.getDeptsByCompNoDeptNo(strURL,strWsdlPath,"CHQ","3031","");
		// System.out.println("Department: "+lstDepartment2.size());
		// for (int i = 0; i < lstDepartment2.size(); i++) {
		// Department dept = lstDepartment2.get(i);
		// System.out.println(dept.getDeptName() + dept.getDeptNo() +
		// dept.getLevel());
		// }
		
//		 List<Employee> lstEmployee =
//		 HRManager.getAllUnderEmployeesByCompNoDeptNo(strWsdlPath,"CHQ","3031","");
//		 System.out.println("Employee: "+lstEmployee.size());
//		 for (int i = 0; i < lstEmployee.size(); i++) {
//		 Employee employee = lstEmployee.get(i);
//		 System.out.println(employee.getEmpName() + employee.getJobPlace() +
//		 employee.getDeptName() + employee.getCompId());
//		 }
	}

	private static void createAllXML(String strURL, String strWsdlPath, boolean bAddEmp) 
	{
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("tree");
		root.addAttribute("id", "0");

		List<Company> lstCompany = HRManager.getAllCompany(strWsdlPath);

		for (int i = 0; i < lstCompany.size(); i++) 
		{
			Company comp = lstCompany.get(i);
			if (!comp.getAbbreviatedName().contains("辦")) 
			{				
				addCompanyElement(strURL, strWsdlPath, root, comp, bAddEmp);
				//createCompXML(strURL, strWsdlPath, comp, bAddEmp);
			}			
		}
		for (int i = 0; i < lstCompany.size(); i++) 
		{
			Company comp = lstCompany.get(i);			
			if (comp.getAbbreviatedName().contains("辦")) 
			{
				addCompanyElement(strURL, strWsdlPath, root, comp, bAddEmp);
				//createCompXML(strURL, strWsdlPath, comp, bAddEmp);
			}
		}
		String strFilename = "all";
		if(bAddEmp)
		{
			strFilename = strFilename + "-EMP";
		}
		writeData2Xml(document.asXML(), strFilename + ".xml");
	}

	private static void createCompXML(String strURL, String strWsdlPath, Company comp, boolean bAddEmp) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("tree");
		root.addAttribute("id", "0");
		
		addCompanyElement(strURL, strWsdlPath, root, comp, bAddEmp);		
		
		String strFilename = comp.getSegSegmentNo();
		if(bAddEmp)
		{
			strFilename = "./Emp/" + strFilename + "-EMP";
		}else{
			strFilename = "./Dept/" + strFilename;
		}
		writeData2Xml(document.asXML(), strFilename + ".xml");
		System.out.println(strFilename + ".xml end.");
	}

	private static void createDeptXML(String strURL, String strWsdlPath, Company comp, Department dept, boolean bAddEmp) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("tree");
		root.addAttribute("id", "0");

		Element elem1 = root.addElement("item");
		elem1.addAttribute("text", dept.getDeptName());
		elem1.addAttribute("id", comp.getSegSegmentNo() + dept.getDeptNo());
		elem1.addAttribute("im0", "book_titel.gif");
		elem1.addAttribute("im1", "book.gif");
		elem1.addAttribute("im2", "book_titel.gif");
		addDepartmentElement(strURL, strWsdlPath, elem1, comp, dept, bAddEmp);

		String strFilename = comp.getSegSegmentNo() + dept.getDeptNo();
		if(bAddEmp)
		{
			strFilename = "./Emp/" + strFilename + "-EMP";
		}else{
			strFilename = "./Dept/" + strFilename;			
		}
		writeData2Xml(document.asXML(), strFilename + ".xml");
	}
	
	private static void addCompanyElement(String strURL, String strWsdlPath, Element elem1, Company comp,  boolean bAddEmp)
	{
		Element elem = elem1.addElement("item");
		elem.addAttribute("text", comp.getAbbreviatedName());
		elem.addAttribute("id", comp.getSegSegmentNo());
		elem.addAttribute("open", "1");
		elem.addAttribute("im0", "tombs.gif");
		elem.addAttribute("im1", "tombs.gif");
		elem.addAttribute("im2", "iconSafe.gif");
		elem.addAttribute("call", "1");
		elem.addAttribute("select", "1");

		Department dept0 = new Department();
		if(comp.getSegSegmentNo().startsWith("CHQ"))
			dept0.setDeptNo("1020");
		else
			dept0.setDeptNo("1000");
		addDepartmentElement(strURL, strWsdlPath, elem, comp, dept0, bAddEmp);	
	}

	private static void addDepartmentElement(String strURL, String strWsdlPath, Element elem1, Company comp, Department dept, boolean bAddEmp) 
	{
		if(bAddEmp)
		{
			addEmployeeElement(strURL, strWsdlPath, elem1, comp,dept);
		}	
		
		List<Department> lstDept2 = HRManager.getDeptsByUpperDeptNo(strWsdlPath, comp.getSegSegmentNo(), dept.getDeptNo());

		if (lstDept2.size() > 0) 
		{
			for (int k = 0; k < lstDept2.size(); k++) 
			{
				Department dept2 = lstDept2.get(k);
				Element elem2 = elem1.addElement("item");
				elem2.addAttribute("text", dept2.getDeptName());
				elem2.addAttribute("id",  dept2.getSegSegmentNo() + dept2.getDeptNo());
				elem2.addAttribute("im0", "book_titel.gif");
				elem2.addAttribute("im1", "book.gif");
				elem2.addAttribute("im2", "book_titel.gif");
				createDeptXML(strURL, strWsdlPath, comp, dept2, bAddEmp);
				addDepartmentElement(strURL, strWsdlPath, elem2, comp, dept2, bAddEmp);
			}
		}
	}

	private static void addEmployeeElement(String strURL, String strWsdlPath, Element elem1, Company comp, Department dept)
	{
		List<Employee> lstEmp = HRManager.getEmployeesByCompanyNoAndDeptNo(strWsdlPath, comp.getSegSegmentNo(), dept.getDeptNo(), Boolean.FALSE);
		if(lstEmp.size() > 0)
		{
			for (int k = 0; k < lstEmp.size(); k++) 
			{
				Employee emp = lstEmp.get(k);
				Element elem2 = elem1.addElement("item");
				elem2.addAttribute("text", emp.getEmpName());
				elem2.addAttribute("id", emp.getCompId() + emp.getEmpNo());
				elem2.addAttribute("im0", "book_titel.gif");
				elem2.addAttribute("im1", "book.gif");
				elem2.addAttribute("im2", "book_titel.gif");
			}			
		}
	}
	
 	public static boolean writeData2Xml(String strValue, String strTarget) {
		File outputFile = new File(strTarget);
		try {
			// BufferedWriter out = new BufferedWriter(new
			// FileWriter(outputFile,"UTF-8"));
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream(outputFile), "UTF-8");
			out.write(strValue);

			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}

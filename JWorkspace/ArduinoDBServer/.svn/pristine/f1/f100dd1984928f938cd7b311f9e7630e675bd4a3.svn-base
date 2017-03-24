package job;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import Util.DateUtil;
import db.dbmanager.DatabaseManagerC3P0;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import report.manager.DeviceManager;
import report.manager.PMManager;
import report.manager.TemperatureHumidityManager;
import report.model.Device;
import report.model.PM;
import report.model.TemperatureHumidity;

public class CreateDayReportsJob implements Job
{
	static String temperatureHumidityFileName = "./report/temperature_humidity.jrxml";
  	static String PMFileName = "./report/pm2.5.jrxml";
  	private static Logger logger = Logger.getLogger(CreateDayReportsJob.class);

	public static void main(String[] args) throws Exception
	{
		printAllTHReport();
	}
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		DOMConfigurator.configure("./config/log4j.xml"); 
		logger.info("CreateDayReportsJob run...");
		try
		{
			printAllTHReport();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void printAllTHReport() throws Exception
	{
		 DatabaseManagerC3P0 c3p0 = DatabaseManagerC3P0.getInstance();
		Connection conn = c3p0.getConnection();
		List<Device> lstTHDevice = DeviceManager.getTHDeviceInfo(conn);
		List<Device> lstPMDevice = DeviceManager.getPMDeviceInfo(conn);
		String strSTime = DateUtil.getCymmetrikDate(DateUtil.addDay(new Date(), -1)) + " 00:00:00";
		String strETime = DateUtil.getCymmetrikDate(DateUtil.addDay(new Date(), -1)) + " 23:59:59";
		
		for (int i=0; i<lstTHDevice.size(); ++i)
		{
			printReport(conn, strSTime, strETime, lstTHDevice.get(i), temperatureHumidityFileName);			
		}
		for (int i=0; i<lstPMDevice.size(); ++i)
		{
			printReport(conn, strSTime, strETime, lstPMDevice.get(i), PMFileName);			
		}
	}
	
	public static void printReport(Connection conn, String strSTime, String strETime, Device device, String fileName) throws Exception
	{
		logger.info(strSTime + " " + strETime + " " + device.toString() + " " + fileName);
		long startTime = System.currentTimeMillis();
		// 将报表的定义文件HelloWorld.jrxml编译成HelloWorld.jasper文件
		String jasperFile = JasperCompileManager.compileReportToFile(fileName);

		// 產生資料
		JRBeanCollectionDataSource beanColDataSource = null;
		if (device.getCategory().equals("T22"))
		{
			List<TemperatureHumidity> lstTemperatureHumidity = new ArrayList<TemperatureHumidity>();
			lstTemperatureHumidity = TemperatureHumidityManager.getTemperatureHumidity(conn, strSTime, strETime, device.getDeviceName());
			beanColDataSource = new JRBeanCollectionDataSource(lstTemperatureHumidity);
			logger.info("lstTemperatureHumidity: "+lstTemperatureHumidity.size());
		}
		else if (device.getCategory().equals("PM2.5"))
		{
			List<PM> lstPM = new ArrayList<PM>();
			lstPM = PMManager.getPM(conn, strSTime, strETime, device.getDeviceName());
			beanColDataSource = new JRBeanCollectionDataSource(lstPM);
			logger.info("lstPM: "+lstPM.size());
		}

		// Parameters
		Map<String, Object> params = new HashMap<String, Object>();
		// params.put("STM", "2016.03.09 00:00:00");
		// params.put("ETM", "2016.03.09 23:59:59");
		 params.put("ReportDate", strSTime.substring(0, 11) + device.getCompanyName());

		 logger.info("jasperFile: "+jasperFile);
		 jasperFile = jasperFile.substring(1);
		 logger.info("jasperFile: "+jasperFile);
		// 向HelloWorld.jasper文件中填充数据，这一步将生产出HelloWorld .jrprint文件
		String jrprintFile = JasperFillManager.fillReportToFile(jasperFile, params, beanColDataSource);
		logger.info("jrprintFile: "+jrprintFile);
		// 将.jrprint文件转换成HTML格式
		// JasperExportManager.exportReportToHtmlFile(jrprintFile);

		// 将.jrprint文件转换成HTML格式
		//String jrprintFile2 = jrprintFile.replace(".jrprint", "-" + DateUtil.getDateString(new Date()) + ".html");
		String jrprintFile2 = jrprintFile.replace(".jrprint", "-" + device.getDeviceName() + "-" + DateUtil.getDateString(DateUtil.addDay(new Date(), -1)) + ".html");
		
		logger.info("./webapps/"+jrprintFile2);
		JasperExportManager.exportReportToHtmlFile(jrprintFile, "./webapps/"+jrprintFile2);

		// 将.jrprint文件转换成PDF格式
		// JasperExportManager.exportReportToPdfFile(jrprintFile);
		// 将.jrprint文件转换成XML格式
		// JasperExportManager.exportReportToXmlFile(jrprintFile,false);

		// 将.jrprint文件转换成XLS格式(即Excel文件)，需要用到POI类库.
		// File sourceFile = new File(jrprintFile);
		// JasperPrint jasperPrint =
		// (JasperPrint)JRLoader.loadObject(sourceFile);
		// List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		// jasperPrintList.add(jasperPrint);
		// File destFile = new File(sourceFile.getParent(),
		// jasperPrint.getName() + ".xls");
		// JRXlsExporter exporter = new JRXlsExporter();
		// exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
		// exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(
		// destFile.toString()));
		// SimpleXlsxReportConfiguration configuration = new
		// SimpleXlsxReportConfiguration();
		// configuration.setOnePagePerSheet(false);
		// exporter.setConfiguration(configuration);
		// exporter.exportReport();
		long endTime = System.currentTimeMillis();
		long time = (endTime - startTime) / 1000;
		logger.info("success with " + time + " s");
		//System.out.println("success with " + time + " s");
	}
}
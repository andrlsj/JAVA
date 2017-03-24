package SysTray;

/*
 * ArduinoServer_Tray.java
 */

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import server.SimpleHttpServer;
import SQLite.manager.SettingManager;
import WSServer.WSServer;
import jetty.main.JettyFromConsole;
import job.TaskScheduler;

public class ArduinoDBServer_Tray
{
	private static Locale locale = null;
	private static ResourceBundle rb = null;
	private static HashMap<String, String> hm = SettingManager.getConfigHM();
	static String sSys = "";
	private static Logger logger = Logger.getLogger(ArduinoDBServer_Tray.class);
	
	private static String rbString(String strName)
	{
		return rb.getString(strName);
	}
	
	public static void main(String[] args)
	{
		DOMConfigurator.configure("./config/log4j.xml");
		// change Locale to Config.ini setting
		String sLocale = (String) hm.get("Locale");
		if (sLocale.equalsIgnoreCase("Japan")){
			locale = Locale.JAPAN;
		} else if (sLocale.equalsIgnoreCase("English")){
			locale = Locale.ENGLISH;
		} else if (sLocale.equalsIgnoreCase("Taiwan")){
			locale = Locale.TAIWAN;
		} else{
			locale = Locale.getDefault();
		}
		rb = ResourceBundle.getBundle("messages", locale);
		sSys = hm.get("SysName");
		// launch SysTray
		String sSysTray = (String) hm.get("SysTray");
		if (sSysTray.equalsIgnoreCase("Yes"))
		{
			/* Use an appropriate Look and Feel */
			try
			{
				//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				UIManager.put("TextArea.font", new FontUIResource("微軟正黑體", Font.PLAIN, 14));
			} catch (UnsupportedLookAndFeelException ex){
				ex.printStackTrace();
			} catch (IllegalAccessException ex){
				ex.printStackTrace();
			} catch (InstantiationException ex){
				ex.printStackTrace();
			} catch (ClassNotFoundException ex){
				ex.printStackTrace();
			}
			/* Turn off metal's use of bold fonts */
			UIManager.put("swing.boldMetal", Boolean.FALSE);
			// Schedule a job for the event-dispatching thread:
			// adding TrayIcon.
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					createAndShowGUI();
				}
			});
		}
		
		// launch httpserver
		String sHttpServer = (String) hm.get("HttpServer");
		if (sHttpServer.equalsIgnoreCase("Yes"))
		{
			try
			{
				int iPort = Integer.parseInt((String) hm.get("HttpServerPort"));
				SimpleHttpServer.HttpServer(iPort);
			}catch (Exception e){
				logger.error(e);
				e.printStackTrace();
			}
			logger.info("Http Server ready...");
		}
		
		// launch scheduler
		System.out.println(hm.toString());
		String sScheduler = (String) hm.get("Scheduler");
		if (sScheduler.equalsIgnoreCase("Yes"))
		{
			TaskScheduler scheduler = new TaskScheduler();
			try
			{
				scheduler.initJobs();
				scheduler.startScheduler();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		// launch WebServicesServer
		String sWSServer = (String) hm.get("WSServer");
		String sWSSecurity = (String) hm.get("WSSecurity");
		if (sWSServer.equalsIgnoreCase("Yes"))
		{
			try
			{
				String sWSIP = (String) hm.get("WSIP");
				String sWSPort = (String) hm.get("WSPort");
				new WSServer(sWSIP, sWSPort, sWSSecurity);
			}catch(Exception e){
				e.printStackTrace();
			}
			logger.info("Web Service Server ready...");
		}
		
		// launch Jetty Server
		String sJettyServer = (String) hm.get("JettyServer");
		if (sJettyServer.equalsIgnoreCase("Yes"))
		{
			int iJettyPort = Integer.parseInt((String) hm.get("JettyPort"));
			boolean bSSL = Boolean.parseBoolean((String) hm.get("JettySSL"));
			JettyFromConsole.start(iJettyPort, bSSL);
			logger.info("Jetty Server ready...");
		}
	}
	
	private static void Systray_close()
	{
//		logger.info("Closing...");
	}

	private static void createAndShowGUI()
	{
		if (!SystemTray.isSupported())
		{
			System.out.println(rbString("SystemTray is not supported"));
			return;
		}
		final Image image = Toolkit.getDefaultToolkit().getImage(
				"images/Color16.png");
		String sTmp = rbString("Tray icon");
		sTmp = sTmp.replaceAll("%SYS_NAME%", sSys);
		final TrayIcon trayIcon = new TrayIcon(image, sTmp);
		final SystemTray tray = SystemTray.getSystemTray();
		
        final JMenuItem aboutItem = new JMenuItem(rbString("About"));  
        final JMenuItem exitItem = new JMenuItem(rbString("Exit"));

		try
		{
			tray.add(trayIcon);
		}catch (AWTException e){
//			logger.error(rbString("TrayIcon could not be added"));
			return;
		}
		
		trayIcon.addMouseListener(new MouseAdapter() {  
		    @Override  
		    public void mouseReleased(MouseEvent e) {  
		        if (e.isPopupTrigger()) {  
		            final JPopupMenu pop = new JPopupMenu();  
		            pop.add(aboutItem);  
		            pop.addSeparator();
		            pop.add(exitItem);  
		            pop.setLocation(e.getX(), e.getY());  
		            pop.setInvoker(pop);  
		            pop.setVisible(true); 	            
		        }  
		    }  
		});

		trayIcon.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String sTmp = rbString("is running...");
				sTmp = sTmp.replaceAll("%SYS_NAME%", sSys);
				JOptionPane.showMessageDialog(null, sTmp);
			}
		});

		aboutItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// main program starts here
				StringBuilder sb = new StringBuilder();
				sb.append(rbString("AboutAuthor").replaceAll("%SYS_NAME%", sSys));
				JOptionPane.showMessageDialog(null, sb.toString());
			}
		});

		sTmp = hm.get("SysName");
		sTmp = sTmp.replaceAll("%SYS_NAME%", sSys);
		String sTmp2 = rbString("is running...");
		sTmp2 = sTmp2.replaceAll("%SYS_NAME%", sSys);
		trayIcon.displayMessage(sTmp, sTmp2, TrayIcon.MessageType.NONE);

		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				JFrame jFrame = new JFrame(rbString("Exit"));
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				String sPwd = JOptionPane.showInputDialog(rb
						.getString("Please enter exit password!"));

				if (sPwd != null)
				{
					if (sPwd.equals((String) hm.get("SysTrayPassword")))
					{
						String sTmp = rb
								.getString("Are you sure you want to exit?");
						sTmp = sTmp.replaceAll("%SYS_NAME%", sSys);
						String sTmp2 = rbString("Exit %SYS_NAME%?");
						sTmp2 = sTmp2.replaceAll("%SYS_NAME%", sSys);
						int bAns = JOptionPane.showConfirmDialog(jFrame, sTmp,
								sTmp2, JOptionPane.YES_NO_OPTION);

						if (bAns == JOptionPane.CLOSED_OPTION || bAns == JOptionPane.YES_OPTION)
						{							
							Systray_close();
							tray.remove(trayIcon);
							System.exit(0);
						}
					}else{
						JOptionPane.showMessageDialog(jFrame, rb.getString("Password error!!"));
					}
				}
			}
		});
	}

	// Obtain the image URL
	protected static Image createImage(String path, String description)
	{
		URL imageURL = ArduinoDBServer_Tray.class.getResource(path);
		if (imageURL == null)
		{
			return null;
		}else{
			return (new ImageIcon(imageURL, description)).getImage();
		}
	}
}

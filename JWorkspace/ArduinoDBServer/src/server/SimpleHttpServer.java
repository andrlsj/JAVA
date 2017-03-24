package server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.Headers;

@SuppressWarnings("restriction")
public class SimpleHttpServer
{
	private static Logger logger = Logger.getLogger(SimpleHttpServer.class);

	public static void main(String[] args)
	{
		try
		{
			HttpServer(81);
		} catch (Exception e)
		{
			logger.error(e);
			e.printStackTrace();
		}
	}

	public static void HttpServer(int iPort)
	{
		DOMConfigurator.configure("./config/log4j.xml");

		HttpServer server = null;
		try
		{
			server = HttpServer.create(new InetSocketAddress(iPort), 0);
			server.createContext("/info", new InfoHandler());
			server.createContext("/getfile", new GetFileHandler());
			server.createContext("/showfile", new ShowFileHandler());
			server.createContext("/showlog", new ShowFileHandler());
			server.createContext("/leave", new LeaveHandler());
			server.setExecutor(null); // creates a default executor
			server.start();
		} catch (IOException e)
		{
			logger.error(e);
			e.printStackTrace();
		}
	}

	static class InfoHandler implements HttpHandler
	{
		public void handle(HttpExchange t) throws IOException
		{
			String response = "<br>Use:<br> /getfile to download a plain file <br> /showfile to show a plain file<br> /showlog to show app.log<br> /leave to quit";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	static class GetFileHandler implements HttpHandler
	{

		public void handle(HttpExchange t) throws IOException
		{
			// String sFilename = (String)t.getAttribute("filename");
			String sQuery = t.getRequestURI().getQuery();
			String[] sName = sQuery.split("=");
			File file = new File(sName[1]);
			System.out.println(sName[1] + "  " + file.exists());

			byte[] bytearray = new byte[(int) file.length()];
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			bis.read(bytearray, 0, bytearray.length);

			// ok, we are ready to send the response.
			Headers h = t.getResponseHeaders();
			h.add("Content-Type", "application/plain");
			h.add("Content-Disposition", "attachment");
			h.add("Content-Disposition", "filename=" + sName[1]);

			t.sendResponseHeaders(200, file.length());
			bis.close();
			OutputStream os = t.getResponseBody();
			os.write(bytearray, 0, bytearray.length);
			os.close();
		}
	}

	static class ShowFileHandler implements HttpHandler
	{
		public void handle(HttpExchange t) throws IOException
		{
			String sQuery = t.getRequestURI().getQuery();
			String[] sName = { "", "./log/app.log" };
			// sName[1]="./log/app.log";
			File file = null;
			logger.debug("sQuery:" + sQuery);
			if (sQuery != null)
			{
				if (sQuery.lastIndexOf("=") > 0)
					sName = sQuery.split("=");
			}
			file = new File(sName[1]);
			logger.debug(sName[1] + "  " + file.exists());

			byte[] bytearray = new byte[(int) file.length()];
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			bis.read(bytearray, 0, bytearray.length);

			// logger.info(System.getProperty("line.separator"));
			/*
			 * for(int i=0;i<bytearray.length;i++) {
			 * if(bytearray[i]==Byte.parseByte("13"));
			 * bytearray[i]=Byte.parseByte("10"); }
			 */
			bis.close();
			t.sendResponseHeaders(200, file.length());

			OutputStream os = t.getResponseBody();
			os.write(bytearray, 0, bytearray.length);
			os.close();
		}
	}

	static class LeaveHandler implements HttpHandler
	{
		public void handle(HttpExchange t) throws IOException
		{
			System.exit(0);
		}
	}
}
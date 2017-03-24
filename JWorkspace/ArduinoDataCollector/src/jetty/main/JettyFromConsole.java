package jetty.main;

import java.awt.EventQueue;
import java.io.IOException;
import jetty.context.AppContextBuilder;
import jetty.server.JettyServer;
import net.MyComputer;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.ssl.SslSelectChannelConnector;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.ssl.SslContextFactory;

public class JettyFromConsole {
	public static void main(String[] args) {
		start(8080, false);	
	}
	
	public static void start(int iPort, boolean bSSL)
	{		
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[] { new AppContextBuilder().buildWebAppContext()});		
		
		final JettyServer jettyServer = new JettyServer(iPort);
		jettyServer.setHandler(contexts);
		if(bSSL)
			jettyServer.setConnector(getSSLHttpConnector());		
		
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				//new ServerRunner(jettyServer);
				try {
					jettyServer.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		EventQueue.invokeLater(runner);		
	}
	
	private static Connector getSSLHttpConnector(){
	  final SslContextFactory contextFactory=new SslContextFactory();
	  try {
		  //FileResource keyStoreResource = new FileResource(JettyFromConsole.class.getResource("/shihwenwei.jks"));
		  Resource keyStoreResource = Resource.newResource(JettyFromConsole.class.getResource("/shihwenwei.keystore"));
		  contextFactory.setKeyStoreResource(keyStoreResource);
			
	  } catch (IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	  contextFactory.setKeyStorePassword("wen030106");
	  contextFactory.setKeyManagerPassword("wen030106");
	  final SslSelectChannelConnector scc=new SslSelectChannelConnector(contextFactory);
	  scc.setPort(8443);
	  scc.setHost(MyComputer.getLocalIP());
		  
	  return scc;
	}
}

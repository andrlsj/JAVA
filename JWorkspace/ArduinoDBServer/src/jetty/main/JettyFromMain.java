package jetty.main;

import java.awt.EventQueue;
import jetty.context.AppContextBuilder;
import jetty.server.JettyServer;
import jetty.ui.ServerRunner;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

public class JettyFromMain {

	public static void main(String[] args) {
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		
		contexts.setHandlers(new Handler[] { new AppContextBuilder().buildWebAppContext()});
		
		final JettyServer jettyServer = new JettyServer();
		jettyServer.setHandler(contexts);
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				new ServerRunner(jettyServer);
				try {
					jettyServer.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		EventQueue.invokeLater(runner);			
	}
}

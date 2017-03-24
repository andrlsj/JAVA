package jetty.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

public class JettyServer {

	private Server server;
	
	public JettyServer() {
		this(8585);
	}
	public JettyServer(Integer runningPort) {
		server = new Server(runningPort);
	}
	
	public void setHandler(ContextHandlerCollection contexts) {
		server.setHandler(contexts);		
	}
	
	public void setConnector(Connector connector)
	{
		server.addConnector(connector);
	}
	
	public void start() throws Exception {
		server.start();
	}
	
	public void stop() throws Exception {
		server.stop();
		server.join();
	}
	
	public boolean isStarted() {
		return server.isStarted();
	}
	
	public boolean isStopped() {
		return server.isStopped();
	}
}

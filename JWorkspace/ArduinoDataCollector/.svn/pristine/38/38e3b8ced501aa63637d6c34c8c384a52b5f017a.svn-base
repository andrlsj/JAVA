package jetty.context;

import org.eclipse.jetty.webapp.WebAppContext;

public class AppContextBuilder {
	
	private WebAppContext webAppContext;
	
	public WebAppContext buildWebAppContext(){
		webAppContext = new WebAppContext();
		webAppContext.setResourceBase("./webapps/");
		webAppContext.setContextPath("/");
		webAppContext.setAttribute("webContext", webAppContext);		
		webAppContext.setDefaultsDescriptor("./config/webdefault.xml");
		return webAppContext;
	}
}

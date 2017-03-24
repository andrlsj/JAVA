/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package WSServer;

import org.apache.cxf.binding.BindingConfiguration;
import org.apache.cxf.binding.soap.Soap12;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
//import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import WebService.SNC01Manager;
import WebService.SNC02Manager;
import net.MyComputer;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WSServer
{
	private static Logger logger = Logger.getLogger(WSServer.class);

	private static final String WSU_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";

	public WSServer(String sIP, String sPort, String sWSSecurity) throws Exception
	{
		DOMConfigurator.configure("./config/log4j.xml");
		logger.info("Starting Web Services Server");

		createFactoryBean(sIP, sPort, "SNC01Manager", SNC01Manager.class,
				new SNC01Manager(), sWSSecurity);	
		createFactoryBean(sIP, sPort, "SNC02Manager", SNC02Manager.class,
				new SNC02Manager(), sWSSecurity);
	}

	private void createFactoryBean(String sIP, String sPort,
			String strBeanName, Class<?> classname, Object implementor, String sWSSecurity)
	{
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(classname);
		if (sIP.equals(""))
			sIP = MyComputer.getLocalIP();
		String strAddress = "http://" + sIP + ":" + sPort + "/" + strBeanName + "?wsdl";
		svrFactory.setAddress(strAddress);
		logger.info(strAddress);
		svrFactory.setServiceBean(implementor);
//		// for .NET
		// svrFactory.getFeatures().add(new WSAddressingFeature());
		// for soap12
		final Soap12 soap12 = Soap12.getInstance();

		BindingConfiguration config = new BindingConfiguration()
		{
			@Override
			public String getBindingId()
			{
				return soap12.getBindingId();
			}
		};
		svrFactory.setBindingConfig(config);
		svrFactory.setBindingId(soap12.getBindingId());

		svrFactory.getInInterceptors().add(new LoggingInInterceptor());
		svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
		
		if(sWSSecurity.equalsIgnoreCase("YES"))
			svrFactory.setBus(getBus());
		
		svrFactory.create();
	}

	private static Bus getBus()
	{
		SpringBusFactory bf = new SpringBusFactory();
		URL busFile = WSServer.class.getResource("wssec.xml");
		//logger.info("busFile: "+busFile.toString());
		Bus bus = bf.createBus(busFile.toString());
		String strPath = "WSServer/resources/";

		Map<String, Object> outProps = new HashMap<String, Object>();
		outProps.put("action", "UsernameToken Timestamp Signature Encrypt");

		outProps.put("passwordType", "PasswordText");
		outProps.put("user", "serverx509v1");
		outProps.put("passwordCallbackClass",
				"WSServer.UTPasswordCallback");

		// If you are using the patch WSS-194, then uncomment below two lines
		// and
		// comment the above "user" prop line.
		// outProps.put("user", "Alice");
		// outProps.put("signatureUser", "serverx509v1");

		outProps.put("encryptionUser", "clientx509v1");
		outProps.put("encryptionPropFile", strPath +"etc/Server_SignVerf.properties");
		outProps.put("encryptionKeyIdentifier", "IssuerSerial");
		outProps.put("encryptionParts", "{Element}{" + WSU_NS + "}Timestamp;"
				+ "{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");

		outProps.put("signaturePropFile", strPath + "etc/Server_Decrypt.properties");
		outProps.put("signatureKeyIdentifier", "DirectReference");
		outProps.put("signatureParts", "{Element}{" + WSU_NS + "}Timestamp;"
				+ "{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body");

		bus.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));

		Map<String, Object> inProps = new HashMap<String, Object>();

		inProps.put("action", "UsernameToken Timestamp Signature Encrypt");
		inProps.put("passwordType", "PasswordDigest");
		inProps.put("passwordCallbackClass", "WSServer.UTPasswordCallback");

		inProps.put("decryptionPropFile", strPath + "etc/Server_Decrypt.properties");
		inProps.put("encryptionKeyIdentifier", "IssuerSerial");

		inProps.put("signaturePropFile", strPath + "etc/Server_SignVerf.properties");
		inProps.put("signatureKeyIdentifier", "DirectReference");

		bus.getInInterceptors().add(new WSS4JInInterceptor(inProps));

		return bus;
	}

	public static void main(String args[]) throws Exception
	{
		new WSServer("192.168.10.85", "8888","No");
		logger.info("Web Services Server ready...");

		Thread.sleep(5 * 60 * 1000);
		logger.info("Web Services Server exiting");
		System.exit(0);
	}
}

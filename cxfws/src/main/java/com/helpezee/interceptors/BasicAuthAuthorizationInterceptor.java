package com.helpezee.interceptors;



import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BasicAuthAuthorizationInterceptor extends AbstractSoapInterceptor {

	public BasicAuthAuthorizationInterceptor() {
		super(Phase.INVOKE);
	}

	public void handleMessage(SoapMessage message) throws Fault {

		 List <Header> list = message.getHeaders();
	     for (Header header : list) {
	       System.out.println(header.getName() + " = " + header.toString());
	     }

		
		DocumentBuilder builder = null;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = builder.newDocument();

		Element eSecure = doc.createElement("Secured");

		Element eUser = doc.createElement("user");
		eUser.setTextContent("myuser");

		Element ePassword = doc.createElement("password");
		ePassword.setTextContent("password");

		eSecure.appendChild(eUser);
		eSecure.appendChild(ePassword);
		// Create Header object
		QName qnameCredentials = new QName("Secured");
		Header header = new Header(qnameCredentials, eSecure);
		message.getHeaders().add(header);
	}

}

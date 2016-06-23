package com.helpezee.interceptors;


import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

import com.helpezee.dto.Secured;

public class SetAuthorizationInfoInterceptor extends AbstractSoapInterceptor {

	public SetAuthorizationInfoInterceptor() {
		super(Phase.INVOKE);
	}

	public void handleMessage(SoapMessage message) throws Fault {
		
		/*DocumentBuilder builder = null;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = builder.newDocument();

		Element eSecure = doc.createElement("Secured");

		Element eUser = doc.createElement("user");
		eUser.setTextContent("satya");

		Element ePassword = doc.createElement("password");
		ePassword.setTextContent("satya");

		eSecure.appendChild(eUser);
		eSecure.appendChild(ePassword);*/
		Secured sec = new Secured();
		sec.setPassword("satya");
		sec.setPassword("pampana");
		// Create Header object
		QName qnameCredentials = new QName("Secured");
		Header header = new Header(qnameCredentials, sec);
		message.getHeaders().add(header);
	}

}

package com.helpezee.interceptors;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Node;

import com.helpezee.dto.Secured;

public class BasicAuthAuthorizationInterceptor extends AbstractSoapInterceptor {

	public BasicAuthAuthorizationInterceptor() {
		super(Phase.INVOKE);
	}

	public void handleMessage(SoapMessage message) throws Fault {

		List<Header> headers = message.getHeaders();
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(Secured.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (headers != null) {
			for (Header h : headers) {
				Object o = h.getObject();

				// Unwrap the node using JAXB
				if (o instanceof Node) {
					try {
						o = context.createUnmarshaller().unmarshal((Node) o);
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (o instanceof Secured) {
					// Do whatever is required with the header object instance
					Secured sec = (Secured) o;
					System.out.println("UserName---" + sec.getUsername());
					System.out.println("Password---" + sec.getPassword());
					if ("satya".equals(sec.getUsername()) && "satya".equals(sec.getPassword())) {
					} else {

						System.out.println("Authentication failed");
						throw new RuntimeException("Authentication failed : Invalid Authentication Credentails");

					}
				}
			}
		}

		
	}

}



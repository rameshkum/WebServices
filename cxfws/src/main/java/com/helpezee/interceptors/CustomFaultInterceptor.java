package com.helpezee.interceptors;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

public class CustomFaultInterceptor extends AbstractSoapInterceptor {
	public CustomFaultInterceptor() {
		super(Phase.MARSHAL);
	}

	public void handleMessage(SoapMessage message) throws Fault {
		Fault fault = (Fault) message.getContent(Exception.class);
		fault.setDetail(createDetailSomehow());
	}

	private Element createDetailSomehow() {
		// TODO Auto-generated method stub
		return null;
	}
}
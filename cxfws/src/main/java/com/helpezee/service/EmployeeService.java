package com.helpezee.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutFaultInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import com.helpezee.dto.Employee;

@WebService
@InInterceptors(interceptors = {"org.apache.cxf.interceptor.LoggingInInterceptor" ,"com.helpezee.interceptors.BasicAuthAuthorizationInterceptor" })
@OutInterceptors(interceptors = {"org.apache.cxf.interceptor.LoggingOutInterceptor"})
@OutFaultInterceptors (interceptors = {"org.apache.cxf.interceptor.FaultOutInterceptor" }) 
@SOAPBinding(parameterStyle = ParameterStyle.BARE)
public interface EmployeeService {
	@WebMethod
	public Employee getEmployeeInfo(Employee emp);

}
